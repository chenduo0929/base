<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
              android:layout_width="match_parent"
              android:layout_height="wrap_content"
              android:gravity="center"
              android:orientation="horizontal"
              android:padding="8dp">

    <ProgressBar
        android:layout_width="32dp"
        android:layout_height="32dp"
    />

    <TextView
        android:id="@+id/loading_text"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginLeft="8dp"
        android:text="更多加载中..."
        android:textSize="14sp"/>
</LinearLayout>