# weather_forecast

Nhóm 18: Ứng dụng dự báo thời tiết và keylogger (Java)
1. Thành viên

B17DCAT089
Đinh Thị Thanh Hương
dinhgihuong@gmail.com
keylogger
weather forecast

B17DCAT125
Nguyễn Ngọc Minh
nguyenngocminh120699@gmail.com
Hoàn thiện chức năng người dùng, xử lý ngoại lệ
Thiết kế giao diện

2. Mô tả hệ thống (mô tả tổng quan và các chức năng chính/quan trọng hoặc được yêu cầu)
Xem dự báo thời tiết
Xem dự báo thời tiết vị trí hiện tại ( theo ip external )
Xem dự báo thời tiết vị trí bất kì ( tìm kiếm theo tên )
Thời tiết 7 ngày
Thời tiết theo giờ
Keylogger
Thu thập ký tự gõ global scope vào file log
Gửi file log vào gmail

3. Môi trường phát triển (công cụ/kỹ thuật/công nghệ/thư viện/framework)


Lấy ipv4 external
checkip.amazonaws.com

Lấy location theo ip
api.ipstack.com


Lấy location theo address
us1.locationiq.com


Lấy thông tin thời tiết 
api.openweathermap.org


Xủ lý dữ liệu json
org.json

Key event global scope
jnativehook

Gửi email
javax.mail

Giao diện
javax.swing.*

Chart
JFreeChart

Apache Netbean 12
JDK 11



4. Hạn chế/Hướng phát triển
 Hạn chế:
Giao diện chưa có hiệu ứng, chưa đủ thu hút người dùng.
Chưa có chức năng tìm vị trí trên bản đồ, gợi ý tìm vị trí.
Keylogger bị trình duyệt chặn.
Hướng phát triển/ý tưởng tiếp theo:
Phát triển thêm keylogger
Thêm chức năng xếp lịch trình.
Thêm chức năng cảnh báo thời tiết nguy hiểm tới người dùng.
Thêm chức năng tự động download các file độc.
Giao diện thay đổi theo các sự kiện trong năm.
