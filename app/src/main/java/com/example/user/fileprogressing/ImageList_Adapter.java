package com.example.user.fileprogressing;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *  이미지 리스트뷰 어뎁터
 */

public class ImageList_Adapter extends BaseAdapter {
    ArrayList<String> list;
    HashMap<String , String[]> fileMap;

    public ImageList_Adapter(){
        list = new ArrayList<String>();
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        /**
         * 어뎁터가 가지는 모든 뷰들을 리스트로 뿌려주기 위해서 하나씩 각 뷰의 값들을 반환하는 메서드
         * @position : 현재 뷰의 위치 값
         * @convertView : 현재 뷰
         * @convertView : 부모 그룹뷰 (리스트뷰)
         */

        final Context context =  parent.getContext();
        // 1) 객체 지시자 생성
        Holder holder;
        ImageView imageView;
        TextView textView;

        // 2) 각 객체가 null 일때의 자기 자신에 관한 구현
        if( convertView == null) {
            // 2-1) 각 레이아웃 불러오기
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.imagelist_layout, parent, false);
            textView = (TextView)convertView.findViewById( R.id.imagelist_textview );
            imageView = (ImageView)convertView.findViewById(R.id.imagelist_imageview);

            // 2-2) 홀더 생성 및 각 멤버 변수 대입
            holder = new Holder();
            holder.textView = textView;
            holder.imageView = imageView;
            convertView.setTag(holder);
        }
        // 3) 있던 객체면 위에서 지정한 지시자의 값을 명확히 설정
        else {
            holder = (Holder)convertView.getTag();
            imageView = holder.imageView;
            textView = holder.textView;
        }

        // 4) 각 멤버 변수 값 등록
        textView.setText(list.get(position));
        textView.dispatchDisplayHint(View.INVISIBLE);
        imageView.setImageBitmap(null);

        return convertView;
    }

    public void add(String uuid, String[] fileData) {
        fileMap.put(uuid, fileData);
    }
    public void remove(String uuid) {
        fileMap.remove( uuid );
    }
    private class Holder {
        /**
         *  스크롤 시 데이터가 변경 되는 것과 findViewById()를
         *  사용을 줄여 향상 된 속도를 얻기 위함
         */
        TextView textView;
        ImageView imageView;
    }
}
