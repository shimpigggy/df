package org.techtown.capstoneproject.tab;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import org.techtown.capstoneproject.R;

import static android.app.Activity.RESULT_OK;

/**
 * Created by ShimPiggy on 2018-05-07.
 */

public class Fragment_Search extends Fragment {
    private static final int PICK_FROM_CAMERA = 0;
    private static final int PICK_FROM_ALBUM = 1;
    private static final int CROP_FROM_CAMERA = 2;
    public static final int MEDIA_TYPE_IMAGE = 10;

    private Uri mImageCaptureUri;
    private Uri fileUri;

    private Button btn_name;
    private Button btn_detail;
    private Button btn_barcode;
    private Button btn_wirte;

    private static String FileName;

    public Fragment_Search() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);

        Init(view);
        buttonSetting();

        return view;
    }

    public void Init(View view) {
        btn_name = (Button) view.findViewById(R.id.btn_name);
        btn_detail = (Button) view.findViewById(R.id.btn_detail);
        btn_barcode = (Button) view.findViewById(R.id.btn_barcode);
        btn_wirte = (Button) view.findViewById(R.id.btn_write);
    }//init

    public void buttonSetting() {
        btn_name.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                ButtonNameListener(v);
            }
        });

        btn_detail.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                ButtonDetailListener(v);
            }
        });

        btn_barcode.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(v.getContext(),"Barcode!",Toast.LENGTH_SHORT).show();

                //ButtonBarcodeListener(v);
            }
        });

        btn_wirte.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(v.getContext(),"click!",Toast.LENGTH_SHORT).show();

                //  ButtonWriteListener(v);
            }
        });
    }//buttonSetting

    public void ButtonNameListener(View v) {
        DialogInterface.OnClickListener cameraListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                doTakePhotoAction();
            }
        };

        /*
        //갤러리에서 사진 가져오기
        DialogInterface.OnClickListener albumListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                doTakeAlbumAction();
            }
        };*/

        DialogInterface.OnClickListener cancelListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        };

        new AlertDialog.Builder(getActivity())
                .setTitle("업로드할 이미지 선택")
                .setPositiveButton("사진촬영", cameraListener)
                //       .setNeutralButton("앨범선택", albumListener)
                .setNegativeButton("취소", cancelListener)
                .show();
    }//ButtonNameListener

    public void ButtonDetailListener(View v) {
        DialogInterface.OnClickListener cameraListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                doTakePhotoAction();
            }
        };

        /*
        //갤러리에서 사진 가져오기
        DialogInterface.OnClickListener albumListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                doTakeAlbumAction();
            }
        };*/

        DialogInterface.OnClickListener cancelListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        };

        new AlertDialog.Builder(getActivity())
                .setTitle("업로드할 이미지 선택")
                .setPositiveButton("사진촬영", cameraListener)
                //       .setNeutralButton("앨범선택", albumListener)
                .setNegativeButton("취소", cancelListener)
                .show();
    }//ButtonDetailListener

    public void ButtonBarcodeListener(View v) {
        DialogInterface.OnClickListener cameraListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                doTakePhotoAction();
            }
        };

        /*
        //갤러리에서 사진 가져오기
        DialogInterface.OnClickListener albumListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                doTakeAlbumAction();
            }
        };*/

        DialogInterface.OnClickListener cancelListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        };

        new AlertDialog.Builder(getActivity())
                .setTitle("업로드할 이미지 선택")
                .setPositiveButton("사진촬영", cameraListener)
                //       .setNeutralButton("앨범선택", albumListener)
                .setNegativeButton("취소", cancelListener)
                .show();
    }//ButtonBarcodeListener

    public void ButtonWriteListener(View v) {
        DialogInterface.OnClickListener cameraListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                doTakePhotoAction();
            }
        };

        /*
        //갤러리에서 사진 가져오기
        DialogInterface.OnClickListener albumListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                doTakeAlbumAction();
            }
        };*/

        DialogInterface.OnClickListener cancelListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        };

        new AlertDialog.Builder(getActivity())
                .setTitle("업로드할 이미지 선택")
                .setPositiveButton("사진촬영", cameraListener)
                //       .setNeutralButton("앨범선택", albumListener)
                .setNegativeButton("취소", cancelListener)
                .show();
    }//ButtonWriteListener


    /**
     * 카메라에서 이미지 가져오기
     */
    private void doTakePhotoAction() {
        //촬영 후 이미지 가져오기
    /*
     * 참고 해볼곳
     * http://2009.hfoss.org/Tutorial:Camera_and_Gallery_Demo
     * http://stackoverflow.com/questions/1050297/how-to-get-the-url-of-the-captured-image
     * http://www.damonkohler.com/2009/02/android-recipes.html
     * http://www.firstclown.us/tag/android/
     */
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        // 임시로 사용할 파일의 경로를 생성
        String url = "tmp_" + String.valueOf(System.currentTimeMillis()) + ".jpg";

        mImageCaptureUri = Uri.fromFile(new File(Environment.getExternalStorageDirectory(), url));
        // fileUri = getOutputMediaFileUri(MEDIA_TYPE_IMAGE);
        // mImageCaptureUri = getOutputMediaFileUri(MEDIA_TYPE_IMAGE);

        intent.putExtra(android.provider.MediaStore.EXTRA_OUTPUT, mImageCaptureUri);
        //intent.putExtra(android.provider.MediaStore.EXTRA_OUTPUT,fileUri);

        // 특정기기에서 사진을 저장못하는 문제가 있어 다음을 주석처리 합니다.
        //intent.putExtra("return-data", true);
        startActivityForResult(intent, PICK_FROM_CAMERA);
    }//doTakePhotoAction

    /**
     * 앨범에서 이미지 가져오기
     */
    /*
    private void doTakeAlbumAction()
    {
        // 앨범 호출
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType(android.provider.MediaStore.Images.Media.CONTENT_TYPE);
        startActivityForResult(intent, PICK_FROM_ALBUM);
    }//doTakeAlbumAction
    */
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode != RESULT_OK) {
            return;
        }

        switch (requestCode) {
            case CROP_FROM_CAMERA: {
                // 크롭이 된 이후의 이미지를 넘겨 받습니다.
                // 이미지뷰에 이미지를 보여준다거나 부가적인 작업 이후에
                final Bundle extras = data.getExtras();//전체 사진

                if (extras != null) {
                    Bitmap photo = extras.getParcelable("data");//crop된 bitmap
                }

                // 임시 파일 삭제
                File f = new File(mImageCaptureUri.getPath());
                if (f.exists()) {
                    f.delete();
                }

                break;
            }

           /* case PICK_FROM_ALBUM: {
                // 이후의 처리가 카메라와 같으므로 일단  break없이 진행합니다.
                // 실제 코드에서는 좀더 합리적인 방법을 선택하시기 바랍니다.

                mImageCaptureUri = data.getData();
            }*/

            case PICK_FROM_CAMERA: {
                // 이미지를 가져온 이후의 리사이즈할 이미지 크기를 결정합니다.
                // 이후에 이미지 크롭 어플리케이션을 호출하게 됩니다.

                Intent intent = new Intent("com.android.camera.action.CROP");
                intent.setDataAndType(mImageCaptureUri, "image/*");

                //crop한 이미지를 저장할 때
                intent.putExtra("outputX", 300);//crop한 이미지의 x축
                intent.putExtra("outputY", 300);//crop한 이미지의 y축
                intent.putExtra("aspectX", 1);//crop박스의 x축 비율
                intent.putExtra("aspectY", 1);//crop박스의 y축 비율
                intent.putExtra("scale", true);
                intent.putExtra("return-data", true);
                startActivityForResult(intent, CROP_FROM_CAMERA);

                break;
            }
        }
    }


    /**
     * Create a file Uri for saving an image
     */

    private static Uri getOutputMediaFileUri(int type) {
        return Uri.fromFile(getOutputMediaFile(type));
    }

    private static File getOutputMediaFile(int type) {
        // To be safe, you should check that the SDCard is mounted
        // using Environment.getExternalStorageState() before doing this.

        File mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES), "MyCameraApp");
        // This location works best if you want the created images to be shared
        // between applications and persist after your app has been uninstalled.
        // Create the storage directory if it does not exist
        if (!mediaStorageDir.exists()) {
            if (!mediaStorageDir.mkdirs()) {
                Log.d("MyCameraApp", "failed to create directory");
                return null;
            }
        }

        // Create a media file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        FileName = "IMG_" + timeStamp + ".jpg";

        File mediaFile;
        if (type == MEDIA_TYPE_IMAGE) {
            mediaFile = new File(mediaStorageDir.getPath() + File.separator +
                    FileName);
        } else {
            return null;
        }

        return mediaFile;
    }//getOutputMediaFile
}//Fragment_Search
