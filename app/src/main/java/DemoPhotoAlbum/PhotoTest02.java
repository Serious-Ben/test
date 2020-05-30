package DemoPhotoAlbum;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Camera;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.empirejdesign.funnytoturial.R;

import java.io.IOException;

public class PhotoTest02 extends AppCompatActivity implements SurfaceHolder.Callback{

    private SurfaceView mSurfaceView;
    private SurfaceHolder mSurfaceHolder;
    private Camera camera;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_test02);

        mSurfaceView = (SurfaceView) this.findViewById(R.id.preview);
        mSurfaceHolder = mSurfaceView.getHolder();
        mSurfaceHolder.addCallback(this);


    }


    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        camera = Camera.open();
        try {
            camera.setPreviewDisplay(holder);
        } catch (IOException e) {
            camera.release();
            camera = null;
        }
        Log.d("MYLOG","SurfaceView is Creating!");
    }


    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        Log.d("MYLOG","SurfaceView is Change!");
        camera.startPreview();
    }



    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        Log.d("MYLOG","SurfaceView is Destroyed!");
        camera.release();
        camera = null;
    }
}
