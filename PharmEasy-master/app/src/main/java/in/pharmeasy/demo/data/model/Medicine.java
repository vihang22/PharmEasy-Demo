package in.pharmeasy.demo.data.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Medicine extends RealmObject{

    @PrimaryKey
    private int id;
    private boolean available;
    private String packSize;
    private String manufacturer;
    private int uip;
    private String label;
    private String packForm;
    private String form;
    private String generics;
    private String imgUrl;
    private String name;
    private int su;
    private String slug;
    private int mfId;
    private int discountPerc;
    private double oPrice;
    private String type;
    private double uPrice;
    private String productsForBrand;
    private double mrp;
    private int hkpDrugCode;
    private String pForm;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getPackSize() {
        return packSize;
    }

    public void setPackSize(String packSize) {
        this.packSize = packSize;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getUip() {
        return uip;
    }

    public void setUip(int uip) {
        this.uip = uip;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getPackForm() {
        return packForm;
    }

    public void setPackForm(String packForm) {
        this.packForm = packForm;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public String getGenerics() {
        return generics;
    }

    public void setGenerics(String generics) {
        this.generics = generics;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSu() {
        return su;
    }

    public void setSu(int su) {
        this.su = su;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public int getMfId() {
        return mfId;
    }

    public void setMfId(int mfId) {
        this.mfId = mfId;
    }

    public int getDiscountPerc() {
        return discountPerc;
    }

    public void setDiscountPerc(int discountPerc) {
        this.discountPerc = discountPerc;
    }

    public double getoPrice() {
        return oPrice;
    }

    public void setoPrice(double oPrice) {
        this.oPrice = oPrice;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getuPrice() {
        return uPrice;
    }

    public void setuPrice(double uPrice) {
        this.uPrice = uPrice;
    }

    public String getProductsForBrand() {
        return productsForBrand;
    }

    public void setProductsForBrand(String productsForBrand) {
        this.productsForBrand = productsForBrand;
    }

    public double getMrp() {
        return mrp;
    }

    public void setMrp(double mrp) {
        this.mrp = mrp;
    }

    public int getHkpDrugCode() {
        return hkpDrugCode;
    }

    public void setHkpDrugCode(int hkpDrugCode) {
        this.hkpDrugCode = hkpDrugCode;
    }

    public String getpForm() {
        return pForm;
    }

    public void setpForm(String pForm) {
        this.pForm = pForm;
    }
}
