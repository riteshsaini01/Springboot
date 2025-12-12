const ProductList = ({ products }) => {
    return (
        <div className="row">
            {products.map(product=>(
                <div className="col-lg-4 col-md-6 col-sm-12 mb-4" key={product.id}>
                    <div className="card h-100">
                        <img 
                            src={product.imageUrl || 'https://placehol.co/600x400'}
                            className="card-img-top">
                        </img>
                    </div>
                </div>
            ))}
        </div>
    )
}

export default ProductList;