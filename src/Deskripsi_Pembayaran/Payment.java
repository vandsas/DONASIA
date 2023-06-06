package Deskripsi_Pembayaran;

/**
 *
 * @author Asus
 */
public class Payment {

    private String nama;
    private String jenisDonasi;
    private String jumlah;
    private String metode;
    private String tanggal;

    public Payment(String nama, String jenisDonasi, String tanggal, String metode,String jumlah ) {
        this.nama = nama;
        this.jenisDonasi = jenisDonasi;
        this.tanggal = tanggal;
        this.metode = metode;
        this.jumlah = jumlah;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJenisDonasi() {
        return jenisDonasi;
    }

    public void setJenisDonasi(String jenisDonasi) {
        this.jenisDonasi = jenisDonasi;
    }

    public String getJumlah() {
        return jumlah;
    }

    public void setJumlah(String jumlah) {
        this.jumlah = jumlah;
    }

    public String getMetode() {
        return metode;
    }

    public void setMetode(String metode) {
        this.metode = metode;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    @Override
    public String toString() {
        return "Pembayaran{" + "nama=" + nama + ", jenis Donasi=" + jenisDonasi + ", tanggal=" + tanggal + ", metode=" + metode + ", jumlah=" + jumlah + '}';
    }
}
