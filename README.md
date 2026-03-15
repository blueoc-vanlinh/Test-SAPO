# Flash Sale Test
Đây là bài test mô phỏng chức năng Flash Sale cho một sàn thương mại điện tử.

Hệ thống gồm:
- Backend **Java Spring Boot**
- Frontend **React + Vite**

Chức năng chính:
- Hiển thị danh sách sản phẩm Flash Sale
- Đặt hàng sản phẩm Flash Sale
- Kiểm tra tồn kho
- Giới hạn mỗi khách hàng chỉ được mua tối đa **2 sản phẩm**
- Hiển thị thông báo thành công hoặc thất bại khi đặt hàng

---
### Backend
- Java
- Spring Boot
- Spring Data JPA
- H2 Database
### Frontend
- React
- Vite
- JavaScript
- CSS

Test/
├── backend/
│   ├── src/main/java/com/example/flashsale
│   │   ├── controller
│   │   ├── dto
│   │   ├── entity
│   │   ├── repository
│   │   ├── service
│   │   └── FlashSaleApplication.java
│   └── src/main/resources
│       └── application.properties
├── frontend/
│   ├── src
│   │   ├── App.jsx
│   │   ├── FlashSale.jsx
│   │   ├── main.jsx
│   │   └── index.css
│   └── package.json
└── README.md

4.1 Chạy backend
Di chuyển vào thư mục backend:

cd backend
mvn spring-boot:run

Backend chạy tại:

http://localhost:8081

4.2 Chạy frontend
Di chuyển vào thư mục frontend:

cd frontend
npm install
npm run dev

Frontend chạy tại:

http://localhost:5173
5. API chính
Lấy danh sách sản phẩm Flash Sale

GET

/api/flash-sale/products

Ví dụ:

http://localhost:8081/api/flash-sale/products
Đặt hàng Flash Sale

POST

/api/flash-sale/order