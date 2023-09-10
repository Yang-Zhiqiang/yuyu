package yuyu.def.sinkeiyaku.file.zdb;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.file.description.annotations.MultiByte;
import jp.co.slcs.swak.file.description.text.fixedlength.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （新契約）連携用汎用ペーパーレス申込情報ファイル データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenSkRnHanyouPaperlessMosFile implements Serializable {


    private static final long serialVersionUID = 1L;


    public GenSkRnHanyouPaperlessMosFile() {
    }


    @Column(order = 1, length = 2)
    @NotNull
    private String zrnseihowebidkbn;


    public String getZrnseihowebidkbn() {
        return zrnseihowebidkbn;
    }


    public void setZrnseihowebidkbn(String pZrnseihowebidkbn) {
        zrnseihowebidkbn = pZrnseihowebidkbn;
    }


    @Column(order = 2, length = 6)
    @NotNull
    private String zrnseihowebkojincd;


    public String getZrnseihowebkojincd() {
        return zrnseihowebkojincd;
    }


    public void setZrnseihowebkojincd(String pZrnseihowebkojincd) {
        zrnseihowebkojincd = pZrnseihowebkojincd;
    }


    @Column(order = 3, length = 1)
    @NotNull
    private String zrnseihowebitijihozonhyouji;


    public String getZrnseihowebitijihozonhyouji() {
        return zrnseihowebitijihozonhyouji;
    }


    public void setZrnseihowebitijihozonhyouji(String pZrnseihowebitijihozonhyouji) {
        zrnseihowebitijihozonhyouji = pZrnseihowebitijihozonhyouji;
    }


    @Column(order = 4, length = 3)
    @NotNull
    private String zrnseihowebseknoc;


    public String getZrnseihowebseknoc() {
        return zrnseihowebseknoc;
    }


    public void setZrnseihowebseknoc(String pZrnseihowebseknoc) {
        zrnseihowebseknoc = pZrnseihowebseknoc;
    }


    @Column(order = 5, length = 8)
    @NotNull
    private String zrnseihowebcalckijyunymdc;


    public String getZrnseihowebcalckijyunymdc() {
        return zrnseihowebcalckijyunymdc;
    }


    public void setZrnseihowebcalckijyunymdc(String pZrnseihowebcalckijyunymdc) {
        zrnseihowebcalckijyunymdc = pZrnseihowebcalckijyunymdc;
    }


    @Column(order = 6, length = 18)
    @NotNull
    private String zrnseihowebhhknknnm;


    public String getZrnseihowebhhknknnm() {
        return zrnseihowebhhknknnm;
    }


    public void setZrnseihowebhhknknnm(String pZrnseihowebhhknknnm) {
        zrnseihowebhhknknnm = pZrnseihowebhhknknnm;
    }


    @Column(order = 7, length = 8)
    @NotNull
    private String zrnseihowebhhknseiymdc;


    public String getZrnseihowebhhknseiymdc() {
        return zrnseihowebhhknseiymdc;
    }


    public void setZrnseihowebhhknseiymdc(String pZrnseihowebhhknseiymdc) {
        zrnseihowebhhknseiymdc = pZrnseihowebhhknseiymdc;
    }


    @Column(order = 8, length = 1)
    @NotNull
    private String zrnseihowebhhknseikbn;


    public String getZrnseihowebhhknseikbn() {
        return zrnseihowebhhknseikbn;
    }


    public void setZrnseihowebhhknseikbn(String pZrnseihowebhhknseikbn) {
        zrnseihowebhhknseikbn = pZrnseihowebhhknseikbn;
    }


    @Column(order = 9, length = 18)
    @NotNull
    private String zrnseihowebkykknnm;


    public String getZrnseihowebkykknnm() {
        return zrnseihowebkykknnm;
    }


    public void setZrnseihowebkykknnm(String pZrnseihowebkykknnm) {
        zrnseihowebkykknnm = pZrnseihowebkykknnm;
    }


    @Column(order = 10, length = 8)
    @NotNull
    private String zrnseihowebkyksyaseiymdc;


    public String getZrnseihowebkyksyaseiymdc() {
        return zrnseihowebkyksyaseiymdc;
    }


    public void setZrnseihowebkyksyaseiymdc(String pZrnseihowebkyksyaseiymdc) {
        zrnseihowebkyksyaseiymdc = pZrnseihowebkyksyaseiymdc;
    }


    @Column(order = 11, length = 1)
    @NotNull
    private String zrnseihowebkyksyaseikbn;


    public String getZrnseihowebkyksyaseikbn() {
        return zrnseihowebkyksyaseikbn;
    }


    public void setZrnseihowebkyksyaseikbn(String pZrnseihowebkyksyaseikbn) {
        zrnseihowebkyksyaseikbn = pZrnseihowebkyksyaseikbn;
    }


    @Column(order = 12, length = 3)
    @NotNull
    private String zrnseihowebhknsyuruinoc;


    public String getZrnseihowebhknsyuruinoc() {
        return zrnseihowebhknsyuruinoc;
    }


    public void setZrnseihowebhknsyuruinoc(String pZrnseihowebhknsyuruinoc) {
        zrnseihowebhknsyuruinoc = pZrnseihowebhknsyuruinoc;
    }


    @Column(order = 13, length = 2)
    @NotNull
    private String zrnseihowebhknkknc;


    public String getZrnseihowebhknkknc() {
        return zrnseihowebhknkknc;
    }


    public void setZrnseihowebhknkknc(String pZrnseihowebhknkknc) {
        zrnseihowebhknkknc = pZrnseihowebhknkknc;
    }


    @Column(order = 14, length = 2)
    @NotNull
    private String zrnseihowebphrkkiknc;


    public String getZrnseihowebphrkkiknc() {
        return zrnseihowebphrkkiknc;
    }


    public void setZrnseihowebphrkkiknc(String pZrnseihowebphrkkiknc) {
        zrnseihowebphrkkiknc = pZrnseihowebphrkkiknc;
    }


    @Column(order = 15, length = 1)
    @NotNull
    private String zrnseihowebhrkkaisuukbn;


    public String getZrnseihowebhrkkaisuukbn() {
        return zrnseihowebhrkkaisuukbn;
    }


    public void setZrnseihowebhrkkaisuukbn(String pZrnseihowebhrkkaisuukbn) {
        zrnseihowebhrkkaisuukbn = pZrnseihowebhrkkaisuukbn;
    }


    @Column(order = 16, length = 1)
    @NotNull
    private String zrnseihowebsdpdkbn;


    public String getZrnseihowebsdpdkbn() {
        return zrnseihowebsdpdkbn;
    }


    public void setZrnseihowebsdpdkbn(String pZrnseihowebsdpdkbn) {
        zrnseihowebsdpdkbn = pZrnseihowebsdpdkbn;
    }


    @Column(order = 17, length = 9)
    @NotNull
    private String zrnseihowebkihonsc;


    public String getZrnseihowebkihonsc() {
        return zrnseihowebkihonsc;
    }


    public void setZrnseihowebkihonsc(String pZrnseihowebkihonsc) {
        zrnseihowebkihonsc = pZrnseihowebkihonsc;
    }


    @Column(order = 18, length = 1)
    @NotNull
    private String zrnseihowebnksyuruikbn;


    public String getZrnseihowebnksyuruikbn() {
        return zrnseihowebnksyuruikbn;
    }


    public void setZrnseihowebnksyuruikbn(String pZrnseihowebnksyuruikbn) {
        zrnseihowebnksyuruikbn = pZrnseihowebnksyuruikbn;
    }


    @Column(order = 19, length = 1)
    @NotNull
    private String zrnseihoweblntkkbn;


    public String getZrnseihoweblntkkbn() {
        return zrnseihoweblntkkbn;
    }


    public void setZrnseihoweblntkkbn(String pZrnseihoweblntkkbn) {
        zrnseihoweblntkkbn = pZrnseihoweblntkkbn;
    }


    @Column(order = 20, length = 1)
    @NotNull
    private String zrnseihowebnkshrarihyj;


    public String getZrnseihowebnkshrarihyj() {
        return zrnseihowebnkshrarihyj;
    }


    public void setZrnseihowebnkshrarihyj(String pZrnseihowebnkshrarihyj) {
        zrnseihowebnkshrarihyj = pZrnseihowebnkshrarihyj;
    }


    @Column(order = 21, length = 9)
    @NotNull
    private String zrnseihowebmosnoc;


    public String getZrnseihowebmosnoc() {
        return zrnseihowebmosnoc;
    }


    public void setZrnseihowebmosnoc(String pZrnseihowebmosnoc) {
        zrnseihowebmosnoc = pZrnseihowebmosnoc;
    }


    @Column(order = 22, length = 8)
    @NotNull
    private String zrnseihowebsekykkigenymdc;


    public String getZrnseihowebsekykkigenymdc() {
        return zrnseihowebsekykkigenymdc;
    }


    public void setZrnseihowebsekykkigenymdc(String pZrnseihowebsekykkigenymdc) {
        zrnseihowebsekykkigenymdc = pZrnseihowebsekykkigenymdc;
    }


    @Column(order = 23, length = 4)
    @NotNull
    private String zrnseihowebsksjsitencd;


    public String getZrnseihowebsksjsitencd() {
        return zrnseihowebsksjsitencd;
    }


    public void setZrnseihowebsksjsitencd(String pZrnseihowebsksjsitencd) {
        zrnseihowebsksjsitencd = pZrnseihowebsksjsitencd;
    }


    @Column(order = 24, length = 8)
    @NotNull
    private String zrnseihowebfstmossksymdc;


    public String getZrnseihowebfstmossksymdc() {
        return zrnseihowebfstmossksymdc;
    }


    public void setZrnseihowebfstmossksymdc(String pZrnseihowebfstmossksymdc) {
        zrnseihowebfstmossksymdc = pZrnseihowebfstmossksymdc;
    }


    @Column(order = 25, length = 1)
    @NotNull
    private String zrnseihowebhnsyukyktdkkbn;


    public String getZrnseihowebhnsyukyktdkkbn() {
        return zrnseihowebhnsyukyktdkkbn;
    }


    public void setZrnseihowebhnsyukyktdkkbn(String pZrnseihowebhnsyukyktdkkbn) {
        zrnseihowebhnsyukyktdkkbn = pZrnseihowebhnsyukyktdkkbn;
    }


    @Column(order = 26, length = 5)
    @NotNull
    private String zrnseihowebhjnkitikbn;


    public String getZrnseihowebhjnkitikbn() {
        return zrnseihowebhjnkitikbn;
    }


    public void setZrnseihowebhjnkitikbn(String pZrnseihowebhjnkitikbn) {
        zrnseihowebhjnkitikbn = pZrnseihowebhjnkitikbn;
    }


    @Column(order = 27, length = 1)
    @NotNull
    private String zrnseihowebhjnkykhyj;


    public String getZrnseihowebhjnkykhyj() {
        return zrnseihowebhjnkykhyj;
    }


    public void setZrnseihowebhjnkykhyj(String pZrnseihowebhjnkykhyj) {
        zrnseihowebhjnkykhyj = pZrnseihowebhjnkykhyj;
    }


    @Column(order = 28, length = 2)
    @NotNull
    private String zrnseihowebtksykmcd1;


    public String getZrnseihowebtksykmcd1() {
        return zrnseihowebtksykmcd1;
    }


    public void setZrnseihowebtksykmcd1(String pZrnseihowebtksykmcd1) {
        zrnseihowebtksykmcd1 = pZrnseihowebtksykmcd1;
    }


    @Column(order = 29, length = 2)
    @NotNull
    private String zrnseihowebtksykmcd2;


    public String getZrnseihowebtksykmcd2() {
        return zrnseihowebtksykmcd2;
    }


    public void setZrnseihowebtksykmcd2(String pZrnseihowebtksykmcd2) {
        zrnseihowebtksykmcd2 = pZrnseihowebtksykmcd2;
    }


    @Column(order = 30, length = 2)
    @NotNull
    private String zrnseihowebtksykmcd3;


    public String getZrnseihowebtksykmcd3() {
        return zrnseihowebtksykmcd3;
    }


    public void setZrnseihowebtksykmcd3(String pZrnseihowebtksykmcd3) {
        zrnseihowebtksykmcd3 = pZrnseihowebtksykmcd3;
    }


    @Column(order = 31, length = 2)
    @NotNull
    private String zrnseihowebtksykmcd4;


    public String getZrnseihowebtksykmcd4() {
        return zrnseihowebtksykmcd4;
    }


    public void setZrnseihowebtksykmcd4(String pZrnseihowebtksykmcd4) {
        zrnseihowebtksykmcd4 = pZrnseihowebtksykmcd4;
    }


    @Column(order = 32, length = 2)
    @NotNull
    private String zrnseihowebtksykmcd5;


    public String getZrnseihowebtksykmcd5() {
        return zrnseihowebtksykmcd5;
    }


    public void setZrnseihowebtksykmcd5(String pZrnseihowebtksykmcd5) {
        zrnseihowebtksykmcd5 = pZrnseihowebtksykmcd5;
    }


    @Column(order = 33, length = 9)
    @NotNull
    private String zrnseihowebteiwkknc;


    public String getZrnseihowebteiwkknc() {
        return zrnseihowebteiwkknc;
    }


    public void setZrnseihowebteiwkknc(String pZrnseihowebteiwkknc) {
        zrnseihowebteiwkknc = pZrnseihowebteiwkknc;
    }


    @Column(order = 34, length = 38)
    @NotNull
    private String zrnseihowebknhjnnm;


    public String getZrnseihowebknhjnnm() {
        return zrnseihowebknhjnnm;
    }


    public void setZrnseihowebknhjnnm(String pZrnseihowebknhjnnm) {
        zrnseihowebknhjnnm = pZrnseihowebknhjnnm;
    }


    @Column(order = 35, length = 30)
    @MultiByte
    @NotNull
    private String zrnseihowebkjhjnnm;


    public String getZrnseihowebkjhjnnm() {
        return zrnseihowebkjhjnnm;
    }


    @DataConvert("toMultiByte")
    public void setZrnseihowebkjhjnnm(String pZrnseihowebkjhjnnm) {
        zrnseihowebkjhjnnm = pZrnseihowebkjhjnnm;
    }


    @Column(order = 36, length = 30)
    @NotNull
    private String zrnseihowebkndaihyounm;


    public String getZrnseihowebkndaihyounm() {
        return zrnseihowebkndaihyounm;
    }


    public void setZrnseihowebkndaihyounm(String pZrnseihowebkndaihyounm) {
        zrnseihowebkndaihyounm = pZrnseihowebkndaihyounm;
    }


    @Column(order = 37, length = 30)
    @MultiByte
    @NotNull
    private String zrnseihowebkjdaihyounm;


    public String getZrnseihowebkjdaihyounm() {
        return zrnseihowebkjdaihyounm;
    }


    @DataConvert("toMultiByte")
    public void setZrnseihowebkjdaihyounm(String pZrnseihowebkjdaihyounm) {
        zrnseihowebkjdaihyounm = pZrnseihowebkjdaihyounm;
    }


    @Column(order = 38, length = 2)
    @NotNull
    private String zrnseihowebdaihyouktgkkbn;


    public String getZrnseihowebdaihyouktgkkbn() {
        return zrnseihowebdaihyouktgkkbn;
    }


    public void setZrnseihowebdaihyouktgkkbn(String pZrnseihowebdaihyouktgkkbn) {
        zrnseihowebdaihyouktgkkbn = pZrnseihowebdaihyouktgkkbn;
    }


    @Column(order = 39, length = 10)
    @NotNull
    private String zrnseihowebsykihrkp1c;


    public String getZrnseihowebsykihrkp1c() {
        return zrnseihowebsykihrkp1c;
    }


    public void setZrnseihowebsykihrkp1c(String pZrnseihowebsykihrkp1c) {
        zrnseihowebsykihrkp1c = pZrnseihowebsykihrkp1c;
    }


    @Column(order = 40, length = 10)
    @NotNull
    private String zrnseihowebmosp1c;


    public String getZrnseihowebmosp1c() {
        return zrnseihowebmosp1c;
    }


    public void setZrnseihowebmosp1c(String pZrnseihowebmosp1c) {
        zrnseihowebmosp1c = pZrnseihowebmosp1c;
    }


    @Column(order = 41, length = 1)
    @NotNull
    private String zrnseihowebtkiyougyoutaikbn;


    public String getZrnseihowebtkiyougyoutaikbn() {
        return zrnseihowebtkiyougyoutaikbn;
    }


    public void setZrnseihowebtkiyougyoutaikbn(String pZrnseihowebtkiyougyoutaikbn) {
        zrnseihowebtkiyougyoutaikbn = pZrnseihowebtkiyougyoutaikbn;
    }


    @Column(order = 42, length = 2)
    @NotNull
    private String zrnseihowebzennoukknc;


    public String getZrnseihowebzennoukknc() {
        return zrnseihowebzennoukknc;
    }


    public void setZrnseihowebzennoukknc(String pZrnseihowebzennoukknc) {
        zrnseihowebzennoukknc = pZrnseihowebzennoukknc;
    }


    @Column(order = 43, length = 1)
    @NotNull
    private String zrnseihowebpaperlessmoshyj;


    public String getZrnseihowebpaperlessmoshyj() {
        return zrnseihowebpaperlessmoshyj;
    }


    public void setZrnseihowebpaperlessmoshyj(String pZrnseihowebpaperlessmoshyj) {
        zrnseihowebpaperlessmoshyj = pZrnseihowebpaperlessmoshyj;
    }


    @Column(order = 44, length = 1)
    @NotNull
    private String zrnseihowebdatasousinzmhyj;


    public String getZrnseihowebdatasousinzmhyj() {
        return zrnseihowebdatasousinzmhyj;
    }


    public void setZrnseihowebdatasousinzmhyj(String pZrnseihowebdatasousinzmhyj) {
        zrnseihowebdatasousinzmhyj = pZrnseihowebdatasousinzmhyj;
    }


    @Column(order = 45, length = 2)
    @NotNull
    private String zrnseihowebkknmskhjnkitikbn;


    public String getZrnseihowebkknmskhjnkitikbn() {
        return zrnseihowebkknmskhjnkitikbn;
    }


    public void setZrnseihowebkknmskhjnkitikbn(String pZrnseihowebkknmskhjnkitikbn) {
        zrnseihowebkknmskhjnkitikbn = pZrnseihowebkknmskhjnkitikbn;
    }


    @Column(order = 46, length = 60)
    @MultiByte
    @NotNull
    private String zrnseihowebkykottmsk;


    public String getZrnseihowebkykottmsk() {
        return zrnseihowebkykottmsk;
    }


    @DataConvert("toMultiByte")
    public void setZrnseihowebkykottmsk(String pZrnseihowebkykottmsk) {
        zrnseihowebkykottmsk = pZrnseihowebkykottmsk;
    }


    @Column(order = 47, length = 3)
    @NotNull
    private String zrnseihowebhhknsykgycd;


    public String getZrnseihowebhhknsykgycd() {
        return zrnseihowebhhknsykgycd;
    }


    public void setZrnseihowebhhknsykgycd(String pZrnseihowebhhknsykgycd) {
        zrnseihowebhhknsykgycd = pZrnseihowebhhknsykgycd;
    }


    @Column(order = 48, length = 2)
    @NotNull
    private String zrnseihowebhknmskhjnkitikbn;


    public String getZrnseihowebhknmskhjnkitikbn() {
        return zrnseihowebhknmskhjnkitikbn;
    }


    public void setZrnseihowebhknmskhjnkitikbn(String pZrnseihowebhknmskhjnkitikbn) {
        zrnseihowebhknmskhjnkitikbn = pZrnseihowebhknmskhjnkitikbn;
    }


    @Column(order = 49, length = 60)
    @MultiByte
    @NotNull
    private String zrnseihowebhhknottmsk;


    public String getZrnseihowebhhknottmsk() {
        return zrnseihowebhhknottmsk;
    }


    @DataConvert("toMultiByte")
    public void setZrnseihowebhhknottmsk(String pZrnseihowebhhknottmsk) {
        zrnseihowebhhknottmsk = pZrnseihowebhhknottmsk;
    }


    @Column(order = 50, length = 1)
    @NotNull
    private String zrnseihowebhhknnensyuukbn;


    public String getZrnseihowebhhknnensyuukbn() {
        return zrnseihowebhhknnensyuukbn;
    }


    public void setZrnseihowebhhknnensyuukbn(String pZrnseihowebhhknnensyuukbn) {
        zrnseihowebhhknnensyuukbn = pZrnseihowebhhknnensyuukbn;
    }


    @Column(order = 51, length = 1)
    @NotNull
    private String zrnseihowebsbukthksuninzuuc;


    public String getZrnseihowebsbukthksuninzuuc() {
        return zrnseihowebsbukthksuninzuuc;
    }


    public void setZrnseihowebsbukthksuninzuuc(String pZrnseihowebsbukthksuninzuuc) {
        zrnseihowebsbukthksuninzuuc = pZrnseihowebsbukthksuninzuuc;
    }


    @Column(order = 52, length = 3)
    @NotNull
    private String zrnseihowebsbuktbnwari1c;


    public String getZrnseihowebsbuktbnwari1c() {
        return zrnseihowebsbuktbnwari1c;
    }


    public void setZrnseihowebsbuktbnwari1c(String pZrnseihowebsbuktbnwari1c) {
        zrnseihowebsbuktbnwari1c = pZrnseihowebsbuktbnwari1c;
    }


    @Column(order = 53, length = 1)
    @NotNull
    private String zrnseihowebsbukttdkkbn2;


    public String getZrnseihowebsbukttdkkbn2() {
        return zrnseihowebsbukttdkkbn2;
    }


    public void setZrnseihowebsbukttdkkbn2(String pZrnseihowebsbukttdkkbn2) {
        zrnseihowebsbukttdkkbn2 = pZrnseihowebsbukttdkkbn2;
    }


    @Column(order = 54, length = 18)
    @NotNull
    private String zrnseihowebsbuktknnm2;


    public String getZrnseihowebsbuktknnm2() {
        return zrnseihowebsbuktknnm2;
    }


    public void setZrnseihowebsbuktknnm2(String pZrnseihowebsbuktknnm2) {
        zrnseihowebsbuktknnm2 = pZrnseihowebsbuktknnm2;
    }


    @Column(order = 55, length = 11)
    @MultiByte
    @NotNull
    private String zrnseihowebsbuktkjnm2;


    public String getZrnseihowebsbuktkjnm2() {
        return zrnseihowebsbuktkjnm2;
    }


    @DataConvert("toMultiByte")
    public void setZrnseihowebsbuktkjnm2(String pZrnseihowebsbuktkjnm2) {
        zrnseihowebsbuktkjnm2 = pZrnseihowebsbuktkjnm2;
    }


    @Column(order = 56, length = 8)
    @NotNull
    private String zrnseihowebsbuktseiymd2c;


    public String getZrnseihowebsbuktseiymd2c() {
        return zrnseihowebsbuktseiymd2c;
    }


    public void setZrnseihowebsbuktseiymd2c(String pZrnseihowebsbuktseiymd2c) {
        zrnseihowebsbuktseiymd2c = pZrnseihowebsbuktseiymd2c;
    }


    @Column(order = 57, length = 3)
    @NotNull
    private String zrnseihowebsbuktbnwari2c;


    public String getZrnseihowebsbuktbnwari2c() {
        return zrnseihowebsbuktbnwari2c;
    }


    public void setZrnseihowebsbuktbnwari2c(String pZrnseihowebsbuktbnwari2c) {
        zrnseihowebsbuktbnwari2c = pZrnseihowebsbuktbnwari2c;
    }


    @Column(order = 58, length = 1)
    @NotNull
    private String zrnseihowebsbukttdkkbn3;


    public String getZrnseihowebsbukttdkkbn3() {
        return zrnseihowebsbukttdkkbn3;
    }


    public void setZrnseihowebsbukttdkkbn3(String pZrnseihowebsbukttdkkbn3) {
        zrnseihowebsbukttdkkbn3 = pZrnseihowebsbukttdkkbn3;
    }


    @Column(order = 59, length = 18)
    @NotNull
    private String zrnseihowebsbuktknnm3;


    public String getZrnseihowebsbuktknnm3() {
        return zrnseihowebsbuktknnm3;
    }


    public void setZrnseihowebsbuktknnm3(String pZrnseihowebsbuktknnm3) {
        zrnseihowebsbuktknnm3 = pZrnseihowebsbuktknnm3;
    }


    @Column(order = 60, length = 11)
    @MultiByte
    @NotNull
    private String zrnseihowebsbuktkjnm3;


    public String getZrnseihowebsbuktkjnm3() {
        return zrnseihowebsbuktkjnm3;
    }


    @DataConvert("toMultiByte")
    public void setZrnseihowebsbuktkjnm3(String pZrnseihowebsbuktkjnm3) {
        zrnseihowebsbuktkjnm3 = pZrnseihowebsbuktkjnm3;
    }


    @Column(order = 61, length = 8)
    @NotNull
    private String zrnseihowebsbuktseiymd3c;


    public String getZrnseihowebsbuktseiymd3c() {
        return zrnseihowebsbuktseiymd3c;
    }


    public void setZrnseihowebsbuktseiymd3c(String pZrnseihowebsbuktseiymd3c) {
        zrnseihowebsbuktseiymd3c = pZrnseihowebsbuktseiymd3c;
    }


    @Column(order = 62, length = 3)
    @NotNull
    private String zrnseihowebsbuktbnwari3c;


    public String getZrnseihowebsbuktbnwari3c() {
        return zrnseihowebsbuktbnwari3c;
    }


    public void setZrnseihowebsbuktbnwari3c(String pZrnseihowebsbuktbnwari3c) {
        zrnseihowebsbuktbnwari3c = pZrnseihowebsbuktbnwari3c;
    }


    @Column(order = 63, length = 1)
    @NotNull
    private String zrnseihowebsbukttdkkbn4;


    public String getZrnseihowebsbukttdkkbn4() {
        return zrnseihowebsbukttdkkbn4;
    }


    public void setZrnseihowebsbukttdkkbn4(String pZrnseihowebsbukttdkkbn4) {
        zrnseihowebsbukttdkkbn4 = pZrnseihowebsbukttdkkbn4;
    }


    @Column(order = 64, length = 18)
    @NotNull
    private String zrnseihowebsbuktknnm4;


    public String getZrnseihowebsbuktknnm4() {
        return zrnseihowebsbuktknnm4;
    }


    public void setZrnseihowebsbuktknnm4(String pZrnseihowebsbuktknnm4) {
        zrnseihowebsbuktknnm4 = pZrnseihowebsbuktknnm4;
    }


    @Column(order = 65, length = 11)
    @MultiByte
    @NotNull
    private String zrnseihowebsbuktkjnm4;


    public String getZrnseihowebsbuktkjnm4() {
        return zrnseihowebsbuktkjnm4;
    }


    @DataConvert("toMultiByte")
    public void setZrnseihowebsbuktkjnm4(String pZrnseihowebsbuktkjnm4) {
        zrnseihowebsbuktkjnm4 = pZrnseihowebsbuktkjnm4;
    }


    @Column(order = 66, length = 8)
    @NotNull
    private String zrnseihowebsbuktseiymd4c;


    public String getZrnseihowebsbuktseiymd4c() {
        return zrnseihowebsbuktseiymd4c;
    }


    public void setZrnseihowebsbuktseiymd4c(String pZrnseihowebsbuktseiymd4c) {
        zrnseihowebsbuktseiymd4c = pZrnseihowebsbuktseiymd4c;
    }


    @Column(order = 67, length = 3)
    @NotNull
    private String zrnseihowebsbuktbnwari4c;


    public String getZrnseihowebsbuktbnwari4c() {
        return zrnseihowebsbuktbnwari4c;
    }


    public void setZrnseihowebsbuktbnwari4c(String pZrnseihowebsbuktbnwari4c) {
        zrnseihowebsbuktbnwari4c = pZrnseihowebsbuktbnwari4c;
    }


    @Column(order = 68, length = 1)
    @NotNull
    private String zrnseihowebnkuktmrhhyj;


    public String getZrnseihowebnkuktmrhhyj() {
        return zrnseihowebnkuktmrhhyj;
    }


    public void setZrnseihowebnkuktmrhhyj(String pZrnseihowebnkuktmrhhyj) {
        zrnseihowebnkuktmrhhyj = pZrnseihowebnkuktmrhhyj;
    }


    @Column(order = 69, length = 2)
    @NotNull
    private String zrnseihowebsbnkkknc;


    public String getZrnseihowebsbnkkknc() {
        return zrnseihowebsbnkkknc;
    }


    public void setZrnseihowebsbnkkknc(String pZrnseihowebsbnkkknc) {
        zrnseihowebsbnkkknc = pZrnseihowebsbnkkknc;
    }


    @Column(order = 70, length = 1)
    @NotNull
    private String zrnseihowebikokakkjarihyj;


    public String getZrnseihowebikokakkjarihyj() {
        return zrnseihowebikokakkjarihyj;
    }


    public void setZrnseihowebikokakkjarihyj(String pZrnseihowebikokakkjarihyj) {
        zrnseihowebikokakkjarihyj = pZrnseihowebikokakkjarihyj;
    }


    @Column(order = 71, length = 1)
    @NotNull
    private String zrnseihowebfatcasnsiarihyj;


    public String getZrnseihowebfatcasnsiarihyj() {
        return zrnseihowebfatcasnsiarihyj;
    }


    public void setZrnseihowebfatcasnsiarihyj(String pZrnseihowebfatcasnsiarihyj) {
        zrnseihowebfatcasnsiarihyj = pZrnseihowebfatcasnsiarihyj;
    }


    @Column(order = 72, length = 3)
    @NotNull
    private String zrnseihowebkouhurisitencd;


    public String getZrnseihowebkouhurisitencd() {
        return zrnseihowebkouhurisitencd;
    }


    public void setZrnseihowebkouhurisitencd(String pZrnseihowebkouhurisitencd) {
        zrnseihowebkouhurisitencd = pZrnseihowebkouhurisitencd;
    }


    @Column(order = 73, length = 1)
    @NotNull
    private String zrnseihowebkouhuriyokinkbn;


    public String getZrnseihowebkouhuriyokinkbn() {
        return zrnseihowebkouhuriyokinkbn;
    }


    public void setZrnseihowebkouhuriyokinkbn(String pZrnseihowebkouhuriyokinkbn) {
        zrnseihowebkouhuriyokinkbn = pZrnseihowebkouhuriyokinkbn;
    }


    @Column(order = 74, length = 7)
    @NotNull
    private String zrnseihowebkouhurikouzano;


    public String getZrnseihowebkouhurikouzano() {
        return zrnseihowebkouhurikouzano;
    }


    public void setZrnseihowebkouhurikouzano(String pZrnseihowebkouhurikouzano) {
        zrnseihowebkouhurikouzano = pZrnseihowebkouhurikouzano;
    }


    @Column(order = 75, length = 1)
    @NotNull
    private String zrnseihowebkuhrshmnttdkhyj;


    public String getZrnseihowebkuhrshmnttdkhyj() {
        return zrnseihowebkuhrshmnttdkhyj;
    }


    public void setZrnseihowebkuhrshmnttdkhyj(String pZrnseihowebkuhrshmnttdkhyj) {
        zrnseihowebkuhrshmnttdkhyj = pZrnseihowebkuhrshmnttdkhyj;
    }


    @Column(order = 76, length = 8)
    @NotNull
    private String zrnseihowebmosymdc;


    public String getZrnseihowebmosymdc() {
        return zrnseihowebmosymdc;
    }


    public void setZrnseihowebmosymdc(String pZrnseihowebmosymdc) {
        zrnseihowebmosymdc = pZrnseihowebmosymdc;
    }


    @Column(order = 77, length = 8)
    @NotNull
    private String zrnseihowebsyokugyoukktymdc;


    public String getZrnseihowebsyokugyoukktymdc() {
        return zrnseihowebsyokugyoukktymdc;
    }


    public void setZrnseihowebsyokugyoukktymdc(String pZrnseihowebsyokugyoukktymdc) {
        zrnseihowebsyokugyoukktymdc = pZrnseihowebsyokugyoukktymdc;
    }


    @Column(order = 78, length = 3)
    @NotNull
    private String zrnseihowebhhknsintyouc;


    public String getZrnseihowebhhknsintyouc() {
        return zrnseihowebhhknsintyouc;
    }


    public void setZrnseihowebhhknsintyouc(String pZrnseihowebhhknsintyouc) {
        zrnseihowebhhknsintyouc = pZrnseihowebhhknsintyouc;
    }


    @Column(order = 79, length = 3)
    @NotNull
    private String zrnseihowebhhkntaijyuuc;


    public String getZrnseihowebhhkntaijyuuc() {
        return zrnseihowebhhkntaijyuuc;
    }


    public void setZrnseihowebhhkntaijyuuc(String pZrnseihowebhhkntaijyuuc) {
        zrnseihowebhhkntaijyuuc = pZrnseihowebhhkntaijyuuc;
    }


    @Column(order = 80, length = 8)
    @NotNull
    private String zrnseihowebkktymdc;


    public String getZrnseihowebkktymdc() {
        return zrnseihowebkktymdc;
    }


    public void setZrnseihowebkktymdc(String pZrnseihowebkktymdc) {
        zrnseihowebkktymdc = pZrnseihowebkktymdc;
    }


    @Column(order = 81, length = 1)
    @NotNull
    private String zrnseihowebhukusuustskskbn;


    public String getZrnseihowebhukusuustskskbn() {
        return zrnseihowebhukusuustskskbn;
    }


    public void setZrnseihowebhukusuustskskbn(String pZrnseihowebhukusuustskskbn) {
        zrnseihowebhukusuustskskbn = pZrnseihowebhukusuustskskbn;
    }


    @Column(order = 82, length = 2)
    @NotNull
    private String zrnseihowebhnnkaksyoruikbn;


    public String getZrnseihowebhnnkaksyoruikbn() {
        return zrnseihowebhnnkaksyoruikbn;
    }


    public void setZrnseihowebhnnkaksyoruikbn(String pZrnseihowebhnnkaksyoruikbn) {
        zrnseihowebhnnkaksyoruikbn = pZrnseihowebhnnkaksyoruikbn;
    }


    @Column(order = 83, length = 35)
    @MultiByte
    @NotNull
    private String zrnseihowebhsktkjikou;


    public String getZrnseihowebhsktkjikou() {
        return zrnseihowebhsktkjikou;
    }


    @DataConvert("toMultiByte")
    public void setZrnseihowebhsktkjikou(String pZrnseihowebhsktkjikou) {
        zrnseihowebhsktkjikou = pZrnseihowebhsktkjikou;
    }


    @Column(order = 84, length = 2)
    @NotNull
    private String zrnseihowebskskaksyoruikbn;


    public String getZrnseihowebskskaksyoruikbn() {
        return zrnseihowebskskaksyoruikbn;
    }


    public void setZrnseihowebskskaksyoruikbn(String pZrnseihowebskskaksyoruikbn) {
        zrnseihowebskskaksyoruikbn = pZrnseihowebskskaksyoruikbn;
    }


    @Column(order = 85, length = 35)
    @MultiByte
    @NotNull
    private String zrnseihowebskshsktkjikou;


    public String getZrnseihowebskshsktkjikou() {
        return zrnseihowebskshsktkjikou;
    }


    @DataConvert("toMultiByte")
    public void setZrnseihowebskshsktkjikou(String pZrnseihowebskshsktkjikou) {
        zrnseihowebskshsktkjikou = pZrnseihowebskshsktkjikou;
    }


    @Column(order = 86, length = 1)
    @NotNull
    private String zrnseihowebbikkjnssinfoari;


    public String getZrnseihowebbikkjnssinfoari() {
        return zrnseihowebbikkjnssinfoari;
    }


    public void setZrnseihowebbikkjnssinfoari(String pZrnseihowebbikkjnssinfoari) {
        zrnseihowebbikkjnssinfoari = pZrnseihowebbikkjnssinfoari;
    }


    @Column(order = 87, length = 13)
    @NotNull
    private String zrnseihowebplbsyutrkno;


    public String getZrnseihowebplbsyutrkno() {
        return zrnseihowebplbsyutrkno;
    }


    public void setZrnseihowebplbsyutrkno(String pZrnseihowebplbsyutrkno) {
        zrnseihowebplbsyutrkno = pZrnseihowebplbsyutrkno;
    }


    @Column(order = 88, length = 20)
    @NotNull
    private String zrnseihowebplbsyukouincd;


    public String getZrnseihowebplbsyukouincd() {
        return zrnseihowebplbsyukouincd;
    }


    public void setZrnseihowebplbsyukouincd(String pZrnseihowebplbsyukouincd) {
        zrnseihowebplbsyukouincd = pZrnseihowebplbsyukouincd;
    }


    @Column(order = 89, length = 13)
    @NotNull
    private String zrnseihowebnrkbsyutrkno;


    public String getZrnseihowebnrkbsyutrkno() {
        return zrnseihowebnrkbsyutrkno;
    }


    public void setZrnseihowebnrkbsyutrkno(String pZrnseihowebnrkbsyutrkno) {
        zrnseihowebnrkbsyutrkno = pZrnseihowebnrkbsyutrkno;
    }


    @Column(order = 90, length = 11)
    @NotNull
    private String zrnseihowebuktkid;


    public String getZrnseihowebuktkid() {
        return zrnseihowebuktkid;
    }


    public void setZrnseihowebuktkid(String pZrnseihowebuktkid) {
        zrnseihowebuktkid = pZrnseihowebuktkid;
    }


    @Column(order = 91, length = 8)
    @NotNull
    private String zrnseihowebdatasousinymdc;


    public String getZrnseihowebdatasousinymdc() {
        return zrnseihowebdatasousinymdc;
    }


    public void setZrnseihowebdatasousinymdc(String pZrnseihowebdatasousinymdc) {
        zrnseihowebdatasousinymdc = pZrnseihowebdatasousinymdc;
    }


    @Column(order = 92, length = 6)
    @NotNull
    private String zrnseihowebdatasousinhmsc;


    public String getZrnseihowebdatasousinhmsc() {
        return zrnseihowebdatasousinhmsc;
    }


    public void setZrnseihowebdatasousinhmsc(String pZrnseihowebdatasousinhmsc) {
        zrnseihowebdatasousinhmsc = pZrnseihowebdatasousinhmsc;
    }


    @Column(order = 93, length = 8)
    @NotNull
    private String zrnseihowebmosuktkymdc;


    public String getZrnseihowebmosuktkymdc() {
        return zrnseihowebmosuktkymdc;
    }


    public void setZrnseihowebmosuktkymdc(String pZrnseihowebmosuktkymdc) {
        zrnseihowebmosuktkymdc = pZrnseihowebmosuktkymdc;
    }


    @Column(order = 94, length = 50)
    @MultiByte
    @NotNull
    private String zrnseihowebhnnkakhskjk1;


    public String getZrnseihowebhnnkakhskjk1() {
        return zrnseihowebhnnkakhskjk1;
    }


    @DataConvert("toMultiByte")
    public void setZrnseihowebhnnkakhskjk1(String pZrnseihowebhnnkakhskjk1) {
        zrnseihowebhnnkakhskjk1 = pZrnseihowebhnnkakhskjk1;
    }


    @Column(order = 95, length = 50)
    @MultiByte
    @NotNull
    private String zrnseihowebhnnkakhskjk2;


    public String getZrnseihowebhnnkakhskjk2() {
        return zrnseihowebhnnkakhskjk2;
    }


    @DataConvert("toMultiByte")
    public void setZrnseihowebhnnkakhskjk2(String pZrnseihowebhnnkakhskjk2) {
        zrnseihowebhnnkakhskjk2 = pZrnseihowebhnnkakhskjk2;
    }


    @Column(order = 96, length = 50)
    @MultiByte
    @NotNull
    private String zrnseihowebhnnkakhskjk3;


    public String getZrnseihowebhnnkakhskjk3() {
        return zrnseihowebhnnkakhskjk3;
    }


    @DataConvert("toMultiByte")
    public void setZrnseihowebhnnkakhskjk3(String pZrnseihowebhnnkakhskjk3) {
        zrnseihowebhnnkakhskjk3 = pZrnseihowebhnnkakhskjk3;
    }


    @Column(order = 97, length = 50)
    @MultiByte
    @NotNull
    private String zrnseihowebhnnkakhskjk4;


    public String getZrnseihowebhnnkakhskjk4() {
        return zrnseihowebhnnkakhskjk4;
    }


    @DataConvert("toMultiByte")
    public void setZrnseihowebhnnkakhskjk4(String pZrnseihowebhnnkakhskjk4) {
        zrnseihowebhnnkakhskjk4 = pZrnseihowebhnnkakhskjk4;
    }


    @Column(order = 98, length = 50)
    @MultiByte
    @NotNull
    private String zrnseihowebhnnkakhskjk5;


    public String getZrnseihowebhnnkakhskjk5() {
        return zrnseihowebhnnkakhskjk5;
    }


    @DataConvert("toMultiByte")
    public void setZrnseihowebhnnkakhskjk5(String pZrnseihowebhnnkakhskjk5) {
        zrnseihowebhnnkakhskjk5 = pZrnseihowebhnnkakhskjk5;
    }


    @Column(order = 99, length = 50)
    @MultiByte
    @NotNull
    private String zrnseihowebtorihoutkjk1;


    public String getZrnseihowebtorihoutkjk1() {
        return zrnseihowebtorihoutkjk1;
    }


    @DataConvert("toMultiByte")
    public void setZrnseihowebtorihoutkjk1(String pZrnseihowebtorihoutkjk1) {
        zrnseihowebtorihoutkjk1 = pZrnseihowebtorihoutkjk1;
    }


    @Column(order = 100, length = 50)
    @MultiByte
    @NotNull
    private String zrnseihowebtorihoutkjk2;


    public String getZrnseihowebtorihoutkjk2() {
        return zrnseihowebtorihoutkjk2;
    }


    @DataConvert("toMultiByte")
    public void setZrnseihowebtorihoutkjk2(String pZrnseihowebtorihoutkjk2) {
        zrnseihowebtorihoutkjk2 = pZrnseihowebtorihoutkjk2;
    }


    @Column(order = 101, length = 50)
    @MultiByte
    @NotNull
    private String zrnseihowebtorihoutkjk3;


    public String getZrnseihowebtorihoutkjk3() {
        return zrnseihowebtorihoutkjk3;
    }


    @DataConvert("toMultiByte")
    public void setZrnseihowebtorihoutkjk3(String pZrnseihowebtorihoutkjk3) {
        zrnseihowebtorihoutkjk3 = pZrnseihowebtorihoutkjk3;
    }


    @Column(order = 102, length = 50)
    @MultiByte
    @NotNull
    private String zrnseihowebtorihoutkjk4;


    public String getZrnseihowebtorihoutkjk4() {
        return zrnseihowebtorihoutkjk4;
    }


    @DataConvert("toMultiByte")
    public void setZrnseihowebtorihoutkjk4(String pZrnseihowebtorihoutkjk4) {
        zrnseihowebtorihoutkjk4 = pZrnseihowebtorihoutkjk4;
    }


    @Column(order = 103, length = 50)
    @MultiByte
    @NotNull
    private String zrnseihowebtorihoutkjk5;


    public String getZrnseihowebtorihoutkjk5() {
        return zrnseihowebtorihoutkjk5;
    }


    @DataConvert("toMultiByte")
    public void setZrnseihowebtorihoutkjk5(String pZrnseihowebtorihoutkjk5) {
        zrnseihowebtorihoutkjk5 = pZrnseihowebtorihoutkjk5;
    }


    @Column(order = 104, length = 11)
    @NotNull
    private String zrnseihowebdrtnskno;


    public String getZrnseihowebdrtnskno() {
        return zrnseihowebdrtnskno;
    }


    public void setZrnseihowebdrtnskno(String pZrnseihowebdrtnskno) {
        zrnseihowebdrtnskno = pZrnseihowebdrtnskno;
    }


    @Column(order = 105, length = 1)
    @NotNull
    private String zrnseihowebsbnksyukbn;


    public String getZrnseihowebsbnksyukbn() {
        return zrnseihowebsbnksyukbn;
    }


    public void setZrnseihowebsbnksyukbn(String pZrnseihowebsbnksyukbn) {
        zrnseihowebsbnksyukbn = pZrnseihowebsbnksyukbn;
    }


    @Column(order = 106, length = 4)
    @NotNull
    private String zrnseihowebaatkisyaknyuucd;


    public String getZrnseihowebaatkisyaknyuucd() {
        return zrnseihowebaatkisyaknyuucd;
    }


    public void setZrnseihowebaatkisyaknyuucd(String pZrnseihowebaatkisyaknyuucd) {
        zrnseihowebaatkisyaknyuucd = pZrnseihowebaatkisyaknyuucd;
    }


    @Column(order = 107, length = 1)
    @NotNull
    private String zrnseihowebkktttykknrhyj;


    public String getZrnseihowebkktttykknrhyj() {
        return zrnseihowebkktttykknrhyj;
    }


    public void setZrnseihowebkktttykknrhyj(String pZrnseihowebkktttykknrhyj) {
        zrnseihowebkktttykknrhyj = pZrnseihowebkktttykknrhyj;
    }


    @Column(order = 108, length = 1)
    @NotNull
    private String zrnseihowebdtlkktarihyj;


    public String getZrnseihowebdtlkktarihyj() {
        return zrnseihowebdtlkktarihyj;
    }


    public void setZrnseihowebdtlkktarihyj(String pZrnseihowebdtlkktarihyj) {
        zrnseihowebdtlkktarihyj = pZrnseihowebdtlkktarihyj;
    }


    @Column(order = 109, length = 1)
    @NotNull
    private String zrnseihowebfatcasyoruiari;


    public String getZrnseihowebfatcasyoruiari() {
        return zrnseihowebfatcasyoruiari;
    }


    public void setZrnseihowebfatcasyoruiari(String pZrnseihowebfatcasyoruiari) {
        zrnseihowebfatcasyoruiari = pZrnseihowebfatcasyoruiari;
    }


    @Column(order = 110, length = 4)
    @NotNull
    private String zrnseihowebkzhurikaebankcd;


    public String getZrnseihowebkzhurikaebankcd() {
        return zrnseihowebkzhurikaebankcd;
    }


    public void setZrnseihowebkzhurikaebankcd(String pZrnseihowebkzhurikaebankcd) {
        zrnseihowebkzhurikaebankcd = pZrnseihowebkzhurikaebankcd;
    }


    @Column(order = 111, length = 1)
    @NotNull
    private String zrnseihowebkzkakiraikbn;


    public String getZrnseihowebkzkakiraikbn() {
        return zrnseihowebkzkakiraikbn;
    }


    public void setZrnseihowebkzkakiraikbn(String pZrnseihowebkzkakiraikbn) {
        zrnseihowebkzkakiraikbn = pZrnseihowebkzkakiraikbn;
    }


    @Column(order = 112, length = 1)
    @NotNull
    private String zrnseihowebbmierrorhyj;


    public String getZrnseihowebbmierrorhyj() {
        return zrnseihowebbmierrorhyj;
    }


    public void setZrnseihowebbmierrorhyj(String pZrnseihowebbmierrorhyj) {
        zrnseihowebbmierrorhyj = pZrnseihowebbmierrorhyj;
    }


    @Column(order = 113, length = 1)
    @NotNull
    private String zrnseihowebkktkmgituarihyj;


    public String getZrnseihowebkktkmgituarihyj() {
        return zrnseihowebkktkmgituarihyj;
    }


    public void setZrnseihowebkktkmgituarihyj(String pZrnseihowebkktkmgituarihyj) {
        zrnseihowebkktkmgituarihyj = pZrnseihowebkktkmgituarihyj;
    }


    @Column(order = 114, length = 1)
    @NotNull
    private String zrnseihowebsnshuhukbn;


    public String getZrnseihowebsnshuhukbn() {
        return zrnseihowebsnshuhukbn;
    }


    public void setZrnseihowebsnshuhukbn(String pZrnseihowebsnshuhukbn) {
        zrnseihowebsnshuhukbn = pZrnseihowebsnshuhukbn;
    }


    @Column(order = 115, length = 1)
    @NotNull
    private String zrnseihowebkeihidouituhyj;


    public String getZrnseihowebkeihidouituhyj() {
        return zrnseihowebkeihidouituhyj;
    }


    public void setZrnseihowebkeihidouituhyj(String pZrnseihowebkeihidouituhyj) {
        zrnseihowebkeihidouituhyj = pZrnseihowebkeihidouituhyj;
    }


    @Column(order = 116, length = 1)
    @NotNull
    private String zrnseihowebaeoisnsiarihyj;


    public String getZrnseihowebaeoisnsiarihyj() {
        return zrnseihowebaeoisnsiarihyj;
    }


    public void setZrnseihowebaeoisnsiarihyj(String pZrnseihowebaeoisnsiarihyj) {
        zrnseihowebaeoisnsiarihyj = pZrnseihowebaeoisnsiarihyj;
    }


    @Column(order = 117, length = 1)
    @NotNull
    private String zrnseihowebsiteituukakbn;


    public String getZrnseihowebsiteituukakbn() {
        return zrnseihowebsiteituukakbn;
    }


    public void setZrnseihowebsiteituukakbn(String pZrnseihowebsiteituukakbn) {
        zrnseihowebsiteituukakbn = pZrnseihowebsiteituukakbn;
    }


    @Column(order = 118, length = 1)
    @NotNull
    private String zrnseihowebnykntuukakbn;


    public String getZrnseihowebnykntuukakbn() {
        return zrnseihowebnykntuukakbn;
    }


    public void setZrnseihowebnykntuukakbn(String pZrnseihowebnykntuukakbn) {
        zrnseihowebnykntuukakbn = pZrnseihowebnykntuukakbn;
    }


    @Column(order = 119, length = 1)
    @NotNull
    private String zrnseihowebtargettkarihyj;


    public String getZrnseihowebtargettkarihyj() {
        return zrnseihowebtargettkarihyj;
    }


    public void setZrnseihowebtargettkarihyj(String pZrnseihowebtargettkarihyj) {
        zrnseihowebtargettkarihyj = pZrnseihowebtargettkarihyj;
    }


    @Column(order = 120, length = 1)
    @NotNull
    private String zrnseihowebtargettkkbn;


    public String getZrnseihowebtargettkkbn() {
        return zrnseihowebtargettkkbn;
    }


    public void setZrnseihowebtargettkkbn(String pZrnseihowebtargettkkbn) {
        zrnseihowebtargettkkbn = pZrnseihowebtargettkkbn;
    }


    @Column(order = 121, length = 3)
    @NotNull
    private String zrnseihowebtargettkmkhtc;


    public String getZrnseihowebtargettkmkhtc() {
        return zrnseihowebtargettkmkhtc;
    }


    public void setZrnseihowebtargettkmkhtc(String pZrnseihowebtargettkmkhtc) {
        zrnseihowebtargettkmkhtc = pZrnseihowebtargettkmkhtc;
    }


    @Column(order = 122, length = 10)
    @NotNull
    private String zrnseihowebnykntuukanykngkc;


    public String getZrnseihowebnykntuukanykngkc() {
        return zrnseihowebnykntuukanykngkc;
    }


    public void setZrnseihowebnykntuukanykngkc(String pZrnseihowebnykntuukanykngkc) {
        zrnseihowebnykntuukanykngkc = pZrnseihowebnykntuukanykngkc;
    }


    @Column(order = 123, length = 10)
    @NotNull
    private String zrnseihowebnykntukfsthrkpc;


    public String getZrnseihowebnykntukfsthrkpc() {
        return zrnseihowebnykntukfsthrkpc;
    }


    public void setZrnseihowebnykntukfsthrkpc(String pZrnseihowebnykntukfsthrkpc) {
        zrnseihowebnykntukfsthrkpc = pZrnseihowebnykntukfsthrkpc;
    }


    @Column(order = 124, length = 10)
    @NotNull
    private String zrnseihowebnykntuknexthrkpc;


    public String getZrnseihowebnykntuknexthrkpc() {
        return zrnseihowebnykntuknexthrkpc;
    }


    public void setZrnseihowebnykntuknexthrkpc(String pZrnseihowebnykntuknexthrkpc) {
        zrnseihowebnykntuknexthrkpc = pZrnseihowebnykntuknexthrkpc;
    }


    @Column(order = 125, length = 10)
    @NotNull
    private String zrnseihowebtargetyenknsnpc;


    public String getZrnseihowebtargetyenknsnpc() {
        return zrnseihowebtargetyenknsnpc;
    }


    public void setZrnseihowebtargetyenknsnpc(String pZrnseihowebtargetyenknsnpc) {
        zrnseihowebtargetyenknsnpc = pZrnseihowebtargetyenknsnpc;
    }


    @Column(order = 126, length = 10)
    @NotNull
    private String zrnseihowebtargetmkhgkc;


    public String getZrnseihowebtargetmkhgkc() {
        return zrnseihowebtargetmkhgkc;
    }


    public void setZrnseihowebtargetmkhgkc(String pZrnseihowebtargetmkhgkc) {
        zrnseihowebtargetmkhgkc = pZrnseihowebtargetmkhgkc;
    }


    @Column(order = 127, length = 1)
    @NotNull
    private String zrnseihowebsaimankihyj;


    public String getZrnseihowebsaimankihyj() {
        return zrnseihowebsaimankihyj;
    }


    public void setZrnseihowebsaimankihyj(String pZrnseihowebsaimankihyj) {
        zrnseihowebsaimankihyj = pZrnseihowebsaimankihyj;
    }


    @Column(order = 128, length = 1)
    @NotNull
    private String zrnseihowebrayhyj;


    public String getZrnseihowebrayhyj() {
        return zrnseihowebrayhyj;
    }


    public void setZrnseihowebrayhyj(String pZrnseihowebrayhyj) {
        zrnseihowebrayhyj = pZrnseihowebrayhyj;
    }


    @Column(order = 129, length = 156)
    @NotNull
    private String zrnyobiv156;


    public String getZrnyobiv156() {
        return zrnyobiv156;
    }


    public void setZrnyobiv156(String pZrnyobiv156) {
        zrnyobiv156 = pZrnyobiv156;
    }


    @Column(order = 130, length = 1)
    @NotNull
    private String zrnseihowebpsyouhyj;


    public String getZrnseihowebpsyouhyj() {
        return zrnseihowebpsyouhyj;
    }


    public void setZrnseihowebpsyouhyj(String pZrnseihowebpsyouhyj) {
        zrnseihowebpsyouhyj = pZrnseihowebpsyouhyj;
    }


    @Column(order = 131, length = 11)
    @MultiByte
    @NotNull
    private String zrnseihowebplhhknkjnm;


    public String getZrnseihowebplhhknkjnm() {
        return zrnseihowebplhhknkjnm;
    }


    @DataConvert("toMultiByte")
    public void setZrnseihowebplhhknkjnm(String pZrnseihowebplhhknkjnm) {
        zrnseihowebplhhknkjnm = pZrnseihowebplhhknkjnm;
    }


    @Column(order = 132, length = 1)
    @NotNull
    private String zrnyobiv1;


    public String getZrnyobiv1() {
        return zrnyobiv1;
    }


    public void setZrnyobiv1(String pZrnyobiv1) {
        zrnyobiv1 = pZrnyobiv1;
    }


    @Column(order = 133, length = 11)
    @MultiByte
    @NotNull
    private String zrnseihowebplkykkjnm;


    public String getZrnseihowebplkykkjnm() {
        return zrnseihowebplkykkjnm;
    }


    @DataConvert("toMultiByte")
    public void setZrnseihowebplkykkjnm(String pZrnseihowebplkykkjnm) {
        zrnseihowebplkykkjnm = pZrnseihowebplkykkjnm;
    }


    @Column(order = 134, length = 1)
    @NotNull
    private String zrnseihowebplhjkktkbn;


    public String getZrnseihowebplhjkktkbn() {
        return zrnseihowebplhjkktkbn;
    }


    public void setZrnseihowebplhjkktkbn(String pZrnseihowebplhjkktkbn) {
        zrnseihowebplhjkktkbn = pZrnseihowebplhjkktkbn;
    }


    @Column(order = 135, length = 1)
    @NotNull
    private String zrnseihowebplhrkkeirokbn;


    public String getZrnseihowebplhrkkeirokbn() {
        return zrnseihowebplhrkkeirokbn;
    }


    public void setZrnseihowebplhrkkeirokbn(String pZrnseihowebplhrkkeirokbn) {
        zrnseihowebplhrkkeirokbn = pZrnseihowebplhrkkeirokbn;
    }


    @Column(order = 136, length = 1)
    @NotNull
    private String zrnseihowebplnkshrarihyj;


    public String getZrnseihowebplnkshrarihyj() {
        return zrnseihowebplnkshrarihyj;
    }


    public void setZrnseihowebplnkshrarihyj(String pZrnseihowebplnkshrarihyj) {
        zrnseihowebplnkshrarihyj = pZrnseihowebplnkshrarihyj;
    }


    @Column(order = 137, length = 2)
    @NotNull
    private String zrnyobiv2;


    public String getZrnyobiv2() {
        return zrnyobiv2;
    }


    public void setZrnyobiv2(String pZrnyobiv2) {
        zrnyobiv2 = pZrnyobiv2;
    }


    @Column(order = 138, length = 9)
    @NotNull
    private String zrnseihowebplmosnoc;


    public String getZrnseihowebplmosnoc() {
        return zrnseihowebplmosnoc;
    }


    public void setZrnseihowebplmosnoc(String pZrnseihowebplmosnoc) {
        zrnseihowebplmosnoc = pZrnseihowebplmosnoc;
    }


    @Column(order = 139, length = 1)
    @NotNull
    private String zrnseihowebplsbuktnrkkbn;


    public String getZrnseihowebplsbuktnrkkbn() {
        return zrnseihowebplsbuktnrkkbn;
    }


    public void setZrnseihowebplsbuktnrkkbn(String pZrnseihowebplsbuktnrkkbn) {
        zrnseihowebplsbuktnrkkbn = pZrnseihowebplsbuktnrkkbn;
    }


    @Column(order = 140, length = 1)
    @NotNull
    private String zrnseihowebplsbukttdkkbn;


    public String getZrnseihowebplsbukttdkkbn() {
        return zrnseihowebplsbukttdkkbn;
    }


    public void setZrnseihowebplsbukttdkkbn(String pZrnseihowebplsbukttdkkbn) {
        zrnseihowebplsbukttdkkbn = pZrnseihowebplsbukttdkkbn;
    }


    @Column(order = 141, length = 18)
    @NotNull
    private String zrnseihowebplsbuktknnm;


    public String getZrnseihowebplsbuktknnm() {
        return zrnseihowebplsbuktknnm;
    }


    public void setZrnseihowebplsbuktknnm(String pZrnseihowebplsbuktknnm) {
        zrnseihowebplsbuktknnm = pZrnseihowebplsbuktknnm;
    }


    @Column(order = 142, length = 11)
    @MultiByte
    @NotNull
    private String zrnseihowebplsbuktkjnm;


    public String getZrnseihowebplsbuktkjnm() {
        return zrnseihowebplsbuktkjnm;
    }


    @DataConvert("toMultiByte")
    public void setZrnseihowebplsbuktkjnm(String pZrnseihowebplsbuktkjnm) {
        zrnseihowebplsbuktkjnm = pZrnseihowebplsbuktkjnm;
    }


    @Column(order = 143, length = 3)
    @NotNull
    private String zrnyobiv3;


    public String getZrnyobiv3() {
        return zrnyobiv3;
    }


    public void setZrnyobiv3(String pZrnyobiv3) {
        zrnyobiv3 = pZrnyobiv3;
    }


    @Column(order = 144, length = 8)
    @NotNull
    private String zrnseihowebplsbuktseiymdc;


    public String getZrnseihowebplsbuktseiymdc() {
        return zrnseihowebplsbuktseiymdc;
    }


    public void setZrnseihowebplsbuktseiymdc(String pZrnseihowebplsbuktseiymdc) {
        zrnseihowebplsbuktseiymdc = pZrnseihowebplsbuktseiymdc;
    }


    @Column(order = 145, length = 2)
    @NotNull
    private String zrnseihowebpltksykmcd1;


    public String getZrnseihowebpltksykmcd1() {
        return zrnseihowebpltksykmcd1;
    }


    public void setZrnseihowebpltksykmcd1(String pZrnseihowebpltksykmcd1) {
        zrnseihowebpltksykmcd1 = pZrnseihowebpltksykmcd1;
    }


    @Column(order = 146, length = 2)
    @NotNull
    private String zrnseihowebpltksykmcd2;


    public String getZrnseihowebpltksykmcd2() {
        return zrnseihowebpltksykmcd2;
    }


    public void setZrnseihowebpltksykmcd2(String pZrnseihowebpltksykmcd2) {
        zrnseihowebpltksykmcd2 = pZrnseihowebpltksykmcd2;
    }


    @Column(order = 147, length = 2)
    @NotNull
    private String zrnseihowebpltksykmcd3;


    public String getZrnseihowebpltksykmcd3() {
        return zrnseihowebpltksykmcd3;
    }


    public void setZrnseihowebpltksykmcd3(String pZrnseihowebpltksykmcd3) {
        zrnseihowebpltksykmcd3 = pZrnseihowebpltksykmcd3;
    }


    @Column(order = 148, length = 2)
    @NotNull
    private String zrnseihowebpltksykmcd4;


    public String getZrnseihowebpltksykmcd4() {
        return zrnseihowebpltksykmcd4;
    }


    public void setZrnseihowebpltksykmcd4(String pZrnseihowebpltksykmcd4) {
        zrnseihowebpltksykmcd4 = pZrnseihowebpltksykmcd4;
    }


    @Column(order = 149, length = 2)
    @NotNull
    private String zrnseihowebpltksykmcd5;


    public String getZrnseihowebpltksykmcd5() {
        return zrnseihowebpltksykmcd5;
    }


    public void setZrnseihowebpltksykmcd5(String pZrnseihowebpltksykmcd5) {
        zrnseihowebpltksykmcd5 = pZrnseihowebpltksykmcd5;
    }


    @Column(order = 150, length = 14)
    @NotNull
    private String zrnseihowebplkyktelno;


    public String getZrnseihowebplkyktelno() {
        return zrnseihowebplkyktelno;
    }


    public void setZrnseihowebplkyktelno(String pZrnseihowebplkyktelno) {
        zrnseihowebplkyktelno = pZrnseihowebplkyktelno;
    }


    @Column(order = 151, length = 14)
    @NotNull
    private String zrnseihowebplhhkntelno;


    public String getZrnseihowebplhhkntelno() {
        return zrnseihowebplhhkntelno;
    }


    public void setZrnseihowebplhhkntelno(String pZrnseihowebplhhkntelno) {
        zrnseihowebplhhkntelno = pZrnseihowebplhhkntelno;
    }


    @Column(order = 152, length = 3)
    @NotNull
    private String zrnyobiv3x2;


    public String getZrnyobiv3x2() {
        return zrnyobiv3x2;
    }


    public void setZrnyobiv3x2(String pZrnyobiv3x2) {
        zrnyobiv3x2 = pZrnyobiv3x2;
    }


    @Column(order = 153, length = 8)
    @NotNull
    private String zrnseihowebplkihontikucd;


    public String getZrnseihowebplkihontikucd() {
        return zrnseihowebplkihontikucd;
    }


    public void setZrnseihowebplkihontikucd(String pZrnseihowebplkihontikucd) {
        zrnseihowebplkihontikucd = pZrnseihowebplkihontikucd;
    }


    @Column(order = 154, length = 62)
    @MultiByte
    @NotNull
    private String zrnseihowebpltsinadrkai;


    public String getZrnseihowebpltsinadrkai() {
        return zrnseihowebpltsinadrkai;
    }


    @DataConvert("toMultiByte")
    public void setZrnseihowebpltsinadrkai(String pZrnseihowebpltsinadrkai) {
        zrnseihowebpltsinadrkai = pZrnseihowebpltsinadrkai;
    }


    @Column(order = 155, length = 8)
    @NotNull
    private String zrnseihowebplhiikihontikucd;


    public String getZrnseihowebplhiikihontikucd() {
        return zrnseihowebplhiikihontikucd;
    }


    public void setZrnseihowebplhiikihontikucd(String pZrnseihowebplhiikihontikucd) {
        zrnseihowebplhiikihontikucd = pZrnseihowebplhiikihontikucd;
    }


    @Column(order = 156, length = 124)
    @MultiByte
    @NotNull
    private String zrnseihowebplhhknadr;


    public String getZrnseihowebplhhknadr() {
        return zrnseihowebplhhknadr;
    }


    @DataConvert("toMultiByte")
    public void setZrnseihowebplhhknadr(String pZrnseihowebplhhknadr) {
        zrnseihowebplhhknadr = pZrnseihowebplhhknadr;
    }


    @Column(order = 157, length = 13)
    @NotNull
    private String zrnseihowebgnykntuknykngkc;


    public String getZrnseihowebgnykntuknykngkc() {
        return zrnseihowebgnykntuknykngkc;
    }


    public void setZrnseihowebgnykntuknykngkc(String pZrnseihowebgnykntuknykngkc) {
        zrnseihowebgnykntuknykngkc = pZrnseihowebgnykntuknykngkc;
    }


    @Column(order = 158, length = 13)
    @NotNull
    private String zrnseihowebgnykntukfsthrkpc;


    public String getZrnseihowebgnykntukfsthrkpc() {
        return zrnseihowebgnykntukfsthrkpc;
    }


    public void setZrnseihowebgnykntukfsthrkpc(String pZrnseihowebgnykntukfsthrkpc) {
        zrnseihowebgnykntukfsthrkpc = pZrnseihowebgnykntukfsthrkpc;
    }


    @Column(order = 159, length = 13)
    @NotNull
    private String zrnseihowebgnykntuknxthrkpc;


    public String getZrnseihowebgnykntuknxthrkpc() {
        return zrnseihowebgnykntuknxthrkpc;
    }


    public void setZrnseihowebgnykntuknxthrkpc(String pZrnseihowebgnykntuknxthrkpc) {
        zrnseihowebgnykntuknxthrkpc = pZrnseihowebgnykntuknxthrkpc;
    }


    @Column(order = 160, length = 13)
    @NotNull
    private String zrnseihowebgaikakihonpc;


    public String getZrnseihowebgaikakihonpc() {
        return zrnseihowebgaikakihonpc;
    }


    public void setZrnseihowebgaikakihonpc(String pZrnseihowebgaikakihonpc) {
        zrnseihowebgaikakihonpc = pZrnseihowebgaikakihonpc;
    }


    @Column(order = 161, length = 1)
    @NotNull
    private String zrnseihowebkaigmehrtkarihyj;


    public String getZrnseihowebkaigmehrtkarihyj() {
        return zrnseihowebkaigmehrtkarihyj;
    }


    public void setZrnseihowebkaigmehrtkarihyj(String pZrnseihowebkaigmehrtkarihyj) {
        zrnseihowebkaigmehrtkarihyj = pZrnseihowebkaigmehrtkarihyj;
    }


    @Column(order = 162, length = 1)
    @NotNull
    private String zrnseihowebyenhsyutkarihyj;


    public String getZrnseihowebyenhsyutkarihyj() {
        return zrnseihowebyenhsyutkarihyj;
    }


    public void setZrnseihowebyenhsyutkarihyj(String pZrnseihowebyenhsyutkarihyj) {
        zrnseihowebyenhsyutkarihyj = pZrnseihowebyenhsyutkarihyj;
    }


    @Column(order = 163, length = 13)
    @NotNull
    private String zrnseihowebgaikakihonsc;


    public String getZrnseihowebgaikakihonsc() {
        return zrnseihowebgaikakihonsc;
    }


    public void setZrnseihowebgaikakihonsc(String pZrnseihowebgaikakihonsc) {
        zrnseihowebgaikakihonsc = pZrnseihowebgaikakihonsc;
    }


    @Column(order = 164, length = 2)
    @NotNull
    private String zrnseihowebdai1hknkknc;


    public String getZrnseihowebdai1hknkknc() {
        return zrnseihowebdai1hknkknc;
    }


    public void setZrnseihowebdai1hknkknc(String pZrnseihowebdai1hknkknc) {
        zrnseihowebdai1hknkknc = pZrnseihowebdai1hknkknc;
    }


    @Column(order = 165, length = 1)
    @NotNull
    private String zrnseihowebdsmoshyj;


    public String getZrnseihowebdsmoshyj() {
        return zrnseihowebdsmoshyj;
    }


    public void setZrnseihowebdsmoshyj(String pZrnseihowebdsmoshyj) {
        zrnseihowebdsmoshyj = pZrnseihowebdsmoshyj;
    }


    @Column(order = 166, length = 100)
    @NotNull
    private String zrnseihowebdsmailaddress;


    public String getZrnseihowebdsmailaddress() {
        return zrnseihowebdsmailaddress;
    }


    public void setZrnseihowebdsmailaddress(String pZrnseihowebdsmailaddress) {
        zrnseihowebdsmailaddress = pZrnseihowebdsmailaddress;
    }


    @Column(order = 167, length = 15)
    @NotNull
    private String zrnseihowebankenkanrino;


    public String getZrnseihowebankenkanrino() {
        return zrnseihowebankenkanrino;
    }


    public void setZrnseihowebankenkanrino(String pZrnseihowebankenkanrino) {
        zrnseihowebankenkanrino = pZrnseihowebankenkanrino;
    }


    @Column(order = 168, length = 7)
    @NotNull
    private String zrnseihowebkydbosyuukjncd;


    public String getZrnseihowebkydbosyuukjncd() {
        return zrnseihowebkydbosyuukjncd;
    }


    public void setZrnseihowebkydbosyuukjncd(String pZrnseihowebkydbosyuukjncd) {
        zrnseihowebkydbosyuukjncd = pZrnseihowebkydbosyuukjncd;
    }


    @Column(order = 169, length = 1)
    @NotNull
    private String zrnseihowebhnyppltzmhyj;


    public String getZrnseihowebhnyppltzmhyj() {
        return zrnseihowebhnyppltzmhyj;
    }


    public void setZrnseihowebhnyppltzmhyj(String pZrnseihowebhnyppltzmhyj) {
        zrnseihowebhnyppltzmhyj = pZrnseihowebhnyppltzmhyj;
    }


    @Column(order = 170, length = 3)
    @NotNull
    private String zrnseihowebssrndhbnwrc;


    public String getZrnseihowebssrndhbnwrc() {
        return zrnseihowebssrndhbnwrc;
    }


    public void setZrnseihowebssrndhbnwrc(String pZrnseihowebssrndhbnwrc) {
        zrnseihowebssrndhbnwrc = pZrnseihowebssrndhbnwrc;
    }


    @Column(order = 171, length = 3)
    @NotNull
    private String zrnseihowebtrtrndhbnwrc;


    public String getZrnseihowebtrtrndhbnwrc() {
        return zrnseihowebtrtrndhbnwrc;
    }


    public void setZrnseihowebtrtrndhbnwrc(String pZrnseihowebtrtrndhbnwrc) {
        zrnseihowebtrtrndhbnwrc = pZrnseihowebtrtrndhbnwrc;
    }


    @Column(order = 172, length = 2)
    @NotNull
    private String zrnseihowebsueokikknc;


    public String getZrnseihowebsueokikknc() {
        return zrnseihowebsueokikknc;
    }


    public void setZrnseihowebsueokikknc(String pZrnseihowebsueokikknc) {
        zrnseihowebsueokikknc = pZrnseihowebsueokikknc;
    }


    @Column(order = 173, length = 1)
    @NotNull
    private String zrnseihowebmnkuktnrkkbn;


    public String getZrnseihowebmnkuktnrkkbn() {
        return zrnseihowebmnkuktnrkkbn;
    }


    public void setZrnseihowebmnkuktnrkkbn(String pZrnseihowebmnkuktnrkkbn) {
        zrnseihowebmnkuktnrkkbn = pZrnseihowebmnkuktnrkkbn;
    }


    @Column(order = 174, length = 1)
    @NotNull
    private String zrnseihowebmnkukttdkkbn;


    public String getZrnseihowebmnkukttdkkbn() {
        return zrnseihowebmnkukttdkkbn;
    }


    public void setZrnseihowebmnkukttdkkbn(String pZrnseihowebmnkukttdkkbn) {
        zrnseihowebmnkukttdkkbn = pZrnseihowebmnkukttdkkbn;
    }


    @Column(order = 175, length = 18)
    @NotNull
    private String zrnseihowebmnkuktknnm;


    public String getZrnseihowebmnkuktknnm() {
        return zrnseihowebmnkuktknnm;
    }


    public void setZrnseihowebmnkuktknnm(String pZrnseihowebmnkuktknnm) {
        zrnseihowebmnkuktknnm = pZrnseihowebmnkuktknnm;
    }


    @Column(order = 176, length = 11)
    @MultiByte
    @NotNull
    private String zrnseihowebmnkuktkjnm;


    public String getZrnseihowebmnkuktkjnm() {
        return zrnseihowebmnkuktkjnm;
    }


    @DataConvert("toMultiByte")
    public void setZrnseihowebmnkuktkjnm(String pZrnseihowebmnkuktkjnm) {
        zrnseihowebmnkuktkjnm = pZrnseihowebmnkuktkjnm;
    }


    @Column(order = 177, length = 8)
    @NotNull
    private String zrnseihowebmnkuktseiymdc;


    public String getZrnseihowebmnkuktseiymdc() {
        return zrnseihowebmnkuktseiymdc;
    }


    public void setZrnseihowebmnkuktseiymdc(String pZrnseihowebmnkuktseiymdc) {
        zrnseihowebmnkuktseiymdc = pZrnseihowebmnkuktseiymdc;
    }


    @Column(order = 178, length = 30)
    @NotNull
    private String zrnseihowebdsknkzmeigi;


    public String getZrnseihowebdsknkzmeigi() {
        return zrnseihowebdsknkzmeigi;
    }


    public void setZrnseihowebdsknkzmeigi(String pZrnseihowebdsknkzmeigi) {
        zrnseihowebdsknkzmeigi = pZrnseihowebdsknkzmeigi;
    }


    @Column(order = 179, length = 1)
    @NotNull
    private String zrnseihowebdskzsyuruikbn;


    public String getZrnseihowebdskzsyuruikbn() {
        return zrnseihowebdskzsyuruikbn;
    }


    public void setZrnseihowebdskzsyuruikbn(String pZrnseihowebdskzsyuruikbn) {
        zrnseihowebdskzsyuruikbn = pZrnseihowebdskzsyuruikbn;
    }


    @Column(order = 180, length = 4)
    @NotNull
    private String zrnseihowebdskinyuucd;


    public String getZrnseihowebdskinyuucd() {
        return zrnseihowebdskinyuucd;
    }


    public void setZrnseihowebdskinyuucd(String pZrnseihowebdskinyuucd) {
        zrnseihowebdskinyuucd = pZrnseihowebdskinyuucd;
    }


    @Column(order = 181, length = 3)
    @NotNull
    private String zrnseihowebdssitencd;


    public String getZrnseihowebdssitencd() {
        return zrnseihowebdssitencd;
    }


    public void setZrnseihowebdssitencd(String pZrnseihowebdssitencd) {
        zrnseihowebdssitencd = pZrnseihowebdssitencd;
    }


    @Column(order = 182, length = 1)
    @NotNull
    private String zrnseihowebdsyokinkbn;


    public String getZrnseihowebdsyokinkbn() {
        return zrnseihowebdsyokinkbn;
    }


    public void setZrnseihowebdsyokinkbn(String pZrnseihowebdsyokinkbn) {
        zrnseihowebdsyokinkbn = pZrnseihowebdsyokinkbn;
    }


    @Column(order = 183, length = 12)
    @NotNull
    private String zrnseihowebdskouzano;


    public String getZrnseihowebdskouzano() {
        return zrnseihowebdskouzano;
    }


    public void setZrnseihowebdskouzano(String pZrnseihowebdskouzano) {
        zrnseihowebdskouzano = pZrnseihowebdskouzano;
    }


    @Column(order = 184, length = 24)
    @NotNull
    private String zrnseihowebdsansyono;


    public String getZrnseihowebdsansyono() {
        return zrnseihowebdsansyono;
    }


    public void setZrnseihowebdsansyono(String pZrnseihowebdsansyono) {
        zrnseihowebdsansyono = pZrnseihowebdsansyono;
    }


    @Column(order = 185, length = 1)
    @NotNull
    private String zrnseihowebdssymnttdkhyj;


    public String getZrnseihowebdssymnttdkhyj() {
        return zrnseihowebdssymnttdkhyj;
    }


    public void setZrnseihowebdssymnttdkhyj(String pZrnseihowebdssymnttdkhyj) {
        zrnseihowebdssymnttdkhyj = pZrnseihowebdssymnttdkhyj;
    }


    @Column(order = 186, length = 10)
    @NotNull
    private String zrnseihowebikkatupc;


    public String getZrnseihowebikkatupc() {
        return zrnseihowebikkatupc;
    }


    public void setZrnseihowebikkatupc(String pZrnseihowebikkatupc) {
        zrnseihowebikkatupc = pZrnseihowebikkatupc;
    }


    @Column(order = 187, length = 1)
    @NotNull
    private String zrnseihowebikkatubaraikbn;


    public String getZrnseihowebikkatubaraikbn() {
        return zrnseihowebikkatubaraikbn;
    }


    public void setZrnseihowebikkatubaraikbn(String pZrnseihowebikkatubaraikbn) {
        zrnseihowebikkatubaraikbn = pZrnseihowebikkatubaraikbn;
    }


    @Column(order = 188, length = 2)
    @NotNull
    private String zrnseihowebiktbrikaisuuc;


    public String getZrnseihowebiktbrikaisuuc() {
        return zrnseihowebiktbrikaisuuc;
    }


    public void setZrnseihowebiktbrikaisuuc(String pZrnseihowebiktbrikaisuuc) {
        zrnseihowebiktbrikaisuuc = pZrnseihowebiktbrikaisuuc;
    }


    @Column(order = 189, length = 10)
    @NotNull
    private String zrnseihowebzennoupc;


    public String getZrnseihowebzennoupc() {
        return zrnseihowebzennoupc;
    }


    public void setZrnseihowebzennoupc(String pZrnseihowebzennoupc) {
        zrnseihowebzennoupc = pZrnseihowebzennoupc;
    }


    @Column(order = 190, length = 13)
    @NotNull
    private String zrnseihowebgaikazennoupc;


    public String getZrnseihowebgaikazennoupc() {
        return zrnseihowebgaikazennoupc;
    }


    public void setZrnseihowebgaikazennoupc(String pZrnseihowebgaikazennoupc) {
        zrnseihowebgaikazennoupc = pZrnseihowebgaikazennoupc;
    }


    @Column(order = 191, length = 1)
    @NotNull
    private String zrnseihowebzennouhyj;


    public String getZrnseihowebzennouhyj() {
        return zrnseihowebzennouhyj;
    }


    public void setZrnseihowebzennouhyj(String pZrnseihowebzennouhyj) {
        zrnseihowebzennouhyj = pZrnseihowebzennouhyj;
    }


    @Column(order = 192, length = 1)
    @NotNull
    private String zrnseihowebyakkankbn;


    public String getZrnseihowebyakkankbn() {
        return zrnseihowebyakkankbn;
    }


    public void setZrnseihowebyakkankbn(String pZrnseihowebyakkankbn) {
        zrnseihowebyakkankbn = pZrnseihowebyakkankbn;
    }


    @Column(order = 193, length = 1)
    @NotNull
    private String zrnseihowebnetkhrzmhyj;


    public String getZrnseihowebnetkhrzmhyj() {
        return zrnseihowebnetkhrzmhyj;
    }


    public void setZrnseihowebnetkhrzmhyj(String pZrnseihowebnetkhrzmhyj) {
        zrnseihowebnetkhrzmhyj = pZrnseihowebnetkhrzmhyj;
    }


    @Column(order = 194, length = 1)
    @NotNull
    private String zrnseihowebkzktrkmoskbn;


    public String getZrnseihowebkzktrkmoskbn() {
        return zrnseihowebkzktrkmoskbn;
    }


    public void setZrnseihowebkzktrkmoskbn(String pZrnseihowebkzktrkmoskbn) {
        zrnseihowebkzktrkmoskbn = pZrnseihowebkzktrkmoskbn;
    }


    @Column(order = 195, length = 1)
    @NotNull
    private String zrnseihowebkzktdkkbn1;


    public String getZrnseihowebkzktdkkbn1() {
        return zrnseihowebkzktdkkbn1;
    }


    public void setZrnseihowebkzktdkkbn1(String pZrnseihowebkzktdkkbn1) {
        zrnseihowebkzktdkkbn1 = pZrnseihowebkzktdkkbn1;
    }


    @Column(order = 196, length = 18)
    @NotNull
    private String zrnseihowebkzkknnm1;


    public String getZrnseihowebkzkknnm1() {
        return zrnseihowebkzkknnm1;
    }


    public void setZrnseihowebkzkknnm1(String pZrnseihowebkzkknnm1) {
        zrnseihowebkzkknnm1 = pZrnseihowebkzkknnm1;
    }


    @Column(order = 197, length = 11)
    @MultiByte
    @NotNull
    private String zrnseihowebkzkkjnm1;


    public String getZrnseihowebkzkkjnm1() {
        return zrnseihowebkzkkjnm1;
    }


    @DataConvert("toMultiByte")
    public void setZrnseihowebkzkkjnm1(String pZrnseihowebkzkkjnm1) {
        zrnseihowebkzkkjnm1 = pZrnseihowebkzkkjnm1;
    }


    @Column(order = 198, length = 1)
    @NotNull
    private String zrnseihowebkzkseikbn1;


    public String getZrnseihowebkzkseikbn1() {
        return zrnseihowebkzkseikbn1;
    }


    public void setZrnseihowebkzkseikbn1(String pZrnseihowebkzkseikbn1) {
        zrnseihowebkzkseikbn1 = pZrnseihowebkzkseikbn1;
    }


    @Column(order = 199, length = 8)
    @NotNull
    private String zrnseihowebkzkseiymd1c;


    public String getZrnseihowebkzkseiymd1c() {
        return zrnseihowebkzkseiymd1c;
    }


    public void setZrnseihowebkzkseiymd1c(String pZrnseihowebkzkseiymd1c) {
        zrnseihowebkzkseiymd1c = pZrnseihowebkzkseiymd1c;
    }


    @Column(order = 200, length = 1)
    @NotNull
    private String zrnseihowebkzkkykdoukyohyj1;


    public String getZrnseihowebkzkkykdoukyohyj1() {
        return zrnseihowebkzkkykdoukyohyj1;
    }


    public void setZrnseihowebkzkkykdoukyohyj1(String pZrnseihowebkzkkykdoukyohyj1) {
        zrnseihowebkzkkykdoukyohyj1 = pZrnseihowebkzkkykdoukyohyj1;
    }


    @Column(order = 201, length = 8)
    @NotNull
    private String zrnseihowebkzkyno1;


    public String getZrnseihowebkzkyno1() {
        return zrnseihowebkzkyno1;
    }


    public void setZrnseihowebkzkyno1(String pZrnseihowebkzkyno1) {
        zrnseihowebkzkyno1 = pZrnseihowebkzkyno1;
    }


    @Column(order = 202, length = 62)
    @MultiByte
    @NotNull
    private String zrnseihowebkzkadr1;


    public String getZrnseihowebkzkadr1() {
        return zrnseihowebkzkadr1;
    }


    @DataConvert("toMultiByte")
    public void setZrnseihowebkzkadr1(String pZrnseihowebkzkadr1) {
        zrnseihowebkzkadr1 = pZrnseihowebkzkadr1;
    }


    @Column(order = 203, length = 14)
    @NotNull
    private String zrnseihowebkzktelno1;


    public String getZrnseihowebkzktelno1() {
        return zrnseihowebkzktelno1;
    }


    public void setZrnseihowebkzktelno1(String pZrnseihowebkzktelno1) {
        zrnseihowebkzktelno1 = pZrnseihowebkzktelno1;
    }


    @Column(order = 204, length = 1)
    @NotNull
    private String zrnseihowebkykdrtkkanouhyj;


    public String getZrnseihowebkykdrtkkanouhyj() {
        return zrnseihowebkykdrtkkanouhyj;
    }


    public void setZrnseihowebkykdrtkkanouhyj(String pZrnseihowebkykdrtkkanouhyj) {
        zrnseihowebkykdrtkkanouhyj = pZrnseihowebkykdrtkkanouhyj;
    }


    @Column(order = 205, length = 1)
    @NotNull
    private String zrnseihowebhhkndrtkkanouhyj;


    public String getZrnseihowebhhkndrtkkanouhyj() {
        return zrnseihowebhhkndrtkkanouhyj;
    }


    public void setZrnseihowebhhkndrtkkanouhyj(String pZrnseihowebhhkndrtkkanouhyj) {
        zrnseihowebhhkndrtkkanouhyj = pZrnseihowebhhkndrtkkanouhyj;
    }


    @Column(order = 206, length = 1)
    @NotNull
    private String zrnseihowebdrtkkbn;


    public String getZrnseihowebdrtkkbn() {
        return zrnseihowebdrtkkbn;
    }


    public void setZrnseihowebdrtkkbn(String pZrnseihowebdrtkkbn) {
        zrnseihowebdrtkkbn = pZrnseihowebdrtkkbn;
    }


    @Column(order = 207, length = 1)
    @NotNull
    private String zrnseihowebkykdrnrkkbn;


    public String getZrnseihowebkykdrnrkkbn() {
        return zrnseihowebkykdrnrkkbn;
    }


    public void setZrnseihowebkykdrnrkkbn(String pZrnseihowebkykdrnrkkbn) {
        zrnseihowebkykdrnrkkbn = pZrnseihowebkykdrnrkkbn;
    }


    @Column(order = 208, length = 1)
    @NotNull
    private String zrnseihowebhhkndrnrkkbn;


    public String getZrnseihowebhhkndrnrkkbn() {
        return zrnseihowebhhkndrnrkkbn;
    }


    public void setZrnseihowebhhkndrnrkkbn(String pZrnseihowebhhkndrnrkkbn) {
        zrnseihowebhhkndrnrkkbn = pZrnseihowebhhkndrnrkkbn;
    }


    @Column(order = 209, length = 1)
    @NotNull
    private String zrnseihowebhhkndrtdkkbn;


    public String getZrnseihowebhhkndrtdkkbn() {
        return zrnseihowebhhkndrtdkkbn;
    }


    public void setZrnseihowebhhkndrtdkkbn(String pZrnseihowebhhkndrtdkkbn) {
        zrnseihowebhhkndrtdkkbn = pZrnseihowebhhkndrtdkkbn;
    }


    @Column(order = 210, length = 18)
    @NotNull
    private String zrnseihowebhhkndrknnm;


    public String getZrnseihowebhhkndrknnm() {
        return zrnseihowebhhkndrknnm;
    }


    public void setZrnseihowebhhkndrknnm(String pZrnseihowebhhkndrknnm) {
        zrnseihowebhhkndrknnm = pZrnseihowebhhkndrknnm;
    }


    @Column(order = 211, length = 11)
    @MultiByte
    @NotNull
    private String zrnseihowebhhkndrkjnm;


    public String getZrnseihowebhhkndrkjnm() {
        return zrnseihowebhhkndrkjnm;
    }


    @DataConvert("toMultiByte")
    public void setZrnseihowebhhkndrkjnm(String pZrnseihowebhhkndrkjnm) {
        zrnseihowebhhkndrkjnm = pZrnseihowebhhkndrkjnm;
    }


    @Column(order = 212, length = 8)
    @NotNull
    private String zrnseihowebhhkndrseiymdc;


    public String getZrnseihowebhhkndrseiymdc() {
        return zrnseihowebhhkndrseiymdc;
    }


    public void setZrnseihowebhhkndrseiymdc(String pZrnseihowebhhkndrseiymdc) {
        zrnseihowebhhkndrseiymdc = pZrnseihowebhhkndrseiymdc;
    }


    @Column(order = 213, length = 1)
    @NotNull
    private String zrnseihowebdaihituarihyj;


    public String getZrnseihowebdaihituarihyj() {
        return zrnseihowebdaihituarihyj;
    }


    public void setZrnseihowebdaihituarihyj(String pZrnseihowebdaihituarihyj) {
        zrnseihowebdaihituarihyj = pZrnseihowebdaihituarihyj;
    }


    @Column(order = 214, length = 1)
    @NotNull
    private String zrnseihowebkoureisyakakkbn1;


    public String getZrnseihowebkoureisyakakkbn1() {
        return zrnseihowebkoureisyakakkbn1;
    }


    public void setZrnseihowebkoureisyakakkbn1(String pZrnseihowebkoureisyakakkbn1) {
        zrnseihowebkoureisyakakkbn1 = pZrnseihowebkoureisyakakkbn1;
    }


    @Column(order = 215, length = 1)
    @NotNull
    private String zrnseihowebkoureisyakakkbn2;


    public String getZrnseihowebkoureisyakakkbn2() {
        return zrnseihowebkoureisyakakkbn2;
    }


    public void setZrnseihowebkoureisyakakkbn2(String pZrnseihowebkoureisyakakkbn2) {
        zrnseihowebkoureisyakakkbn2 = pZrnseihowebkoureisyakakkbn2;
    }


    @Column(order = 216, length = 1)
    @NotNull
    private String zrnseihowebkoureisyakakkbn3;


    public String getZrnseihowebkoureisyakakkbn3() {
        return zrnseihowebkoureisyakakkbn3;
    }


    public void setZrnseihowebkoureisyakakkbn3(String pZrnseihowebkoureisyakakkbn3) {
        zrnseihowebkoureisyakakkbn3 = pZrnseihowebkoureisyakakkbn3;
    }


    @Column(order = 217, length = 1)
    @NotNull
    private String zrnseihowebptuutihyj;


    public String getZrnseihowebptuutihyj() {
        return zrnseihowebptuutihyj;
    }


    public void setZrnseihowebptuutihyj(String pZrnseihowebptuutihyj) {
        zrnseihowebptuutihyj = pZrnseihowebptuutihyj;
    }


    @Column(order = 218, length = 1546)
    @NotNull
    private String zrnyobiv1546;


    public String getZrnyobiv1546() {
        return zrnyobiv1546;
    }


    public void setZrnyobiv1546(String pZrnyobiv1546) {
        zrnyobiv1546 = pZrnyobiv1546;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
