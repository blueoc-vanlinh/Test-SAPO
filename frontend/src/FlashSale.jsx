import { useEffect, useState } from "react";

export default function FlashSale() {
  const [products, setProducts] = useState([]);
  const [message, setMessage] = useState("");
  const [loadingProductId, setLoadingProductId] = useState(null);

  const fetchProducts = async () => {
    try {
      const response = await fetch("http://localhost:8081/api/flash-sale/products");
      const data = await response.json();
      setProducts(data);
    } catch {
      setMessage("Không thể tải danh sách sản phẩm");
    }
  };

  useEffect(() => {
    fetchProducts();
  }, []);

  const handleBuyNow = async (productId) => {
    setMessage("");
    setLoadingProductId(productId);

    try {
      const response = await fetch("http://localhost:8081/api/flash-sale/order", {
        method: "POST",
        headers: {
          "Content-Type": "application/json"
        },
        body: JSON.stringify({
          productId,
          userId: 1,
          quantity: 1
        })
      });

      const result = await response.text();

      if (response.ok) {
        setMessage(`${result}`);
        await fetchProducts();
      } else {
        setMessage(`${result}`);
      }
    } catch {
      setMessage("Không thể kết nối tới server");
    } finally {
      setLoadingProductId(null);
    }
  };

  return (
    <div className="page">
      <div className="container">
        <h1 className="title">Flash Sale Products</h1>
        <p className="subtitle">Danh sách sản phẩm giảm giá và số lượng còn lại</p>

        {message && <div className="message">{message}</div>}

        <div className="product-grid">
          {products.map((product) => (
            <div className="product-card" key={product.id}>
              <h2 className="product-name">{product.name}</h2>

              <div className="price-wrap">
                <span className="original-price">
                  {product.originalPrice.toLocaleString("vi-VN")}đ
                </span>
                <span className="sale-price">
                  {product.salePrice.toLocaleString("vi-VN")}đ
                </span>
              </div>

              <p className="stock">Còn lại: {product.stock}</p>

              <button
                className="buy-button"
                onClick={() => handleBuyNow(product.id)}
                disabled={product.stock <= 0 || loadingProductId === product.id}
              >
                {loadingProductId === product.id
                  ? "Đang xử lý..."
                  : product.stock > 0
                  ? "Mua ngay"
                  : "Hết hàng"}
              </button>
            </div>
          ))}
        </div>
      </div>
    </div>
  );
}