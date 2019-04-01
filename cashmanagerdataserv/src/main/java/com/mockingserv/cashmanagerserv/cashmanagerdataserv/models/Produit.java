package com.mockingserv.cashmanagerserv.cashmanagerdataserv.models;


import com.mockingserv.cashmanagerserv.cashmanagerdataserv.DTOs.ProduitDTO;
import com.mockingserv.cashmanagerserv.cashmanagerdataserv.models.IFACE.ApiObject;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import javax.persistence.*;


@Entity
@Table(name = "produit_")
public class Produit extends AuditModel implements ApiObject<ProduitDTO> {

    @Id
    @GeneratedValue(generator = "product_generator")
    @SequenceGenerator(
            name = "product_generator",
            sequenceName = "product_sequence",
            initialValue = 1000
    )
    @Column(name = "id_")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private long price;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity=Category.class)
    @JoinColumn(name = "id_category", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Category category;

    @Column(name = "code")
    private String codeProduit;

    @Column(name = "img_path")
    private String imagePath;

    @Column(name = "stock_number")
    private int stock;

    public Produit() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getCodeProduit() {
        return codeProduit;
    }

    public void setCodeProduit(String codeProduit) {
        this.codeProduit = codeProduit;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }


    @Override
    public ProduitDTO toDTO() {
        ProduitDTO out = new ProduitDTO();
        out.setId(this.id);
        out.setCategory(this.category);
        out.setCodeProduit(this.codeProduit);
        out.setName(this.name);
        out.setPrice(this.price);
        out.setImagePath(this.imagePath);
        out.setStockNumber(this.stock);
        return out;
    }
}
