package com.example.foodapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import androidx.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.foodapp.fcm.PushNotification;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {


    private EditText edtR_Email, edtR_Password, edtR_FullName, edtR_Address, edtR_Phone;
    private String URL = "http://192.168.44.101:8080/sqlfood/register.php";
    private String email, password, fullName, address, phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        edtR_Email = findViewById(R.id.edtR_Email);
        edtR_Password = findViewById(R.id.edtR_Password);
        edtR_FullName = findViewById(R.id.edtR_FullName);
        edtR_Address = findViewById(R.id.edtR_Address);
        edtR_Phone = findViewById(R.id.edtR_Phone);
        email = password = fullName = address = phone = "";
    }

    public void save(View view) {
        fullName = edtR_FullName.getText().toString().trim();
        email = edtR_Email.getText().toString().trim();
        password = edtR_Password.getText().toString().trim();
        address = edtR_Address.getText().toString().trim();
        phone = edtR_Phone.getText().toString().trim();

        if (!email.equals("") && !password.equals("") && !fullName.equals("") && !address.equals("") && !phone.equals("")) {
            StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    if (response.equals("Success")) {
                        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                        startActivity(intent);
                        sendNotification();
                        finish();
                    } else if (response.equals("Failure")) {
                        Toast.makeText(RegisterActivity.this, "Đăng ký thất bại", Toast.LENGTH_SHORT).show();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(getApplicationContext(), error.toString().trim(), Toast.LENGTH_SHORT).show();
                }
            }) {
                @Nullable
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> data = new HashMap<>();
                    data.put("Email", email);
                    data.put("Password", password);
                    data.put("fullName", fullName);
                    data.put("DiaChi", address);
                    data.put("Phone", phone);
                    return data;
                }
            };
            RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
            requestQueue.add(stringRequest);
        }
    }

    public void login(View view) {
        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    private void sendNotification(){
        //bấm vào thông báo chuyển màng hình
        Intent intent = new Intent(this,MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_IMMUTABLE);

        //tạo một hình ảnh: Bitmap --> android nâng cao
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher);
        //TẠO MỘT ĐỐI TƯỢNG THÔNG BÁO
        Notification notification = new NotificationCompat.Builder(this, PushNotification.CHANNEL_ID)
                //SET TIÊU ĐỀ
                .setContentTitle("THÔNG BÁO")
                //SET NỘI DUNG
                .setContentText("Chúc mừng bạn đăng ký tài khoảng thành công")
                //SET ICON NHỎ
                .setSmallIcon(R.drawable.ic_baseline_notifications_none_24)
                //SÉT HÌNH LỚN
                .setLargeIcon(bitmap)
                .setColor(getResources().getColor(R.color.purple_500, null))
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setContentIntent(pendingIntent)
                .build();
        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(this);
        //chuyền id: gõ số j vào cũng đc
        notificationManagerCompat.notify((int) new Date().getTime(),notification);
    }
}