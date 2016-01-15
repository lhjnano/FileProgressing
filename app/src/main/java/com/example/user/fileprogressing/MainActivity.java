package com.example.user.fileprogressing;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.HashMap;

/**
 * 사용자에게 Socket, Bluetooth, NFC에 관한 이미지 전송 프로그램을 제공
 */

public class MainActivity extends AppCompatActivity {

    ImageList_Adapter imageList_adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /**
         * 이미지 파일 리스트를 생성하여 사용자에게 제공
         */
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1) 리스트 뷰 어덥테 생성
        imageList_adapter = new ImageList_Adapter();

        // 2) 리스트 레이아웃 불러오기
        ListView listView = (ListView)findViewById(R.id.main_listview);

        //3) 리스트뷰에 레이아웃 연결
        listView.setAdapter(imageList_adapter);

        // 4) 이미지 파일 이름을 기준으로 리스트 값 추가
        FileManager fileManager = new FileManager();
        HashMap<String, String[]> fileMap = fileManager.getFileMap();
        for(String uuid : fileMap.keySet()){
            imageList_adapter.add(uuid, fileMap.get(uuid));
        }

        // TODO 5) 다이얼로그에 리스트 대입 및 리스너 등록


        // 6) 다이얼 로그 실행
    }
}
