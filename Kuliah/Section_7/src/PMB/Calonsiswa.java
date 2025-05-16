package PMB;

public class Calonsiswa {
        private String nama;
        private String alamat_asal;
        String ttl;
        String Asal_Sekolah;
        long no_hp;
        String email;
        private String [] pilihanJurusan = new String[3];
        private String [] jalurMasuk = new String[3];

        public Calonsiswa(String namaDepan, String namaBelakang, String [] pilihanJurusan){
            setNama(namaDepan, namaBelakang);
//            setPilihanJurusan(pilihanJurusan);
        }
        public Calonsiswa(String namaDepan, String namaBelakang, String pilihanJurusan1, String pilihanJurusan2, String pilihanJurusan3){
            setNama(namaDepan, namaBelakang);
            setPilihanJurusan(pilihanJurusan1, pilihanJurusan2, pilihanJurusan3);
        }
        public void setPilihanJurusan(){
            this.pilihanJurusan = pilihanJurusan;
        }
        public String[] getPilhanJurusan(){
            return  pilihanJurusan;
        }
        public void setPilihanJurusan(String pj1, String pj2, String pj3){
            this.pilihanJurusan[0] = pj1;
            this.pilihanJurusan[1] = pj2;
            this.pilihanJurusan[2] = pj3;
        }


        public void setJalurMasuk(){
            this.jalurMasuk = jalurMasuk;
        }
        public String[] getJalurMasuk(){
            return  jalurMasuk;
        }

        public void setNama(String namaDepan, String namaBelakang){
            this.nama = namaDepan + "" + namaBelakang;
        }
        public String getNama(){
            return nama;
        }

        public void setAlamatAsal(){
            this.alamat_asal = alamat_asal;
        }
        public String getAlamat(){
            return alamat_asal;
        }

        public void printMahasiswa(){
            System.out.println("Nama mahasiswa :" + this.nama);
            for(String i: this.pilihanJurusan){
                System.out.println("Pilihan jurusan di UMM: " + i);
            }
//            System.out.println("Pilihan jurusan: " + this.pilihanJurusan);
        }

}
