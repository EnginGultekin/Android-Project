package com.engleg.artbook;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Toast;

import com.engleg.artbook.databinding.ActivityArtBinding;
import com.google.android.material.snackbar.Snackbar;

public class ArtActivity extends AppCompatActivity {

    private ActivityArtBinding binding;
    ActivityResultLauncher<Intent> activityResultLauncher;  // Galeriye gitmek için
    ActivityResultLauncher<String> permissionLauncher;      // İzin istemek için
    Bitmap selectedimage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityArtBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
    }

    public void save(View view){

    }

    //İzin Var mı Yok mu Varsa ne yapılacak yoksa ne yapılacak onların hepsini byrda yazdık
    public void selectImage(View view){
        // Burda izin var mı yok mu onun kontrolunü yaptık
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
            if(ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.READ_EXTERNAL_STORAGE)){
                // Aşağıdaki satır uygulmada izin verilmeyince çıkan Toast mesajı gibi bir şey
                Snackbar.make(view,"Permission is Needed for Gallery",Snackbar.LENGTH_INDEFINITE).setAction("Give Permission", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //Request Permission
                    }
                });

            }
            else{
                //Request Permission
            }

        }
        else{
            // Go Gallery
            //İlk sorulduğunda onaylanırsa burdan hemen galeriye gidecektir
            Intent intentToGallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        }
    }

    /* Eğer yukarıdaki izin sorulduğunda izin verilmezse burası  devreye girer ve iznin gerekli
     olduğunu söyler ve bidaha sorar yine reddedilirse izin verene kadar galeriye erişim sağlanmaz. */
    private void registerLauncher(){

        activityResultLauncher =registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                if(result.getResultCode() == RESULT_OK){
                    Intent intentFromResult = result.getData();
                    if (intentFromResult != null){
                        Uri imageData = intentFromResult.getData();
                        //binding.imageView.setImageURI(imageData);

                        try {  // if blogu eğer SDK sürümü 28 den buyuk ise çalışacak kodlar için
                            if (Build.VERSION.SDK_INT >= 28) {
                                ImageDecoder.Source source = ImageDecoder.createSource(getContentResolver(), imageData);
                                selectedimage = ImageDecoder.decodeBitmap(source);
                                binding.imageView.setImageBitmap(selectedimage);
                            }
                            // else blogu ise SDK sürümü 28 küçük ise çalışacaktır.
                            else{
                                selectedimage = MediaStore.Images.Media.getBitmap(ArtActivity.this.getContentResolver(),imageData);
                                binding.imageView.setImageBitmap(selectedimage);
                            }

                        }catch (Exception e){
                            e.printStackTrace();
                        }

                    }
                }
            }
        });

        permissionLauncher = registerForActivityResult(new ActivityResultContracts.RequestPermission(), new ActivityResultCallback<Boolean>() {
            @Override
            public void onActivityResult(Boolean result) {
                if (result){
                   //Permission Granted
                    //  Eğer başta reddedilirse burda bidaha soruduğunda onaylanırsa direkt galeriye gidecektir
                    Intent intentToGallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                }
                else{
                    //Permission Denied
                    //Eğer bidaha red yerse burda Toast Message olarak izin gerekli yazacaktır
                    Toast.makeText(ArtActivity.this, "Permission Needed", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

}