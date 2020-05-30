package DemoPhotoAlbum;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;

import com.empirejdesign.funnytoturial.MainActivity;
import com.empirejdesign.funnytoturial.R;

import android.os.Environment;
import android.provider.MediaStore;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import android.widget.Toast;


public class PhotoTest extends AppCompatActivity {


    public static final int CROP_PHOTO = 2;
    private ImageView showImage;

    //圖片路徑
    private Uri imageUri;

    //圖片名稱
    private String filename;
    private TextView lbl_imgpath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_test);





        showImage = (ImageView) findViewById(R.id.imgpic);
        lbl_imgpath = (TextView)findViewById(R.id.lblimgpath);
    }

    public void prc_camera(View v)
    {
        //圖片名稱，用時間格式(年月日時分秒)來命名，這樣的命名，就不會重覆的情況。
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date = new Date(System.currentTimeMillis());
        filename = format.format(date);

        //建立File 對象用予存儲拍照的圖片SD卡根目錄，存儲至DCIM文件夾。
        File path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
        File outputImage = new File(path,filename+".jpg");

        try {
            if(outputImage.exists()) {
                outputImage.delete();
            }

            outputImage.createNewFile();

        } catch(IOException e) {
            e.printStackTrace();
        }

        //將File對像轉換為Uri並啟動照相程序
        imageUri = Uri.fromFile(outputImage);

        //啟動照相功能
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        //指定圖片輸出地方。
        intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);

        //拍完照startActivityForResult() 結果返回onActivityResult() 函數
        startActivityForResult(intent,CROP_PHOTO);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode != RESULT_OK) {
            Toast.makeText(PhotoTest.this, "ActivityResult resultCode error", Toast.LENGTH_SHORT).show();
            return;
        }

        switch(requestCode) {
            case CROP_PHOTO:
                try {

                    //圖片解析成Bitmap
                    Bitmap bitmap = BitmapFactory.decodeStream(
                            getContentResolver().openInputStream(imageUri));

                    //刷新DCIM文件夾，儲存檔案至DCIM文件夾。
                    Intent intentBcc = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
                    intentBcc.setData(imageUri);
                    this.sendBroadcast(intentBcc);

                    lbl_imgpath.setText(imageUri.toString());

                    //將照片顯示出來
                    showImage.setImageBitmap(bitmap);

                } catch(FileNotFoundException e) {
                    e.printStackTrace();
                }

                break;
            default:
                break;
        }







    }
}
