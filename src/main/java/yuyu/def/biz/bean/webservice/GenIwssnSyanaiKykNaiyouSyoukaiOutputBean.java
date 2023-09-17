package yuyu.def.biz.bean.webservice;

import java.io.Serializable;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * （共通Web）社内用契約内容照会出力BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenIwssnSyanaiKykNaiyouSyoukaiOutputBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenIwssnSyanaiKykNaiyouSyoukaiOutputBean() {
    }

    @SyoukenNo
    private String iwssnSyono;

    public String getIwssnSyono() {
        return iwssnSyono;
    }

    public void setIwssnSyono(String pIwssnSyono) {
        iwssnSyono = pIwssnSyono;
    }

    private String iwssnKyknmkn;

    public String getIwssnKyknmkn() {
        return iwssnKyknmkn;
    }

    public void setIwssnKyknmkn(String pIwssnKyknmkn) {
        iwssnKyknmkn = pIwssnKyknmkn;
    }

    private String iwssnKyknmkj;

    public String getIwssnKyknmkj() {
        return iwssnKyknmkj;
    }

    public void setIwssnKyknmkj(String pIwssnKyknmkj) {
        iwssnKyknmkj = pIwssnKyknmkj;
    }

    private String iwssnKyksyaseiymd;

    public String getIwssnKyksyaseiymd() {
        return iwssnKyksyaseiymd;
    }

    public void setIwssnKyksyaseiymd(String pIwssnKyksyaseiymd) {
        iwssnKyksyaseiymd = pIwssnKyksyaseiymd;
    }

    private String iwssnKyksyanen;

    public String getIwssnKyksyanen() {
        return iwssnKyksyanen;
    }

    public void setIwssnKyksyanen(String pIwssnKyksyanen) {
        iwssnKyksyanen = pIwssnKyksyanen;
    }

    private String iwssnKyksyasei;

    public String getIwssnKyksyasei() {
        return iwssnKyksyasei;
    }

    public void setIwssnKyksyasei(String pIwssnKyksyasei) {
        iwssnKyksyasei = pIwssnKyksyasei;
    }

    private String iwssnKykseikj;

    public String getIwssnKykseikj() {
        return iwssnKykseikj;
    }

    public void setIwssnKykseikj(String pIwssnKykseikj) {
        iwssnKykseikj = pIwssnKykseikj;
    }

    private String iwssnKyktdk;

    public String getIwssnKyktdk() {
        return iwssnKyktdk;
    }

    public void setIwssnKyktdk(String pIwssnKyktdk) {
        iwssnKyktdk = pIwssnKyktdk;
    }

    private String iwssnKyktdkkj;

    public String getIwssnKyktdkkj() {
        return iwssnKyktdkkj;
    }

    public void setIwssnKyktdkkj(String pIwssnKyktdkkj) {
        iwssnKyktdkkj = pIwssnKyktdkkj;
    }

    private String iwssnHhknsyanmkn;

    public String getIwssnHhknsyanmkn() {
        return iwssnHhknsyanmkn;
    }

    public void setIwssnHhknsyanmkn(String pIwssnHhknsyanmkn) {
        iwssnHhknsyanmkn = pIwssnHhknsyanmkn;
    }

    private String iwssnHhknnmkj;

    public String getIwssnHhknnmkj() {
        return iwssnHhknnmkj;
    }

    public void setIwssnHhknnmkj(String pIwssnHhknnmkj) {
        iwssnHhknnmkj = pIwssnHhknnmkj;
    }

    private String iwssnHhknseiymd;

    public String getIwssnHhknseiymd() {
        return iwssnHhknseiymd;
    }

    public void setIwssnHhknseiymd(String pIwssnHhknseiymd) {
        iwssnHhknseiymd = pIwssnHhknseiymd;
    }

    private String iwssnHhknkyknen;

    public String getIwssnHhknkyknen() {
        return iwssnHhknkyknen;
    }

    public void setIwssnHhknkyknen(String pIwssnHhknkyknen) {
        iwssnHhknkyknen = pIwssnHhknkyknen;
    }

    private String iwssnHhknnen;

    public String getIwssnHhknnen() {
        return iwssnHhknnen;
    }

    public void setIwssnHhknnen(String pIwssnHhknnen) {
        iwssnHhknnen = pIwssnHhknnen;
    }

    private String iwssnHhknsei;

    public String getIwssnHhknsei() {
        return iwssnHhknsei;
    }

    public void setIwssnHhknsei(String pIwssnHhknsei) {
        iwssnHhknsei = pIwssnHhknsei;
    }

    private String iwssnHhknseikj;

    public String getIwssnHhknseikj() {
        return iwssnHhknseikj;
    }

    public void setIwssnHhknseikj(String pIwssnHhknseikj) {
        iwssnHhknseikj = pIwssnHhknseikj;
    }

    private String iwssnTsinyno;

    public String getIwssnTsinyno() {
        return iwssnTsinyno;
    }

    public void setIwssnTsinyno(String pIwssnTsinyno) {
        iwssnTsinyno = pIwssnTsinyno;
    }

    private String iwssnTsinadr1kj;

    public String getIwssnTsinadr1kj() {
        return iwssnTsinadr1kj;
    }

    public void setIwssnTsinadr1kj(String pIwssnTsinadr1kj) {
        iwssnTsinadr1kj = pIwssnTsinadr1kj;
    }

    private String iwssnTsinadr2kj;

    public String getIwssnTsinadr2kj() {
        return iwssnTsinadr2kj;
    }

    public void setIwssnTsinadr2kj(String pIwssnTsinadr2kj) {
        iwssnTsinadr2kj = pIwssnTsinadr2kj;
    }

    private String iwssnTsinadr3kj;

    public String getIwssnTsinadr3kj() {
        return iwssnTsinadr3kj;
    }

    public void setIwssnTsinadr3kj(String pIwssnTsinadr3kj) {
        iwssnTsinadr3kj = pIwssnTsinadr3kj;
    }

    private String iwssnTsintelno;

    public String getIwssnTsintelno() {
        return iwssnTsintelno;
    }

    public void setIwssnTsintelno(String pIwssnTsintelno) {
        iwssnTsintelno = pIwssnTsintelno;
    }

    private String iwssnSibouuktkbn;

    public String getIwssnSibouuktkbn() {
        return iwssnSibouuktkbn;
    }

    public void setIwssnSibouuktkbn(String pIwssnSibouuktkbn) {
        iwssnSibouuktkbn = pIwssnSibouuktkbn;
    }

    private String iwssnSibouuktkj;

    public String getIwssnSibouuktkj() {
        return iwssnSibouuktkj;
    }

    public void setIwssnSibouuktkj(String pIwssnSibouuktkj) {
        iwssnSibouuktkj = pIwssnSibouuktkj;
    }

    private String iwssnSibouhknknbunwari1;

    public String getIwssnSibouhknknbunwari1() {
        return iwssnSibouhknknbunwari1;
    }

    public void setIwssnSibouhknknbunwari1(String pIwssnSibouhknknbunwari1) {
        iwssnSibouhknknbunwari1 = pIwssnSibouhknknbunwari1;
    }

    private String iwssnSibouhknknbunwari2;

    public String getIwssnSibouhknknbunwari2() {
        return iwssnSibouhknknbunwari2;
    }

    public void setIwssnSibouhknknbunwari2(String pIwssnSibouhknknbunwari2) {
        iwssnSibouhknknbunwari2 = pIwssnSibouhknknbunwari2;
    }

    private String iwssnSibouhknknbunwari3;

    public String getIwssnSibouhknknbunwari3() {
        return iwssnSibouhknknbunwari3;
    }

    public void setIwssnSibouhknknbunwari3(String pIwssnSibouhknknbunwari3) {
        iwssnSibouhknknbunwari3 = pIwssnSibouhknknbunwari3;
    }

    private String iwssnSibouhknknbunwari4;

    public String getIwssnSibouhknknbunwari4() {
        return iwssnSibouhknknbunwari4;
    }

    public void setIwssnSibouhknknbunwari4(String pIwssnSibouhknknbunwari4) {
        iwssnSibouhknknbunwari4 = pIwssnSibouhknknbunwari4;
    }

    private String iwssnSibouhknknuktsmikana1;

    public String getIwssnSibouhknknuktsmikana1() {
        return iwssnSibouhknknuktsmikana1;
    }

    public void setIwssnSibouhknknuktsmikana1(String pIwssnSibouhknknuktsmikana1) {
        iwssnSibouhknknuktsmikana1 = pIwssnSibouhknknuktsmikana1;
    }

    private String iwssnSibouhknknuktsmikana2;

    public String getIwssnSibouhknknuktsmikana2() {
        return iwssnSibouhknknuktsmikana2;
    }

    public void setIwssnSibouhknknuktsmikana2(String pIwssnSibouhknknuktsmikana2) {
        iwssnSibouhknknuktsmikana2 = pIwssnSibouhknknuktsmikana2;
    }

    private String iwssnSibouhknknuktsmikana3;

    public String getIwssnSibouhknknuktsmikana3() {
        return iwssnSibouhknknuktsmikana3;
    }

    public void setIwssnSibouhknknuktsmikana3(String pIwssnSibouhknknuktsmikana3) {
        iwssnSibouhknknuktsmikana3 = pIwssnSibouhknknuktsmikana3;
    }

    private String iwssnSibouhknknuktsmikana4;

    public String getIwssnSibouhknknuktsmikana4() {
        return iwssnSibouhknknuktsmikana4;
    }

    public void setIwssnSibouhknknuktsmikana4(String pIwssnSibouhknknuktsmikana4) {
        iwssnSibouhknknuktsmikana4 = pIwssnSibouhknknuktsmikana4;
    }

    private String iwssnSibouhknknuktsmikanji1;

    public String getIwssnSibouhknknuktsmikanji1() {
        return iwssnSibouhknknuktsmikanji1;
    }

    public void setIwssnSibouhknknuktsmikanji1(String pIwssnSibouhknknuktsmikanji1) {
        iwssnSibouhknknuktsmikanji1 = pIwssnSibouhknknuktsmikanji1;
    }

    private String iwssnSibouhknknuktsmikanji2;

    public String getIwssnSibouhknknuktsmikanji2() {
        return iwssnSibouhknknuktsmikanji2;
    }

    public void setIwssnSibouhknknuktsmikanji2(String pIwssnSibouhknknuktsmikanji2) {
        iwssnSibouhknknuktsmikanji2 = pIwssnSibouhknknuktsmikanji2;
    }

    private String iwssnSibouhknknuktsmikanji3;

    public String getIwssnSibouhknknuktsmikanji3() {
        return iwssnSibouhknknuktsmikanji3;
    }

    public void setIwssnSibouhknknuktsmikanji3(String pIwssnSibouhknknuktsmikanji3) {
        iwssnSibouhknknuktsmikanji3 = pIwssnSibouhknknuktsmikanji3;
    }

    private String iwssnSibouhknknuktsmikanji4;

    public String getIwssnSibouhknknuktsmikanji4() {
        return iwssnSibouhknknuktsmikanji4;
    }

    public void setIwssnSibouhknknuktsmikanji4(String pIwssnSibouhknknuktsmikanji4) {
        iwssnSibouhknknuktsmikanji4 = pIwssnSibouhknknuktsmikanji4;
    }

    private String iwssnNenkinuktkbn;

    public String getIwssnNenkinuktkbn() {
        return iwssnNenkinuktkbn;
    }

    public void setIwssnNenkinuktkbn(String pIwssnNenkinuktkbn) {
        iwssnNenkinuktkbn = pIwssnNenkinuktkbn;
    }

    private String iwssnNenkinuktkj;

    public String getIwssnNenkinuktkj() {
        return iwssnNenkinuktkj;
    }

    public void setIwssnNenkinuktkj(String pIwssnNenkinuktkj) {
        iwssnNenkinuktkj = pIwssnNenkinuktkj;
    }

    private String iwssnStdrsknkbn;

    public String getIwssnStdrsknkbn() {
        return iwssnStdrsknkbn;
    }

    public void setIwssnStdrsknkbn(String pIwssnStdrsknkbn) {
        iwssnStdrsknkbn = pIwssnStdrsknkbn;
    }

    private String iwssnStdrsknkbnnm;

    public String getIwssnStdrsknkbnnm() {
        return iwssnStdrsknkbnnm;
    }

    public void setIwssnStdrsknkbnnm(String pIwssnStdrsknkbnnm) {
        iwssnStdrsknkbnnm = pIwssnStdrsknkbnnm;
    }

    private String iwssnStdrsknsmikanji;

    public String getIwssnStdrsknsmikanji() {
        return iwssnStdrsknsmikanji;
    }

    public void setIwssnStdrsknsmikanji(String pIwssnStdrsknsmikanji) {
        iwssnStdrsknsmikanji = pIwssnStdrsknsmikanji;
    }

    private String iwssnStdrskntkyhkkbn;

    public String getIwssnStdrskntkyhkkbn() {
        return iwssnStdrskntkyhkkbn;
    }

    public void setIwssnStdrskntkyhkkbn(String pIwssnStdrskntkyhkkbn) {
        iwssnStdrskntkyhkkbn = pIwssnStdrskntkyhkkbn;
    }

    private String iwssnStdrsknsmikana;

    public String getIwssnStdrsknsmikana() {
        return iwssnStdrsknsmikana;
    }

    public void setIwssnStdrsknsmikana(String pIwssnStdrsknsmikana) {
        iwssnStdrsknsmikana = pIwssnStdrsknsmikana;
    }

    private String iwssnSyouhncd;

    public String getIwssnSyouhncd() {
        return iwssnSyouhncd;
    }

    public void setIwssnSyouhncd(String pIwssnSyouhncd) {
        iwssnSyouhncd = pIwssnSyouhncd;
    }

    private String iwssnSyouhnnm;

    public String getIwssnSyouhnnm() {
        return iwssnSyouhnnm;
    }

    public void setIwssnSyouhnnm(String pIwssnSyouhnnm) {
        iwssnSyouhnnm = pIwssnSyouhnnm;
    }

    private String iwssnAisyoumeikj;

    public String getIwssnAisyoumeikj() {
        return iwssnAisyoumeikj;
    }

    public void setIwssnAisyoumeikj(String pIwssnAisyoumeikj) {
        iwssnAisyoumeikj = pIwssnAisyoumeikj;
    }

    private String iwssnAisyoumeikbn;

    public String getIwssnAisyoumeikbn() {
        return iwssnAisyoumeikbn;
    }

    public void setIwssnAisyoumeikbn(String pIwssnAisyoumeikbn) {
        iwssnAisyoumeikbn = pIwssnAisyoumeikbn;
    }

    private String iwssnSyoumetujiyuu;

    public String getIwssnSyoumetujiyuu() {
        return iwssnSyoumetujiyuu;
    }

    public void setIwssnSyoumetujiyuu(String pIwssnSyoumetujiyuu) {
        iwssnSyoumetujiyuu = pIwssnSyoumetujiyuu;
    }

    private String iwssnSyoumetujiyuukj;

    public String getIwssnSyoumetujiyuukj() {
        return iwssnSyoumetujiyuukj;
    }

    public void setIwssnSyoumetujiyuukj(String pIwssnSyoumetujiyuukj) {
        iwssnSyoumetujiyuukj = pIwssnSyoumetujiyuukj;
    }

    private String iwssnKykjyoutaikbn;

    public String getIwssnKykjyoutaikbn() {
        return iwssnKykjyoutaikbn;
    }

    public void setIwssnKykjyoutaikbn(String pIwssnKykjyoutaikbn) {
        iwssnKykjyoutaikbn = pIwssnKykjyoutaikbn;
    }

    private String iwssnKykjyoutaikbnnm;

    public String getIwssnKykjyoutaikbnnm() {
        return iwssnKykjyoutaikbnnm;
    }

    public void setIwssnKykjyoutaikbnnm(String pIwssnKykjyoutaikbnnm) {
        iwssnKykjyoutaikbnnm = pIwssnKykjyoutaikbnnm;
    }

    private String iwssnKykymd;

    public String getIwssnKykymd() {
        return iwssnKykymd;
    }

    public void setIwssnKykymd(String pIwssnKykymd) {
        iwssnKykymd = pIwssnKykymd;
    }

    private String iwssnSknnkaisiymd;

    public String getIwssnSknnkaisiymd() {
        return iwssnSknnkaisiymd;
    }

    public void setIwssnSknnkaisiymd(String pIwssnSknnkaisiymd) {
        iwssnSknnkaisiymd = pIwssnSknnkaisiymd;
    }

    private String iwssnBosyuuym;

    public String getIwssnBosyuuym() {
        return iwssnBosyuuym;
    }

    public void setIwssnBosyuuym(String pIwssnBosyuuym) {
        iwssnBosyuuym = pIwssnBosyuuym;
    }

    private String iwssnSyoumetuymd;

    public String getIwssnSyoumetuymd() {
        return iwssnSyoumetuymd;
    }

    public void setIwssnSyoumetuymd(String pIwssnSyoumetuymd) {
        iwssnSyoumetuymd = pIwssnSyoumetuymd;
    }

    private String iwssnHeijyunjkipjytym;

    public String getIwssnHeijyunjkipjytym() {
        return iwssnHeijyunjkipjytym;
    }

    public void setIwssnHeijyunjkipjytym(String pIwssnHeijyunjkipjytym) {
        iwssnHeijyunjkipjytym = pIwssnHeijyunjkipjytym;
    }

    private String iwssnNksyouhnnkshrstartymd;

    public String getIwssnNksyouhnnkshrstartymd() {
        return iwssnNksyouhnnkshrstartymd;
    }

    public void setIwssnNksyouhnnkshrstartymd(String pIwssnNksyouhnnkshrstartymd) {
        iwssnNksyouhnnkshrstartymd = pIwssnNksyouhnnkshrstartymd;
    }

    private String iwssnHeijyunanjoannaiym1;

    public String getIwssnHeijyunanjoannaiym1() {
        return iwssnHeijyunanjoannaiym1;
    }

    public void setIwssnHeijyunanjoannaiym1(String pIwssnHeijyunanjoannaiym1) {
        iwssnHeijyunanjoannaiym1 = pIwssnHeijyunanjoannaiym1;
    }

    private String iwssnHeijyunanjoannaiym2;

    public String getIwssnHeijyunanjoannaiym2() {
        return iwssnHeijyunanjoannaiym2;
    }

    public void setIwssnHeijyunanjoannaiym2(String pIwssnHeijyunanjoannaiym2) {
        iwssnHeijyunanjoannaiym2 = pIwssnHeijyunanjoannaiym2;
    }

    private String iwssnHeijyunanjoannaiym3;

    public String getIwssnHeijyunanjoannaiym3() {
        return iwssnHeijyunanjoannaiym3;
    }

    public void setIwssnHeijyunanjoannaiym3(String pIwssnHeijyunanjoannaiym3) {
        iwssnHeijyunanjoannaiym3 = pIwssnHeijyunanjoannaiym3;
    }

    private String iwssnHijynanjoannaijytym1;

    public String getIwssnHijynanjoannaijytym1() {
        return iwssnHijynanjoannaijytym1;
    }

    public void setIwssnHijynanjoannaijytym1(String pIwssnHijynanjoannaijytym1) {
        iwssnHijynanjoannaijytym1 = pIwssnHijynanjoannaijytym1;
    }

    private String iwssnHijynanjoannaijytym2;

    public String getIwssnHijynanjoannaijytym2() {
        return iwssnHijynanjoannaijytym2;
    }

    public void setIwssnHijynanjoannaijytym2(String pIwssnHijynanjoannaijytym2) {
        iwssnHijynanjoannaijytym2 = pIwssnHijynanjoannaijytym2;
    }

    private String iwssnHijynanjoannaijytym3;

    public String getIwssnHijynanjoannaijytym3() {
        return iwssnHijynanjoannaijytym3;
    }

    public void setIwssnHijynanjoannaijytym3(String pIwssnHijynanjoannaijytym3) {
        iwssnHijynanjoannaijytym3 = pIwssnHijynanjoannaijytym3;
    }

    private String iwssnHijynanjoannaijokbn1;

    public String getIwssnHijynanjoannaijokbn1() {
        return iwssnHijynanjoannaijokbn1;
    }

    public void setIwssnHijynanjoannaijokbn1(String pIwssnHijynanjoannaijokbn1) {
        iwssnHijynanjoannaijokbn1 = pIwssnHijynanjoannaijokbn1;
    }

    private String iwssnHijynanjoannaijokbn2;

    public String getIwssnHijynanjoannaijokbn2() {
        return iwssnHijynanjoannaijokbn2;
    }

    public void setIwssnHijynanjoannaijokbn2(String pIwssnHijynanjoannaijokbn2) {
        iwssnHijynanjoannaijokbn2 = pIwssnHijynanjoannaijokbn2;
    }

    private String iwssnHijynanjoannaijokbn3;

    public String getIwssnHijynanjoannaijokbn3() {
        return iwssnHijynanjoannaijokbn3;
    }

    public void setIwssnHijynanjoannaijokbn3(String pIwssnHijynanjoannaijokbn3) {
        iwssnHijynanjoannaijokbn3 = pIwssnHijynanjoannaijokbn3;
    }

    private String iwssnHijynanjoannaijokbnnm1;

    public String getIwssnHijynanjoannaijokbnnm1() {
        return iwssnHijynanjoannaijokbnnm1;
    }

    public void setIwssnHijynanjoannaijokbnnm1(String pIwssnHijynanjoannaijokbnnm1) {
        iwssnHijynanjoannaijokbnnm1 = pIwssnHijynanjoannaijokbnnm1;
    }

    private String iwssnHijynanjoannaijokbnnm2;

    public String getIwssnHijynanjoannaijokbnnm2() {
        return iwssnHijynanjoannaijokbnnm2;
    }

    public void setIwssnHijynanjoannaijokbnnm2(String pIwssnHijynanjoannaijokbnnm2) {
        iwssnHijynanjoannaijokbnnm2 = pIwssnHijynanjoannaijokbnnm2;
    }

    private String iwssnHijynanjoannaijokbnnm3;

    public String getIwssnHijynanjoannaijokbnnm3() {
        return iwssnHijynanjoannaijokbnnm3;
    }

    public void setIwssnHijynanjoannaijokbnnm3(String pIwssnHijynanjoannaijokbnnm3) {
        iwssnHijynanjoannaijokbnnm3 = pIwssnHijynanjoannaijokbnnm3;
    }

    private String iwssnHijynannaijytkaisuuy;

    public String getIwssnHijynannaijytkaisuuy() {
        return iwssnHijynannaijytkaisuuy;
    }

    public void setIwssnHijynannaijytkaisuuy(String pIwssnHijynannaijytkaisuuy) {
        iwssnHijynannaijytkaisuuy = pIwssnHijynannaijytkaisuuy;
    }

    private String iwssnHijynannaijytkaisuum;

    public String getIwssnHijynannaijytkaisuum() {
        return iwssnHijynannaijytkaisuum;
    }

    public void setIwssnHijynannaijytkaisuum(String pIwssnHijynannaijytkaisuum) {
        iwssnHijynannaijytkaisuum = pIwssnHijynannaijytkaisuum;
    }

    private String iwssnHeijyunannaigk;

    public String getIwssnHeijyunannaigk() {
        return iwssnHeijyunannaigk;
    }

    public void setIwssnHeijyunannaigk(String pIwssnHeijyunannaigk) {
        iwssnHeijyunannaigk = pIwssnHeijyunannaigk;
    }

    private String iwssnTeikiikkatubaraijkkbn;

    public String getIwssnTeikiikkatubaraijkkbn() {
        return iwssnTeikiikkatubaraijkkbn;
    }

    public void setIwssnTeikiikkatubaraijkkbn(String pIwssnTeikiikkatubaraijkkbn) {
        iwssnTeikiikkatubaraijkkbn = pIwssnTeikiikkatubaraijkkbn;
    }

    private String iwssnTikiktbrjkkbnnm;

    public String getIwssnTikiktbrjkkbnnm() {
        return iwssnTikiktbrjkkbnnm;
    }

    public void setIwssnTikiktbrjkkbnnm(String pIwssnTikiktbrjkkbnnm) {
        iwssnTikiktbrjkkbnnm = pIwssnTikiktbrjkkbnnm;
    }

    private String iwssnNksyouhnnenkinsyukbn;

    public String getIwssnNksyouhnnenkinsyukbn() {
        return iwssnNksyouhnnenkinsyukbn;
    }

    public void setIwssnNksyouhnnenkinsyukbn(String pIwssnNksyouhnnenkinsyukbn) {
        iwssnNksyouhnnenkinsyukbn = pIwssnNksyouhnnenkinsyukbn;
    }

    private String iwssnNksyouhnnenkinsyukj;

    public String getIwssnNksyouhnnenkinsyukj() {
        return iwssnNksyouhnnenkinsyukj;
    }

    public void setIwssnNksyouhnnenkinsyukj(String pIwssnNksyouhnnenkinsyukj) {
        iwssnNksyouhnnenkinsyukj = pIwssnNksyouhnnenkinsyukj;
    }

    private String iwssnKjnnkpzeitekitkhukakbn;

    public String getIwssnKjnnkpzeitekitkhukakbn() {
        return iwssnKjnnkpzeitekitkhukakbn;
    }

    public void setIwssnKjnnkpzeitekitkhukakbn(String pIwssnKjnnkpzeitekitkhukakbn) {
        iwssnKjnnkpzeitekitkhukakbn = pIwssnKjnnkpzeitekitkhukakbn;
    }

    private String iwssnPyenhrktkkbn;

    public String getIwssnPyenhrktkkbn() {
        return iwssnPyenhrktkkbn;
    }

    public void setIwssnPyenhrktkkbn(String pIwssnPyenhrktkkbn) {
        iwssnPyenhrktkkbn = pIwssnPyenhrktkkbn;
    }

    private String iwssnPstigihrktkkbn;

    public String getIwssnPstigihrktkkbn() {
        return iwssnPstigihrktkkbn;
    }

    public void setIwssnPstigihrktkkbn(String pIwssnPstigihrktkkbn) {
        iwssnPstigihrktkkbn = pIwssnPstigihrktkkbn;
    }

    private String iwssnMkhyouyensysnnktkkbn;

    public String getIwssnMkhyouyensysnnktkkbn() {
        return iwssnMkhyouyensysnnktkkbn;
    }

    public void setIwssnMkhyouyensysnnktkkbn(String pIwssnMkhyouyensysnnktkkbn) {
        iwssnMkhyouyensysnnktkkbn = pIwssnMkhyouyensysnnktkkbn;
    }

    private String iwssnMkhyouyensysnnktkwra;

    public String getIwssnMkhyouyensysnnktkwra() {
        return iwssnMkhyouyensysnnktkwra;
    }

    public void setIwssnMkhyouyensysnnktkwra(String pIwssnMkhyouyensysnnktkwra) {
        iwssnMkhyouyensysnnktkwra = pIwssnMkhyouyensysnnktkwra;
    }

    private String iwssnInitsbjiyensitihsykbn;

    public String getIwssnInitsbjiyensitihsykbn() {
        return iwssnInitsbjiyensitihsykbn;
    }

    public void setIwssnInitsbjiyensitihsykbn(String pIwssnInitsbjiyensitihsykbn) {
        iwssnInitsbjiyensitihsykbn = pIwssnInitsbjiyensitihsykbn;
    }

    private String iwssnHknkkn;

    public String getIwssnHknkkn() {
        return iwssnHknkkn;
    }

    public void setIwssnHknkkn(String pIwssnHknkkn) {
        iwssnHknkkn = pIwssnHknkkn;
    }

    private String iwssnHknkkn1from;

    public String getIwssnHknkkn1from() {
        return iwssnHknkkn1from;
    }

    public void setIwssnHknkkn1from(String pIwssnHknkkn1from) {
        iwssnHknkkn1from = pIwssnHknkkn1from;
    }

    private String iwssnHknkkn1to;

    public String getIwssnHknkkn1to() {
        return iwssnHknkkn1to;
    }

    public void setIwssnHknkkn1to(String pIwssnHknkkn1to) {
        iwssnHknkkn1to = pIwssnHknkkn1to;
    }

    private String iwssnHknkkn2from;

    public String getIwssnHknkkn2from() {
        return iwssnHknkkn2from;
    }

    public void setIwssnHknkkn2from(String pIwssnHknkkn2from) {
        iwssnHknkkn2from = pIwssnHknkkn2from;
    }

    private String iwssnHknkkn2to;

    public String getIwssnHknkkn2to() {
        return iwssnHknkkn2to;
    }

    public void setIwssnHknkkn2to(String pIwssnHknkkn2to) {
        iwssnHknkkn2to = pIwssnHknkkn2to;
    }

    private String iwssnHknkkn3;

    public String getIwssnHknkkn3() {
        return iwssnHknkkn3;
    }

    public void setIwssnHknkkn3(String pIwssnHknkkn3) {
        iwssnHknkkn3 = pIwssnHknkkn3;
    }

    private String iwssnHrkkkn;

    public String getIwssnHrkkkn() {
        return iwssnHrkkkn;
    }

    public void setIwssnHrkkkn(String pIwssnHrkkkn) {
        iwssnHrkkkn = pIwssnHrkkkn;
    }

    private String iwssnNksyouhnnenkinkkn;

    public String getIwssnNksyouhnnenkinkkn() {
        return iwssnNksyouhnnenkinkkn;
    }

    public void setIwssnNksyouhnnenkinkkn(String pIwssnNksyouhnnenkinkkn) {
        iwssnNksyouhnnenkinkkn = pIwssnNksyouhnnenkinkkn;
    }

    private String iwssnHrkkaisuukbn;

    public String getIwssnHrkkaisuukbn() {
        return iwssnHrkkaisuukbn;
    }

    public void setIwssnHrkkaisuukbn(String pIwssnHrkkaisuukbn) {
        iwssnHrkkaisuukbn = pIwssnHrkkaisuukbn;
    }

    private String iwssnHrkkaisuukbnnm;

    public String getIwssnHrkkaisuukbnnm() {
        return iwssnHrkkaisuukbnnm;
    }

    public void setIwssnHrkkaisuukbnnm(String pIwssnHrkkaisuukbnnm) {
        iwssnHrkkaisuukbnnm = pIwssnHrkkaisuukbnnm;
    }

    private String iwssnHrkkeirokbnnm;

    public String getIwssnHrkkeirokbnnm() {
        return iwssnHrkkeirokbnnm;
    }

    public void setIwssnHrkkeirokbnnm(String pIwssnHrkkeirokbnnm) {
        iwssnHrkkeirokbnnm = pIwssnHrkkeirokbnnm;
    }

    private String iwssnHrkkeirokbn;

    public String getIwssnHrkkeirokbn() {
        return iwssnHrkkeirokbn;
    }

    public void setIwssnHrkkeirokbn(String pIwssnHrkkeirokbn) {
        iwssnHrkkeirokbn = pIwssnHrkkeirokbn;
    }

    private String iwssnHrktuuka;

    public String getIwssnHrktuuka() {
        return iwssnHrktuuka;
    }

    public void setIwssnHrktuuka(String pIwssnHrktuuka) {
        iwssnHrktuuka = pIwssnHrktuuka;
    }

    private String iwssnYoteiriritu;

    public String getIwssnYoteiriritu() {
        return iwssnYoteiriritu;
    }

    public void setIwssnYoteiriritu(String pIwssnYoteiriritu) {
        iwssnYoteiriritu = pIwssnYoteiriritu;
    }

    private String iwssnSyokaipnyknrate;

    public String getIwssnSyokaipnyknrate() {
        return iwssnSyokaipnyknrate;
    }

    public void setIwssnSyokaipnyknrate(String pIwssnSyokaipnyknrate) {
        iwssnSyokaipnyknrate = pIwssnSyokaipnyknrate;
    }

    private String iwssnKykjisjkkktusirrt;

    public String getIwssnKykjisjkkktusirrt() {
        return iwssnKykjisjkkktusirrt;
    }

    public void setIwssnKykjisjkkktusirrt(String pIwssnKykjisjkkktusirrt) {
        iwssnKykjisjkkktusirrt = pIwssnKykjisjkkktusirrt;
    }

    private String iwssnSyokaijikkktusirrt;

    public String getIwssnSyokaijikkktusirrt() {
        return iwssnSyokaijikkktusirrt;
    }

    public void setIwssnSyokaijikkktusirrt(String pIwssnSyokaijikkktusirrt) {
        iwssnSyokaijikkktusirrt = pIwssnSyokaijikkktusirrt;
    }

    private String iwssnTumitateriritu;

    public String getIwssnTumitateriritu() {
        return iwssnTumitateriritu;
    }

    public void setIwssnTumitateriritu(String pIwssnTumitateriritu) {
        iwssnTumitateriritu = pIwssnTumitateriritu;
    }

    private String iwssnSetteibairitu;

    public String getIwssnSetteibairitu() {
        return iwssnSetteibairitu;
    }

    public void setIwssnSetteibairitu(String pIwssnSetteibairitu) {
        iwssnSetteibairitu = pIwssnSetteibairitu;
    }

    private String iwssnKykjiTmttknzkrtjygn;

    public String getIwssnKykjiTmttknzkrtjygn() {
        return iwssnKykjiTmttknzkrtjygn;
    }

    public void setIwssnKykjiTmttknzkrtjygn(String pIwssnKykjiTmttknzkrtjygn) {
        iwssnKykjiTmttknzkrtjygn = pIwssnKykjiTmttknzkrtjygn;
    }

    private String iwssnSisuuwari;

    public String getIwssnSisuuwari() {
        return iwssnSisuuwari;
    }

    public void setIwssnSisuuwari(String pIwssnSisuuwari) {
        iwssnSisuuwari = pIwssnSisuuwari;
    }

    private String iwssnTeirituwari;

    public String getIwssnTeirituwari() {
        return iwssnTeirituwari;
    }

    public void setIwssnTeirituwari(String pIwssnTeirituwari) {
        iwssnTeirituwari = pIwssnTeirituwari;
    }

    private String iwssnSiteituuka;

    public String getIwssnSiteituuka() {
        return iwssnSiteituuka;
    }

    public void setIwssnSiteituuka(String pIwssnSiteituuka) {
        iwssnSiteituuka = pIwssnSiteituuka;
    }

    private String iwssnItijibrpgaika;

    public String getIwssnItijibrpgaika() {
        return iwssnItijibrpgaika;
    }

    public void setIwssnItijibrpgaika(String pIwssnItijibrpgaika) {
        iwssnItijibrpgaika = pIwssnItijibrpgaika;
    }

    private String iwssnItijibrpyen;

    public String getIwssnItijibrpyen() {
        return iwssnItijibrpyen;
    }

    public void setIwssnItijibrpyen(String pIwssnItijibrpyen) {
        iwssnItijibrpyen = pIwssnItijibrpyen;
    }

    private String iwssnHrkp;

    public String getIwssnHrkp() {
        return iwssnHrkp;
    }

    public void setIwssnHrkp(String pIwssnHrkp) {
        iwssnHrkp = pIwssnHrkp;
    }

    private String iwssnKihonhokenkngk;

    public String getIwssnKihonhokenkngk() {
        return iwssnKihonhokenkngk;
    }

    public void setIwssnKihonhokenkngk(String pIwssnKihonhokenkngk) {
        iwssnKihonhokenkngk = pIwssnKihonhokenkngk;
    }

    private String iwssnGenzaisbhknkngaku;

    public String getIwssnGenzaisbhknkngaku() {
        return iwssnGenzaisbhknkngaku;
    }

    public void setIwssnGenzaisbhknkngaku(String pIwssnGenzaisbhknkngaku) {
        iwssnGenzaisbhknkngaku = pIwssnGenzaisbhknkngaku;
    }

    private String iwssnKijyunkingakuyen;

    public String getIwssnKijyunkingakuyen() {
        return iwssnKijyunkingakuyen;
    }

    public void setIwssnKijyunkingakuyen(String pIwssnKijyunkingakuyen) {
        iwssnKijyunkingakuyen = pIwssnKijyunkingakuyen;
    }

    private String iwssnKijyunkingakugaika;

    public String getIwssnKijyunkingakugaika() {
        return iwssnKijyunkingakugaika;
    }

    public void setIwssnKijyunkingakugaika(String pIwssnKijyunkingakugaika) {
        iwssnKijyunkingakugaika = pIwssnKijyunkingakugaika;
    }

    private String iwssnMkhyouyensysnnktkjnkg;

    public String getIwssnMkhyouyensysnnktkjnkg() {
        return iwssnMkhyouyensysnnktkjnkg;
    }

    public void setIwssnMkhyouyensysnnktkjnkg(String pIwssnMkhyouyensysnnktkjnkg) {
        iwssnMkhyouyensysnnktkjnkg = pIwssnMkhyouyensysnnktkjnkg;
    }

    private String iwssnInitsbjyensitihsykjnkg;

    public String getIwssnInitsbjyensitihsykjnkg() {
        return iwssnInitsbjyensitihsykjnkg;
    }

    public void setIwssnInitsbjyensitihsykjnkg(String pIwssnInitsbjyensitihsykjnkg) {
        iwssnInitsbjyensitihsykjnkg = pIwssnInitsbjyensitihsykjnkg;
    }

    private String iwssnJyudkaigomeharaitkkbn;

    public String getIwssnJyudkaigomeharaitkkbn() {
        return iwssnJyudkaigomeharaitkkbn;
    }

    public void setIwssnJyudkaigomeharaitkkbn(String pIwssnJyudkaigomeharaitkkbn) {
        iwssnJyudkaigomeharaitkkbn = pIwssnJyudkaigomeharaitkkbn;
    }

    private String iwssnKaiyakuhrgaika;

    public String getIwssnKaiyakuhrgaika() {
        return iwssnKaiyakuhrgaika;
    }

    public void setIwssnKaiyakuhrgaika(String pIwssnKaiyakuhrgaika) {
        iwssnKaiyakuhrgaika = pIwssnKaiyakuhrgaika;
    }

    private String iwssnKaiyakuhryen;

    public String getIwssnKaiyakuhryen() {
        return iwssnKaiyakuhryen;
    }

    public void setIwssnKaiyakuhryen(String pIwssnKaiyakuhryen) {
        iwssnKaiyakuhryen = pIwssnKaiyakuhryen;
    }

    private String iwssnShrgkkeigaika;

    public String getIwssnShrgkkeigaika() {
        return iwssnShrgkkeigaika;
    }

    public void setIwssnShrgkkeigaika(String pIwssnShrgkkeigaika) {
        iwssnShrgkkeigaika = pIwssnShrgkkeigaika;
    }

    private String iwssnShrgkkeiyen;

    public String getIwssnShrgkkeiyen() {
        return iwssnShrgkkeiyen;
    }

    public void setIwssnShrgkkeiyen(String pIwssnShrgkkeiyen) {
        iwssnShrgkkeiyen = pIwssnShrgkkeiyen;
    }

    private String iwssnPtumitatekin;

    public String getIwssnPtumitatekin() {
        return iwssnPtumitatekin;
    }

    public void setIwssnPtumitatekin(String pIwssnPtumitatekin) {
        iwssnPtumitatekin = pIwssnPtumitatekin;
    }

    private String iwssnSiboushryymd;

    public String getIwssnSiboushryymd() {
        return iwssnSiboushryymd;
    }

    public void setIwssnSiboushryymd(String pIwssnSiboushryymd) {
        iwssnSiboushryymd = pIwssnSiboushryymd;
    }

    private String iwssnZennouseisankin;

    public String getIwssnZennouseisankin() {
        return iwssnZennouseisankin;
    }

    public void setIwssnZennouseisankin(String pIwssnZennouseisankin) {
        iwssnZennouseisankin = pIwssnZennouseisankin;
    }

    private String iwssnShrkwsrate;

    public String getIwssnShrkwsrate() {
        return iwssnShrkwsrate;
    }

    public void setIwssnShrkwsrate(String pIwssnShrkwsrate) {
        iwssnShrkwsrate = pIwssnShrkwsrate;
    }

    private String iwssnKwsratesyutokuymd;

    public String getIwssnKwsratesyutokuymd() {
        return iwssnKwsratesyutokuymd;
    }

    public void setIwssnKwsratesyutokuymd(String pIwssnKwsratesyutokuymd) {
        iwssnKwsratesyutokuymd = pIwssnKwsratesyutokuymd;
    }

    private String iwssnDairitencd1;

    public String getIwssnDairitencd1() {
        return iwssnDairitencd1;
    }

    public void setIwssnDairitencd1(String pIwssnDairitencd1) {
        iwssnDairitencd1 = pIwssnDairitencd1;
    }

    private String iwssnDairitencd2;

    public String getIwssnDairitencd2() {
        return iwssnDairitencd2;
    }

    public void setIwssnDairitencd2(String pIwssnDairitencd2) {
        iwssnDairitencd2 = pIwssnDairitencd2;
    }

    private String iwssnDairitenm1;

    public String getIwssnDairitenm1() {
        return iwssnDairitenm1;
    }

    public void setIwssnDairitenm1(String pIwssnDairitenm1) {
        iwssnDairitenm1 = pIwssnDairitenm1;
    }

    private String iwssnDairitenm2;

    public String getIwssnDairitenm2() {
        return iwssnDairitenm2;
    }

    public void setIwssnDairitenm2(String pIwssnDairitenm2) {
        iwssnDairitenm2 = pIwssnDairitenm2;
    }

    private String iwssnDaibosyuucd1;

    public String getIwssnDaibosyuucd1() {
        return iwssnDaibosyuucd1;
    }

    public void setIwssnDaibosyuucd1(String pIwssnDaibosyuucd1) {
        iwssnDaibosyuucd1 = pIwssnDaibosyuucd1;
    }

    private String iwssnDaibosyuucd2;

    public String getIwssnDaibosyuucd2() {
        return iwssnDaibosyuucd2;
    }

    public void setIwssnDaibosyuucd2(String pIwssnDaibosyuucd2) {
        iwssnDaibosyuucd2 = pIwssnDaibosyuucd2;
    }

    private String iwssnBosyuunin1;

    public String getIwssnBosyuunin1() {
        return iwssnBosyuunin1;
    }

    public void setIwssnBosyuunin1(String pIwssnBosyuunin1) {
        iwssnBosyuunin1 = pIwssnBosyuunin1;
    }

    private String iwssnBosyuunin2;

    public String getIwssnBosyuunin2() {
        return iwssnBosyuunin2;
    }

    public void setIwssnBosyuunin2(String pIwssnBosyuunin2) {
        iwssnBosyuunin2 = pIwssnBosyuunin2;
    }

    private String iwssnTtdktyuuikbn1;

    public String getIwssnTtdktyuuikbn1() {
        return iwssnTtdktyuuikbn1;
    }

    public void setIwssnTtdktyuuikbn1(String pIwssnTtdktyuuikbn1) {
        iwssnTtdktyuuikbn1 = pIwssnTtdktyuuikbn1;
    }

    private String iwssnTtdktyuuikbn2;

    public String getIwssnTtdktyuuikbn2() {
        return iwssnTtdktyuuikbn2;
    }

    public void setIwssnTtdktyuuikbn2(String pIwssnTtdktyuuikbn2) {
        iwssnTtdktyuuikbn2 = pIwssnTtdktyuuikbn2;
    }

    private String iwssnTtdktyuuikbn3;

    public String getIwssnTtdktyuuikbn3() {
        return iwssnTtdktyuuikbn3;
    }

    public void setIwssnTtdktyuuikbn3(String pIwssnTtdktyuuikbn3) {
        iwssnTtdktyuuikbn3 = pIwssnTtdktyuuikbn3;
    }

    private String iwssnTtdktyuuikbn4;

    public String getIwssnTtdktyuuikbn4() {
        return iwssnTtdktyuuikbn4;
    }

    public void setIwssnTtdktyuuikbn4(String pIwssnTtdktyuuikbn4) {
        iwssnTtdktyuuikbn4 = pIwssnTtdktyuuikbn4;
    }

    private String iwssnTtdktyuuikbn5;

    public String getIwssnTtdktyuuikbn5() {
        return iwssnTtdktyuuikbn5;
    }

    public void setIwssnTtdktyuuikbn5(String pIwssnTtdktyuuikbn5) {
        iwssnTtdktyuuikbn5 = pIwssnTtdktyuuikbn5;
    }

    private String iwssnTtdktyuuikbnkj1;

    public String getIwssnTtdktyuuikbnkj1() {
        return iwssnTtdktyuuikbnkj1;
    }

    public void setIwssnTtdktyuuikbnkj1(String pIwssnTtdktyuuikbnkj1) {
        iwssnTtdktyuuikbnkj1 = pIwssnTtdktyuuikbnkj1;
    }

    private String iwssnTtdktyuuikbnkj2;

    public String getIwssnTtdktyuuikbnkj2() {
        return iwssnTtdktyuuikbnkj2;
    }

    public void setIwssnTtdktyuuikbnkj2(String pIwssnTtdktyuuikbnkj2) {
        iwssnTtdktyuuikbnkj2 = pIwssnTtdktyuuikbnkj2;
    }

    private String iwssnTtdktyuuikbnkj3;

    public String getIwssnTtdktyuuikbnkj3() {
        return iwssnTtdktyuuikbnkj3;
    }

    public void setIwssnTtdktyuuikbnkj3(String pIwssnTtdktyuuikbnkj3) {
        iwssnTtdktyuuikbnkj3 = pIwssnTtdktyuuikbnkj3;
    }

    private String iwssnTtdktyuuikbnkj4;

    public String getIwssnTtdktyuuikbnkj4() {
        return iwssnTtdktyuuikbnkj4;
    }

    public void setIwssnTtdktyuuikbnkj4(String pIwssnTtdktyuuikbnkj4) {
        iwssnTtdktyuuikbnkj4 = pIwssnTtdktyuuikbnkj4;
    }

    private String iwssnTtdktyuuikbnkj5;

    public String getIwssnTtdktyuuikbnkj5() {
        return iwssnTtdktyuuikbnkj5;
    }

    public void setIwssnTtdktyuuikbnkj5(String pIwssnTtdktyuuikbnkj5) {
        iwssnTtdktyuuikbnkj5 = pIwssnTtdktyuuikbnkj5;
    }

    private String iwssnTtdktyuuisetymd1;

    public String getIwssnTtdktyuuisetymd1() {
        return iwssnTtdktyuuisetymd1;
    }

    public void setIwssnTtdktyuuisetymd1(String pIwssnTtdktyuuisetymd1) {
        iwssnTtdktyuuisetymd1 = pIwssnTtdktyuuisetymd1;
    }

    private String iwssnTtdktyuuisetymd2;

    public String getIwssnTtdktyuuisetymd2() {
        return iwssnTtdktyuuisetymd2;
    }

    public void setIwssnTtdktyuuisetymd2(String pIwssnTtdktyuuisetymd2) {
        iwssnTtdktyuuisetymd2 = pIwssnTtdktyuuisetymd2;
    }

    private String iwssnTtdktyuuisetymd3;

    public String getIwssnTtdktyuuisetymd3() {
        return iwssnTtdktyuuisetymd3;
    }

    public void setIwssnTtdktyuuisetymd3(String pIwssnTtdktyuuisetymd3) {
        iwssnTtdktyuuisetymd3 = pIwssnTtdktyuuisetymd3;
    }

    private String iwssnTtdktyuuisetymd4;

    public String getIwssnTtdktyuuisetymd4() {
        return iwssnTtdktyuuisetymd4;
    }

    public void setIwssnTtdktyuuisetymd4(String pIwssnTtdktyuuisetymd4) {
        iwssnTtdktyuuisetymd4 = pIwssnTtdktyuuisetymd4;
    }

    private String iwssnTtdktyuuisetymd5;

    public String getIwssnTtdktyuuisetymd5() {
        return iwssnTtdktyuuisetymd5;
    }

    public void setIwssnTtdktyuuisetymd5(String pIwssnTtdktyuuisetymd5) {
        iwssnTtdktyuuisetymd5 = pIwssnTtdktyuuisetymd5;
    }

    private String iwssnTtdktyuuinaiyo1;

    public String getIwssnTtdktyuuinaiyo1() {
        return iwssnTtdktyuuinaiyo1;
    }

    public void setIwssnTtdktyuuinaiyo1(String pIwssnTtdktyuuinaiyo1) {
        iwssnTtdktyuuinaiyo1 = pIwssnTtdktyuuinaiyo1;
    }

    private String iwssnTtdktyuuinaiyo2;

    public String getIwssnTtdktyuuinaiyo2() {
        return iwssnTtdktyuuinaiyo2;
    }

    public void setIwssnTtdktyuuinaiyo2(String pIwssnTtdktyuuinaiyo2) {
        iwssnTtdktyuuinaiyo2 = pIwssnTtdktyuuinaiyo2;
    }

    private String iwssnTtdktyuuinaiyo3;

    public String getIwssnTtdktyuuinaiyo3() {
        return iwssnTtdktyuuinaiyo3;
    }

    public void setIwssnTtdktyuuinaiyo3(String pIwssnTtdktyuuinaiyo3) {
        iwssnTtdktyuuinaiyo3 = pIwssnTtdktyuuinaiyo3;
    }

    private String iwssnTtdktyuuinaiyo4;

    public String getIwssnTtdktyuuinaiyo4() {
        return iwssnTtdktyuuinaiyo4;
    }

    public void setIwssnTtdktyuuinaiyo4(String pIwssnTtdktyuuinaiyo4) {
        iwssnTtdktyuuinaiyo4 = pIwssnTtdktyuuinaiyo4;
    }

    private String iwssnTtdktyuuinaiyo5;

    public String getIwssnTtdktyuuinaiyo5() {
        return iwssnTtdktyuuinaiyo5;
    }

    public void setIwssnTtdktyuuinaiyo5(String pIwssnTtdktyuuinaiyo5) {
        iwssnTtdktyuuinaiyo5 = pIwssnTtdktyuuinaiyo5;
    }

    private String iwssnDattairiyuukbn;

    public String getIwssnDattairiyuukbn() {
        return iwssnDattairiyuukbn;
    }

    public void setIwssnDattairiyuukbn(String pIwssnDattairiyuukbn) {
        iwssnDattairiyuukbn = pIwssnDattairiyuukbn;
    }

    private String iwssnDattairiyuukbnnm;

    public String getIwssnDattairiyuukbnnm() {
        return iwssnDattairiyuukbnnm;
    }

    public void setIwssnDattairiyuukbnnm(String pIwssnDattairiyuukbnnm) {
        iwssnDattairiyuukbnnm = pIwssnDattairiyuukbnnm;
    }

    private String iwssnDsokyksmno;

    public String getIwssnDsokyksmno() {
        return iwssnDsokyksmno;
    }

    public void setIwssnDsokyksmno(String pIwssnDsokyksmno) {
        iwssnDsokyksmno = pIwssnDsokyksmno;
    }

    private String iwssnDsmailaddress;

    public String getIwssnDsmailaddress() {
        return iwssnDsmailaddress;
    }

    public void setIwssnDsmailaddress(String pIwssnDsmailaddress) {
        iwssnDsmailaddress = pIwssnDsmailaddress;
    }

    private String iwssnDskokyakujtkbn;

    public String getIwssnDskokyakujtkbn() {
        return iwssnDskokyakujtkbn;
    }

    public void setIwssnDskokyakujtkbn(String pIwssnDskokyakujtkbn) {
        iwssnDskokyakujtkbn = pIwssnDskokyakujtkbn;
    }

    private String iwssnDskokyakujtkbnnm;

    public String getIwssnDskokyakujtkbnnm() {
        return iwssnDskokyakujtkbnnm;
    }

    public void setIwssnDskokyakujtkbnnm(String pIwssnDskokyakujtkbnnm) {
        iwssnDskokyakujtkbnnm = pIwssnDskokyakujtkbnnm;
    }

    private String iwssnKaripasswordhkymd;

    public String getIwssnKaripasswordhkymd() {
        return iwssnKaripasswordhkymd;
    }

    public void setIwssnKaripasswordhkymd(String pIwssnKaripasswordhkymd) {
        iwssnKaripasswordhkymd = pIwssnKaripasswordhkymd;
    }

    private String iwssnTelttdkkahikbn;

    public String getIwssnTelttdkkahikbn() {
        return iwssnTelttdkkahikbn;
    }

    public void setIwssnTelttdkkahikbn(String pIwssnTelttdkkahikbn) {
        iwssnTelttdkkahikbn = pIwssnTelttdkkahikbn;
    }

    private String iwssnTelttdkahikbnnm;

    public String getIwssnTelttdkahikbnnm() {
        return iwssnTelttdkahikbnnm;
    }

    public void setIwssnTelttdkahikbnnm(String pIwssnTelttdkahikbnnm) {
        iwssnTelttdkahikbnnm = pIwssnTelttdkahikbnnm;
    }

    private String iwssnTelttdkhukariyuukbn;

    public String getIwssnTelttdkhukariyuukbn() {
        return iwssnTelttdkhukariyuukbn;
    }

    public void setIwssnTelttdkhukariyuukbn(String pIwssnTelttdkhukariyuukbn) {
        iwssnTelttdkhukariyuukbn = pIwssnTelttdkhukariyuukbn;
    }

    private String iwssnTelttdkhukariyuukbnnm;

    public String getIwssnTelttdkhukariyuukbnnm() {
        return iwssnTelttdkhukariyuukbnnm;
    }

    public void setIwssnTelttdkhukariyuukbnnm(String pIwssnTelttdkhukariyuukbnnm) {
        iwssnTelttdkhukariyuukbnnm = pIwssnTelttdkhukariyuukbnnm;
    }

    private String iwssnDskouzano;

    public String getIwssnDskouzano() {
        return iwssnDskouzano;
    }

    public void setIwssnDskouzano(String pIwssnDskouzano) {
        iwssnDskouzano = pIwssnDskouzano;
    }

    private String iwssnDskzmeigii;

    public String getIwssnDskzmeigii() {
        return iwssnDskzmeigii;
    }

    public void setIwssnDskzmeigii(String pIwssnDskzmeigii) {
        iwssnDskzmeigii = pIwssnDskzmeigii;
    }

    private String iwssnDskinyunm;

    public String getIwssnDskinyunm() {
        return iwssnDskinyunm;
    }

    public void setIwssnDskinyunm(String pIwssnDskinyunm) {
        iwssnDskinyunm = pIwssnDskinyunm;
    }

    private String iwssnSitennm;

    public String getIwssnSitennm() {
        return iwssnSitennm;
    }

    public void setIwssnSitennm(String pIwssnSitennm) {
        iwssnSitennm = pIwssnSitennm;
    }

    private String iwssnDsyokinkbnnm;

    public String getIwssnDsyokinkbnnm() {
        return iwssnDsyokinkbnnm;
    }

    public void setIwssnDsyokinkbnnm(String pIwssnDsyokinkbnnm) {
        iwssnDsyokinkbnnm = pIwssnDsyokinkbnnm;
    }

    private String iwssnDskzsyuruikbn;

    public String getIwssnDskzsyuruikbn() {
        return iwssnDskzsyuruikbn;
    }

    public void setIwssnDskzsyuruikbn(String pIwssnDskzsyuruikbn) {
        iwssnDskzsyuruikbn = pIwssnDskzsyuruikbn;
    }

    private String iwssnDskzsyuruikbnnm;

    public String getIwssnDskzsyuruikbnnm() {
        return iwssnDskzsyuruikbnnm;
    }

    public void setIwssnDskzsyuruikbnnm(String pIwssnDskzsyuruikbnnm) {
        iwssnDskzsyuruikbnnm = pIwssnDskzsyuruikbnnm;
    }

    private String iwssnDsbankcd;

    public String getIwssnDsbankcd() {
        return iwssnDsbankcd;
    }

    public void setIwssnDsbankcd(String pIwssnDsbankcd) {
        iwssnDsbankcd = pIwssnDsbankcd;
    }

    private String iwssnDssitencd;

    public String getIwssnDssitencd() {
        return iwssnDssitencd;
    }

    public void setIwssnDssitencd(String pIwssnDssitencd) {
        iwssnDssitencd = pIwssnDssitencd;
    }

    private String iwssnDsyokinkbn;

    public String getIwssnDsyokinkbn() {
        return iwssnDsyokinkbn;
    }

    public void setIwssnDsyokinkbn(String pIwssnDsyokinkbn) {
        iwssnDsyokinkbn = pIwssnDsyokinkbn;
    }

    private String iwssnDskzdoukbn;

    public String getIwssnDskzdoukbn() {
        return iwssnDskzdoukbn;
    }

    public void setIwssnDskzdoukbn(String pIwssnDskzdoukbn) {
        iwssnDskzdoukbn = pIwssnDskzdoukbn;
    }

    private String iwssnDskzdoukbnnm;

    public String getIwssnDskzdoukbnnm() {
        return iwssnDskzdoukbnnm;
    }

    public void setIwssnDskzdoukbnnm(String pIwssnDskzdoukbnnm) {
        iwssnDskzdoukbnnm = pIwssnDskzdoukbnnm;
    }

    private String iwssnSyorikekkakbn;

    public String getIwssnSyorikekkakbn() {
        return iwssnSyorikekkakbn;
    }

    public void setIwssnSyorikekkakbn(String pIwssnSyorikekkakbn) {
        iwssnSyorikekkakbn = pIwssnSyorikekkakbn;
    }

    private String iwssnSyorikekkakbnnm;

    public String getIwssnSyorikekkakbnnm() {
        return iwssnSyorikekkakbnnm;
    }

    public void setIwssnSyorikekkakbnnm(String pIwssnSyorikekkakbnnm) {
        iwssnSyorikekkakbnnm = pIwssnSyorikekkakbnnm;
    }

    private String iwssnYfrjkouzano;

    public String getIwssnYfrjkouzano() {
        return iwssnYfrjkouzano;
    }

    public void setIwssnYfrjkouzano(String pIwssnYfrjkouzano) {
        iwssnYfrjkouzano = pIwssnYfrjkouzano;
    }

    private String iwssnYfrjkzmeigikn;

    public String getIwssnYfrjkzmeigikn() {
        return iwssnYfrjkzmeigikn;
    }

    public void setIwssnYfrjkzmeigikn(String pIwssnYfrjkzmeigikn) {
        iwssnYfrjkzmeigikn = pIwssnYfrjkzmeigikn;
    }

    private String iwssnYfrjbanknm;

    public String getIwssnYfrjbanknm() {
        return iwssnYfrjbanknm;
    }

    public void setIwssnYfrjbanknm(String pIwssnYfrjbanknm) {
        iwssnYfrjbanknm = pIwssnYfrjbanknm;
    }

    private String iwssnYfrjsitennm;

    public String getIwssnYfrjsitennm() {
        return iwssnYfrjsitennm;
    }

    public void setIwssnYfrjsitennm(String pIwssnYfrjsitennm) {
        iwssnYfrjsitennm = pIwssnYfrjsitennm;
    }

    private String iwssnYfrjyokinkbnnm;

    public String getIwssnYfrjyokinkbnnm() {
        return iwssnYfrjyokinkbnnm;
    }

    public void setIwssnYfrjyokinkbnnm(String pIwssnYfrjyokinkbnnm) {
        iwssnYfrjyokinkbnnm = pIwssnYfrjyokinkbnnm;
    }

    private String iwssnYfrjbankcd;

    public String getIwssnYfrjbankcd() {
        return iwssnYfrjbankcd;
    }

    public void setIwssnYfrjbankcd(String pIwssnYfrjbankcd) {
        iwssnYfrjbankcd = pIwssnYfrjbankcd;
    }

    private String iwssnYfrjsitencd;

    public String getIwssnYfrjsitencd() {
        return iwssnYfrjsitencd;
    }

    public void setIwssnYfrjsitencd(String pIwssnYfrjsitencd) {
        iwssnYfrjsitencd = pIwssnYfrjsitencd;
    }

    private String iwssnYfrjyokinkbn;

    public String getIwssnYfrjyokinkbn() {
        return iwssnYfrjyokinkbn;
    }

    public void setIwssnYfrjyokinkbn(String pIwssnYfrjyokinkbn) {
        iwssnYfrjyokinkbn = pIwssnYfrjyokinkbn;
    }

    private String iwssnTtdkrrksyoriymd1;

    public String getIwssnTtdkrrksyoriymd1() {
        return iwssnTtdkrrksyoriymd1;
    }

    public void setIwssnTtdkrrksyoriymd1(String pIwssnTtdkrrksyoriymd1) {
        iwssnTtdkrrksyoriymd1 = pIwssnTtdkrrksyoriymd1;
    }

    private String iwssnTtdkrrksyoriymd2;

    public String getIwssnTtdkrrksyoriymd2() {
        return iwssnTtdkrrksyoriymd2;
    }

    public void setIwssnTtdkrrksyoriymd2(String pIwssnTtdkrrksyoriymd2) {
        iwssnTtdkrrksyoriymd2 = pIwssnTtdkrrksyoriymd2;
    }

    private String iwssnTtdkrrksyoriymd3;

    public String getIwssnTtdkrrksyoriymd3() {
        return iwssnTtdkrrksyoriymd3;
    }

    public void setIwssnTtdkrrksyoriymd3(String pIwssnTtdkrrksyoriymd3) {
        iwssnTtdkrrksyoriymd3 = pIwssnTtdkrrksyoriymd3;
    }

    private String iwssnTtdkrrksyorinaiyou1;

    public String getIwssnTtdkrrksyorinaiyou1() {
        return iwssnTtdkrrksyorinaiyou1;
    }

    public void setIwssnTtdkrrksyorinaiyou1(String pIwssnTtdkrrksyorinaiyou1) {
        iwssnTtdkrrksyorinaiyou1 = pIwssnTtdkrrksyorinaiyou1;
    }

    private String iwssnTtdkrrksyorinaiyou2;

    public String getIwssnTtdkrrksyorinaiyou2() {
        return iwssnTtdkrrksyorinaiyou2;
    }

    public void setIwssnTtdkrrksyorinaiyou2(String pIwssnTtdkrrksyorinaiyou2) {
        iwssnTtdkrrksyorinaiyou2 = pIwssnTtdkrrksyorinaiyou2;
    }

    private String iwssnTtdkrrksyorinaiyou3;

    public String getIwssnTtdkrrksyorinaiyou3() {
        return iwssnTtdkrrksyorinaiyou3;
    }

    public void setIwssnTtdkrrksyorinaiyou3(String pIwssnTtdkrrksyorinaiyou3) {
        iwssnTtdkrrksyorinaiyou3 = pIwssnTtdkrrksyorinaiyou3;
    }

    private String iwssnSyhenkouymd;

    public String getIwssnSyhenkouymd() {
        return iwssnSyhenkouymd;
    }

    public void setIwssnSyhenkouymd(String pIwssnSyhenkouymd) {
        iwssnSyhenkouymd = pIwssnSyhenkouymd;
    }

    private String iwssnSyhenkousyorinm;

    public String getIwssnSyhenkousyorinm() {
        return iwssnSyhenkousyorinm;
    }

    public void setIwssnSyhenkousyorinm(String pIwssnSyhenkousyorinm) {
        iwssnSyhenkousyorinm = pIwssnSyhenkousyorinm;
    }

    private String iwssnSyokensakuseiymd;

    public String getIwssnSyokensakuseiymd() {
        return iwssnSyokensakuseiymd;
    }

    public void setIwssnSyokensakuseiymd(String pIwssnSyokensakuseiymd) {
        iwssnSyokensakuseiymd = pIwssnSyokensakuseiymd;
    }

    private String iwssnSyosaihkymd;

    public String getIwssnSyosaihkymd() {
        return iwssnSyosaihkymd;
    }

    public void setIwssnSyosaihkymd(String pIwssnSyosaihkymd) {
        iwssnSyosaihkymd = pIwssnSyosaihkymd;
    }

    private String iwssnYensysnhkyenhnkymd;

    public String getIwssnYensysnhkyenhnkymd() {
        return iwssnYensysnhkyenhnkymd;
    }

    public void setIwssnYensysnhkyenhnkymd(String pIwssnYensysnhkyenhnkymd) {
        iwssnYensysnhkyenhnkymd = pIwssnYensysnhkyenhnkymd;
    }

    private String iwssnYennknhkyenhnkymd;

    public String getIwssnYennknhkyenhnkymd() {
        return iwssnYennknhkyenhnkymd;
    }

    public void setIwssnYennknhkyenhnkymd(String pIwssnYennknhkyenhnkymd) {
        iwssnYennknhkyenhnkymd = pIwssnYennknhkyenhnkymd;
    }

    private String iwssnWarnmongon;

    public String getIwssnWarnmongon() {
        return iwssnWarnmongon;
    }

    public void setIwssnWarnmongon(String pIwssnWarnmongon) {
        iwssnWarnmongon = pIwssnWarnmongon;
    }

    private String iwssnYakkanjyuryouhoukbn;

    public String getIwssnYakkanjyuryouhoukbn() {
        return iwssnYakkanjyuryouhoukbn;
    }

    public void setIwssnYakkanjyuryouhoukbn(String pIwssnYakkanjyuryouhoukbn) {
        iwssnYakkanjyuryouhoukbn = pIwssnYakkanjyuryouhoukbn;
    }

    private String iwssnYakkanjyuryouhoukbnnm;

    public String getIwssnYakkanjyuryouhoukbnnm() {
        return iwssnYakkanjyuryouhoukbnnm;
    }

    public void setIwssnYakkanjyuryouhoukbnnm(String pIwssnYakkanjyuryouhoukbnnm) {
        iwssnYakkanjyuryouhoukbnnm = pIwssnYakkanjyuryouhoukbnnm;
    }

    private String iwssnSioriyakkansearchcd;

    public String getIwssnSioriyakkansearchcd() {
        return iwssnSioriyakkansearchcd;
    }

    public void setIwssnSioriyakkansearchcd(String pIwssnSioriyakkansearchcd) {
        iwssnSioriyakkansearchcd = pIwssnSioriyakkansearchcd;
    }

    private String iwssnDattaisyoriymd;

    public String getIwssnDattaisyoriymd() {
        return iwssnDattaisyoriymd;
    }

    public void setIwssnDattaisyoriymd(String pIwssnDattaisyoriymd) {
        iwssnDattaisyoriymd = pIwssnDattaisyoriymd;
    }

    private String iwssnDtjcomment;

    public String getIwssnDtjcomment() {
        return iwssnDtjcomment;
    }

    public void setIwssnDtjcomment(String pIwssnDtjcomment) {
        iwssnDtjcomment = pIwssnDtjcomment;
    }

    private String iwssnHeijyunannaiym;

    public String getIwssnHeijyunannaiym() {
        return iwssnHeijyunannaiym;
    }

    public void setIwssnHeijyunannaiym(String pIwssnHeijyunannaiym) {
        iwssnHeijyunannaiym = pIwssnHeijyunannaiym;
    }

    private String iwssnHeijyunannaijyutouym;

    public String getIwssnHeijyunannaijyutouym() {
        return iwssnHeijyunannaijyutouym;
    }

    public void setIwssnHeijyunannaijyutouym(String pIwssnHeijyunannaijyutouym) {
        iwssnHeijyunannaijyutouym = pIwssnHeijyunannaijyutouym;
    }

    private String iwssn10nentumitateriritu;

    public String getIwssn10nentumitateriritu() {
        return iwssn10nentumitateriritu;
    }

    public void setIwssn10nentumitateriritu(String pIwssn10nentumitateriritu) {
        iwssn10nentumitateriritu = pIwssn10nentumitateriritu;
    }

    private String iwssnKykdrtkykhukakbn;

    public String getIwssnKykdrtkykhukakbn() {
        return iwssnKykdrtkykhukakbn;
    }

    public void setIwssnKykdrtkykhukakbn(String pIwssnKykdrtkykhukakbn) {
        iwssnKykdrtkykhukakbn = pIwssnKykdrtkykhukakbn;
    }

    private String iwssnKykdrkbn;

    public String getIwssnKykdrkbn() {
        return iwssnKykdrkbn;
    }

    public void setIwssnKykdrkbn(String pIwssnKykdrkbn) {
        iwssnKykdrkbn = pIwssnKykdrkbn;
    }

    private String iwssnKykdrkbnnm;

    public String getIwssnKykdrkbnnm() {
        return iwssnKykdrkbnnm;
    }

    public void setIwssnKykdrkbnnm(String pIwssnKykdrkbnnm) {
        iwssnKykdrkbnnm = pIwssnKykdrkbnnm;
    }

    private String iwssnKykdairinmkj;

    public String getIwssnKykdairinmkj() {
        return iwssnKykdairinmkj;
    }

    public void setIwssnKykdairinmkj(String pIwssnKykdairinmkj) {
        iwssnKykdairinmkj = pIwssnKykdairinmkj;
    }

    private String iwssnKykdairinmkn;

    public String getIwssnKykdairinmkn() {
        return iwssnKykdairinmkn;
    }

    public void setIwssnKykdairinmkn(String pIwssnKykdairinmkn) {
        iwssnKykdairinmkn = pIwssnKykdairinmkn;
    }

    private String iwssnKykdrseiymd;

    public String getIwssnKykdrseiymd() {
        return iwssnKykdrseiymd;
    }

    public void setIwssnKykdrseiymd(String pIwssnKykdrseiymd) {
        iwssnKykdrseiymd = pIwssnKykdrseiymd;
    }

    private String iwssnKykdryno;

    public String getIwssnKykdryno() {
        return iwssnKykdryno;
    }

    public void setIwssnKykdryno(String pIwssnKykdryno) {
        iwssnKykdryno = pIwssnKykdryno;
    }

    private String iwssnKykdradr1kj;

    public String getIwssnKykdradr1kj() {
        return iwssnKykdradr1kj;
    }

    public void setIwssnKykdradr1kj(String pIwssnKykdradr1kj) {
        iwssnKykdradr1kj = pIwssnKykdradr1kj;
    }

    private String iwssnKykdradr2kj;

    public String getIwssnKykdradr2kj() {
        return iwssnKykdradr2kj;
    }

    public void setIwssnKykdradr2kj(String pIwssnKykdradr2kj) {
        iwssnKykdradr2kj = pIwssnKykdradr2kj;
    }

    private String iwssnKykdradr3kj;

    public String getIwssnKykdradr3kj() {
        return iwssnKykdradr3kj;
    }

    public void setIwssnKykdradr3kj(String pIwssnKykdradr3kj) {
        iwssnKykdradr3kj = pIwssnKykdradr3kj;
    }

    private String iwssnKykdrknhatudoujyoutai;

    public String getIwssnKykdrknhatudoujyoutai() {
        return iwssnKykdrknhatudoujyoutai;
    }

    public void setIwssnKykdrknhatudoujyoutai(String pIwssnKykdrknhatudoujyoutai) {
        iwssnKykdrknhatudoujyoutai = pIwssnKykdrknhatudoujyoutai;
    }

    private String iwssnTrkkzknm1kn;

    public String getIwssnTrkkzknm1kn() {
        return iwssnTrkkzknm1kn;
    }

    public void setIwssnTrkkzknm1kn(String pIwssnTrkkzknm1kn) {
        iwssnTrkkzknm1kn = pIwssnTrkkzknm1kn;
    }

    private String iwssnTrkkzknm1kj;

    public String getIwssnTrkkzknm1kj() {
        return iwssnTrkkzknm1kj;
    }

    public void setIwssnTrkkzknm1kj(String pIwssnTrkkzknm1kj) {
        iwssnTrkkzknm1kj = pIwssnTrkkzknm1kj;
    }

    private String iwssnTrkkzk1seiymd;

    public String getIwssnTrkkzk1seiymd() {
        return iwssnTrkkzk1seiymd;
    }

    public void setIwssnTrkkzk1seiymd(String pIwssnTrkkzk1seiymd) {
        iwssnTrkkzk1seiymd = pIwssnTrkkzk1seiymd;
    }

    private String iwssnTrkkzk1sei;

    public String getIwssnTrkkzk1sei() {
        return iwssnTrkkzk1sei;
    }

    public void setIwssnTrkkzk1sei(String pIwssnTrkkzk1sei) {
        iwssnTrkkzk1sei = pIwssnTrkkzk1sei;
    }

    private String iwssnTrkkzk1seinm;

    public String getIwssnTrkkzk1seinm() {
        return iwssnTrkkzk1seinm;
    }

    public void setIwssnTrkkzk1seinm(String pIwssnTrkkzk1seinm) {
        iwssnTrkkzk1seinm = pIwssnTrkkzk1seinm;
    }

    private String iwssnTrkkzk1tdk;

    public String getIwssnTrkkzk1tdk() {
        return iwssnTrkkzk1tdk;
    }

    public void setIwssnTrkkzk1tdk(String pIwssnTrkkzk1tdk) {
        iwssnTrkkzk1tdk = pIwssnTrkkzk1tdk;
    }

    private String iwssnTrkkzk1tdknm;

    public String getIwssnTrkkzk1tdknm() {
        return iwssnTrkkzk1tdknm;
    }

    public void setIwssnTrkkzk1tdknm(String pIwssnTrkkzk1tdknm) {
        iwssnTrkkzk1tdknm = pIwssnTrkkzk1tdknm;
    }

    private String iwssnTrkkzk1yno;

    public String getIwssnTrkkzk1yno() {
        return iwssnTrkkzk1yno;
    }

    public void setIwssnTrkkzk1yno(String pIwssnTrkkzk1yno) {
        iwssnTrkkzk1yno = pIwssnTrkkzk1yno;
    }

    private String iwssnTrkkzk1adr1kj;

    public String getIwssnTrkkzk1adr1kj() {
        return iwssnTrkkzk1adr1kj;
    }

    public void setIwssnTrkkzk1adr1kj(String pIwssnTrkkzk1adr1kj) {
        iwssnTrkkzk1adr1kj = pIwssnTrkkzk1adr1kj;
    }

    private String iwssnTrkkzk1adr2kj;

    public String getIwssnTrkkzk1adr2kj() {
        return iwssnTrkkzk1adr2kj;
    }

    public void setIwssnTrkkzk1adr2kj(String pIwssnTrkkzk1adr2kj) {
        iwssnTrkkzk1adr2kj = pIwssnTrkkzk1adr2kj;
    }

    private String iwssnTrkkzk1adr3kj;

    public String getIwssnTrkkzk1adr3kj() {
        return iwssnTrkkzk1adr3kj;
    }

    public void setIwssnTrkkzk1adr3kj(String pIwssnTrkkzk1adr3kj) {
        iwssnTrkkzk1adr3kj = pIwssnTrkkzk1adr3kj;
    }

    private String iwssnTrkkzk1telno;

    public String getIwssnTrkkzk1telno() {
        return iwssnTrkkzk1telno;
    }

    public void setIwssnTrkkzk1telno(String pIwssnTrkkzk1telno) {
        iwssnTrkkzk1telno = pIwssnTrkkzk1telno;
    }

    private String iwssnTrkkzknm2kn;

    public String getIwssnTrkkzknm2kn() {
        return iwssnTrkkzknm2kn;
    }

    public void setIwssnTrkkzknm2kn(String pIwssnTrkkzknm2kn) {
        iwssnTrkkzknm2kn = pIwssnTrkkzknm2kn;
    }

    private String iwssnTrkkzknm2kj;

    public String getIwssnTrkkzknm2kj() {
        return iwssnTrkkzknm2kj;
    }

    public void setIwssnTrkkzknm2kj(String pIwssnTrkkzknm2kj) {
        iwssnTrkkzknm2kj = pIwssnTrkkzknm2kj;
    }

    private String iwssnTrkkzk2seiymd;

    public String getIwssnTrkkzk2seiymd() {
        return iwssnTrkkzk2seiymd;
    }

    public void setIwssnTrkkzk2seiymd(String pIwssnTrkkzk2seiymd) {
        iwssnTrkkzk2seiymd = pIwssnTrkkzk2seiymd;
    }

    private String iwssnTrkkzk2sei;

    public String getIwssnTrkkzk2sei() {
        return iwssnTrkkzk2sei;
    }

    public void setIwssnTrkkzk2sei(String pIwssnTrkkzk2sei) {
        iwssnTrkkzk2sei = pIwssnTrkkzk2sei;
    }

    private String iwssnTrkkzk2seinm;

    public String getIwssnTrkkzk2seinm() {
        return iwssnTrkkzk2seinm;
    }

    public void setIwssnTrkkzk2seinm(String pIwssnTrkkzk2seinm) {
        iwssnTrkkzk2seinm = pIwssnTrkkzk2seinm;
    }

    private String iwssnTrkkzk2tdk;

    public String getIwssnTrkkzk2tdk() {
        return iwssnTrkkzk2tdk;
    }

    public void setIwssnTrkkzk2tdk(String pIwssnTrkkzk2tdk) {
        iwssnTrkkzk2tdk = pIwssnTrkkzk2tdk;
    }

    private String iwssnTrkkzk2tdknm;

    public String getIwssnTrkkzk2tdknm() {
        return iwssnTrkkzk2tdknm;
    }

    public void setIwssnTrkkzk2tdknm(String pIwssnTrkkzk2tdknm) {
        iwssnTrkkzk2tdknm = pIwssnTrkkzk2tdknm;
    }

    private String iwssnTrkkzk2yno;

    public String getIwssnTrkkzk2yno() {
        return iwssnTrkkzk2yno;
    }

    public void setIwssnTrkkzk2yno(String pIwssnTrkkzk2yno) {
        iwssnTrkkzk2yno = pIwssnTrkkzk2yno;
    }

    private String iwssnTrkkzk2adr1kj;

    public String getIwssnTrkkzk2adr1kj() {
        return iwssnTrkkzk2adr1kj;
    }

    public void setIwssnTrkkzk2adr1kj(String pIwssnTrkkzk2adr1kj) {
        iwssnTrkkzk2adr1kj = pIwssnTrkkzk2adr1kj;
    }

    private String iwssnTrkkzk2adr2kj;

    public String getIwssnTrkkzk2adr2kj() {
        return iwssnTrkkzk2adr2kj;
    }

    public void setIwssnTrkkzk2adr2kj(String pIwssnTrkkzk2adr2kj) {
        iwssnTrkkzk2adr2kj = pIwssnTrkkzk2adr2kj;
    }

    private String iwssnTrkkzk2adr3kj;

    public String getIwssnTrkkzk2adr3kj() {
        return iwssnTrkkzk2adr3kj;
    }

    public void setIwssnTrkkzk2adr3kj(String pIwssnTrkkzk2adr3kj) {
        iwssnTrkkzk2adr3kj = pIwssnTrkkzk2adr3kj;
    }

    private String iwssnTrkkzk2telno;

    public String getIwssnTrkkzk2telno() {
        return iwssnTrkkzk2telno;
    }

    public void setIwssnTrkkzk2telno(String pIwssnTrkkzk2telno) {
        iwssnTrkkzk2telno = pIwssnTrkkzk2telno;
    }

    private String iwssnKaiyakukjgk;

    public String getIwssnKaiyakukjgk() {
        return iwssnKaiyakukjgk;
    }

    public void setIwssnKaiyakukjgk(String pIwssnKaiyakukjgk) {
        iwssnKaiyakukjgk = pIwssnKaiyakukjgk;
    }

    private String iwssnKaiyakukjgktuukasyu;

    public String getIwssnKaiyakukjgktuukasyu() {
        return iwssnKaiyakukjgktuukasyu;
    }

    public void setIwssnKaiyakukjgktuukasyu(String pIwssnKaiyakukjgktuukasyu) {
        iwssnKaiyakukjgktuukasyu = pIwssnKaiyakukjgktuukasyu;
    }

    private String iwssnKaiyakukoujyoritu;

    public String getIwssnKaiyakukoujyoritu() {
        return iwssnKaiyakukoujyoritu;
    }

    public void setIwssnKaiyakukoujyoritu(String pIwssnKaiyakukoujyoritu) {
        iwssnKaiyakukoujyoritu = pIwssnKaiyakukoujyoritu;
    }

    private String iwssnCreyuukoukakkekka;

    public String getIwssnCreyuukoukakkekka() {
        return iwssnCreyuukoukakkekka;
    }

    public void setIwssnCreyuukoukakkekka(String pIwssnCreyuukoukakkekka) {
        iwssnCreyuukoukakkekka = pIwssnCreyuukoukakkekka;
    }

    private String iwssnCreyuukoukakkekkakbnnm;

    public String getIwssnCreyuukoukakkekkakbnnm() {
        return iwssnCreyuukoukakkekkakbnnm;
    }

    @DataConvert("toMultiByte")
    public void setIwssnCreyuukoukakkekkakbnnm(String pIwssnCreyuukoukakkekkakbnnm) {
        iwssnCreyuukoukakkekkakbnnm = pIwssnCreyuukoukakkekkakbnnm;
    }

    private String iwssnCredityuukoukakym;

    public String getIwssnCredityuukoukakym() {
        return iwssnCredityuukoukakym;
    }

    public void setIwssnCredityuukoukakym(String pIwssnCredityuukoukakym) {
        iwssnCredityuukoukakym = pIwssnCredityuukoukakym;
    }

    private String iwssnUragngjiyuukbn1;

    public String getIwssnUragngjiyuukbn1() {
        return iwssnUragngjiyuukbn1;
    }

    public void setIwssnUragngjiyuukbn1(String pIwssnUragngjiyuukbn1) {
        iwssnUragngjiyuukbn1 = pIwssnUragngjiyuukbn1;
    }

    private String iwssnUragngjiyuukbn2;

    public String getIwssnUragngjiyuukbn2() {
        return iwssnUragngjiyuukbn2;
    }

    public void setIwssnUragngjiyuukbn2(String pIwssnUragngjiyuukbn2) {
        iwssnUragngjiyuukbn2 = pIwssnUragngjiyuukbn2;
    }

    private String iwssnUragngjiyuukbn3;

    public String getIwssnUragngjiyuukbn3() {
        return iwssnUragngjiyuukbn3;
    }

    public void setIwssnUragngjiyuukbn3(String pIwssnUragngjiyuukbn3) {
        iwssnUragngjiyuukbn3 = pIwssnUragngjiyuukbn3;
    }

    private String iwssnUragngjiyuukbnnm1;

    public String getIwssnUragngjiyuukbnnm1() {
        return iwssnUragngjiyuukbnnm1;
    }

    @DataConvert("toMultiByte")
    public void setIwssnUragngjiyuukbnnm1(String pIwssnUragngjiyuukbnnm1) {
        iwssnUragngjiyuukbnnm1 = pIwssnUragngjiyuukbnnm1;
    }

    private String iwssnUragngjiyuukbnnm2;

    public String getIwssnUragngjiyuukbnnm2() {
        return iwssnUragngjiyuukbnnm2;
    }

    @DataConvert("toMultiByte")
    public void setIwssnUragngjiyuukbnnm2(String pIwssnUragngjiyuukbnnm2) {
        iwssnUragngjiyuukbnnm2 = pIwssnUragngjiyuukbnnm2;
    }

    private String iwssnUragngjiyuukbnnm3;

    public String getIwssnUragngjiyuukbnnm3() {
        return iwssnUragngjiyuukbnnm3;
    }

    @DataConvert("toMultiByte")
    public void setIwssnUragngjiyuukbnnm3(String pIwssnUragngjiyuukbnnm3) {
        iwssnUragngjiyuukbnnm3 = pIwssnUragngjiyuukbnnm3;
    }

    private String iwssnSyuhrkkknsmnkbn;

    public String getIwssnSyuhrkkknsmnkbn() {
        return iwssnSyuhrkkknsmnkbn;
    }

    public void setIwssnSyuhrkkknsmnkbn(String pIwssnSyuhrkkknsmnkbn) {
        iwssnSyuhrkkknsmnkbn = pIwssnSyuhrkkknsmnkbn;
    }

    private String iwssnSyuhrkkknsmnkbnnm;

    public String getIwssnSyuhrkkknsmnkbnnm() {
        return iwssnSyuhrkkknsmnkbnnm;
    }

    public void setIwssnSyuhrkkknsmnkbnnm(String pIwssnSyuhrkkknsmnkbnnm) {
        iwssnSyuhrkkknsmnkbnnm = pIwssnSyuhrkkknsmnkbnnm;
    }

    private String iwssnSyuhknkknsmnkbn;

    public String getIwssnSyuhknkknsmnkbn() {
        return iwssnSyuhknkknsmnkbn;
    }

    public void setIwssnSyuhknkknsmnkbn(String pIwssnSyuhknkknsmnkbn) {
        iwssnSyuhknkknsmnkbn = pIwssnSyuhknkknsmnkbn;
    }

    private String iwssnSyuhknkknsmnkbnnm;

    public String getIwssnSyuhknkknsmnkbnnm() {
        return iwssnSyuhknkknsmnkbnnm;
    }

    public void setIwssnSyuhknkknsmnkbnnm(String pIwssnSyuhknkknsmnkbnnm) {
        iwssnSyuhknkknsmnkbnnm = pIwssnSyuhknkknsmnkbnnm;
    }

    private String iwssnMkhynsysnnktkjnkgtuksy;

    public String getIwssnMkhynsysnnktkjnkgtuksy() {
        return iwssnMkhynsysnnktkjnkgtuksy;
    }

    public void setIwssnMkhynsysnnktkjnkgtuksy(String pIwssnMkhynsysnnktkjnkgtuksy) {
        iwssnMkhynsysnnktkjnkgtuksy = pIwssnMkhynsysnnktkjnkgtuksy;
    }

    private String iwssnItijibrpgaikatuukasyu;

    public String getIwssnItijibrpgaikatuukasyu() {
        return iwssnItijibrpgaikatuukasyu;
    }

    public void setIwssnItijibrpgaikatuukasyu(String pIwssnItijibrpgaikatuukasyu) {
        iwssnItijibrpgaikatuukasyu = pIwssnItijibrpgaikatuukasyu;
    }

    private String iwssnItijibrpyentuukasyu;

    public String getIwssnItijibrpyentuukasyu() {
        return iwssnItijibrpyentuukasyu;
    }

    public void setIwssnItijibrpyentuukasyu(String pIwssnItijibrpyentuukasyu) {
        iwssnItijibrpyentuukasyu = pIwssnItijibrpyentuukasyu;
    }

    private String iwssnHrkptuukasyu;

    public String getIwssnHrkptuukasyu() {
        return iwssnHrkptuukasyu;
    }

    public void setIwssnHrkptuukasyu(String pIwssnHrkptuukasyu) {
        iwssnHrkptuukasyu = pIwssnHrkptuukasyu;
    }

    private String iwssnKihonhokenkngktuukasyu;

    public String getIwssnKihonhokenkngktuukasyu() {
        return iwssnKihonhokenkngktuukasyu;
    }

    public void setIwssnKihonhokenkngktuukasyu(String pIwssnKihonhokenkngktuukasyu) {
        iwssnKihonhokenkngktuukasyu = pIwssnKihonhokenkngktuukasyu;
    }

    private String iwssnGenzaisbhknkngakutuksy;

    public String getIwssnGenzaisbhknkngakutuksy() {
        return iwssnGenzaisbhknkngakutuksy;
    }

    public void setIwssnGenzaisbhknkngakutuksy(String pIwssnGenzaisbhknkngakutuksy) {
        iwssnGenzaisbhknkngakutuksy = pIwssnGenzaisbhknkngakutuksy;
    }

    private String iwssnKijyunkingakuyentuksyu;

    public String getIwssnKijyunkingakuyentuksyu() {
        return iwssnKijyunkingakuyentuksyu;
    }

    public void setIwssnKijyunkingakuyentuksyu(String pIwssnKijyunkingakuyentuksyu) {
        iwssnKijyunkingakuyentuksyu = pIwssnKijyunkingakuyentuksyu;
    }

    private String iwssnKijyunkingakugktuksyu;

    public String getIwssnKijyunkingakugktuksyu() {
        return iwssnKijyunkingakugktuksyu;
    }

    public void setIwssnKijyunkingakugktuksyu(String pIwssnKijyunkingakugktuksyu) {
        iwssnKijyunkingakugktuksyu = pIwssnKijyunkingakugktuksyu;
    }

    private String iwssnInitsbjyensykjnkgtksy;

    public String getIwssnInitsbjyensykjnkgtksy() {
        return iwssnInitsbjyensykjnkgtksy;
    }

    public void setIwssnInitsbjyensykjnkgtksy(String pIwssnInitsbjyensykjnkgtksy) {
        iwssnInitsbjyensykjnkgtksy = pIwssnInitsbjyensykjnkgtksy;
    }

    private String iwssnKaiyakuhrgaikatuukasyu;

    public String getIwssnKaiyakuhrgaikatuukasyu() {
        return iwssnKaiyakuhrgaikatuukasyu;
    }

    public void setIwssnKaiyakuhrgaikatuukasyu(String pIwssnKaiyakuhrgaikatuukasyu) {
        iwssnKaiyakuhrgaikatuukasyu = pIwssnKaiyakuhrgaikatuukasyu;
    }

    private String iwssnKaiyakuhryentuukasyu;

    public String getIwssnKaiyakuhryentuukasyu() {
        return iwssnKaiyakuhryentuukasyu;
    }

    public void setIwssnKaiyakuhryentuukasyu(String pIwssnKaiyakuhryentuukasyu) {
        iwssnKaiyakuhryentuukasyu = pIwssnKaiyakuhryentuukasyu;
    }

    private String iwssnShrgkkeigaikatuukasyu;

    public String getIwssnShrgkkeigaikatuukasyu() {
        return iwssnShrgkkeigaikatuukasyu;
    }

    public void setIwssnShrgkkeigaikatuukasyu(String pIwssnShrgkkeigaikatuukasyu) {
        iwssnShrgkkeigaikatuukasyu = pIwssnShrgkkeigaikatuukasyu;
    }

    private String iwssnShrgkkeiyentuukasyu;

    public String getIwssnShrgkkeiyentuukasyu() {
        return iwssnShrgkkeiyentuukasyu;
    }

    public void setIwssnShrgkkeiyentuukasyu(String pIwssnShrgkkeiyentuukasyu) {
        iwssnShrgkkeiyentuukasyu = pIwssnShrgkkeiyentuukasyu;
    }

    private String iwssnZennouseisankintuukasy;

    public String getIwssnZennouseisankintuukasy() {
        return iwssnZennouseisankintuukasy;
    }

    public void setIwssnZennouseisankintuukasy(String pIwssnZennouseisankintuukasy) {
        iwssnZennouseisankintuukasy = pIwssnZennouseisankintuukasy;
    }

    private String iwssnPtumitatekintuukasyu;

    public String getIwssnPtumitatekintuukasyu() {
        return iwssnPtumitatekintuukasyu;
    }

    public void setIwssnPtumitatekintuukasyu(String pIwssnPtumitatekintuukasyu) {
        iwssnPtumitatekintuukasyu = pIwssnPtumitatekintuukasyu;
    }

    private String iwssnSykaipnyknratesyutkymd;

    public String getIwssnSykaipnyknratesyutkymd() {
        return iwssnSykaipnyknratesyutkymd;
    }

    public void setIwssnSykaipnyknratesyutkymd(String pIwssnSykaipnyknratesyutkymd) {
        iwssnSykaipnyknratesyutkymd = pIwssnSykaipnyknratesyutkymd;
    }

    private String iwssnHhkdrseiymd;

    public String getIwssnHhkdrseiymd() {
        return iwssnHhkdrseiymd;
    }

    public void setIwssnHhkdrseiymd(String pIwssnHhkdrseiymd) {
        iwssnHhkdrseiymd = pIwssnHhkdrseiymd;
    }

    private String iwssnItijibrpnykntuuka;

    public String getIwssnItijibrpnykntuuka() {
        return iwssnItijibrpnykntuuka;
    }

    public void setIwssnItijibrpnykntuuka(String pIwssnItijibrpnykntuuka) {
        iwssnItijibrpnykntuuka = pIwssnItijibrpnykntuuka;
    }

    private String iwssnItijibrpnykntuukatuksy;

    public String getIwssnItijibrpnykntuukatuksy() {
        return iwssnItijibrpnykntuukatuksy;
    }

    public void setIwssnItijibrpnykntuukatuksy(String pIwssnItijibrpnykntuukatuksy) {
        iwssnItijibrpnykntuukatuksy = pIwssnItijibrpnykntuukatuksy;
    }

    private String iwssnKzktrkserviceryumu;

    public String getIwssnKzktrkserviceryumu() {
        return iwssnKzktrkserviceryumu;
    }

    public void setIwssnKzktrkserviceryumu(String pIwssnKzktrkserviceryumu) {
        iwssnKzktrkserviceryumu = pIwssnKzktrkserviceryumu;
    }

    private String iwssnRendouritu;

    public String getIwssnRendouritu() {
        return iwssnRendouritu;
    }

    public void setIwssnRendouritu(String pIwssnRendouritu) {
        iwssnRendouritu = pIwssnRendouritu;
    }

    private String iwssnTrkkzk1tsindousiteikbn;

    public String getIwssnTrkkzk1tsindousiteikbn() {
        return iwssnTrkkzk1tsindousiteikbn;
    }

    public void setIwssnTrkkzk1tsindousiteikbn(String pIwssnTrkkzk1tsindousiteikbn) {
        iwssnTrkkzk1tsindousiteikbn = pIwssnTrkkzk1tsindousiteikbn;
    }

    private String iwssnTrkkzk2tsindousiteikbn;

    public String getIwssnTrkkzk2tsindousiteikbn() {
        return iwssnTrkkzk2tsindousiteikbn;
    }

    public void setIwssnTrkkzk2tsindousiteikbn(String pIwssnTrkkzk2tsindousiteikbn) {
        iwssnTrkkzk2tsindousiteikbn = pIwssnTrkkzk2tsindousiteikbn;
    }

    private String iwssnStknsetkbn;

    public String getIwssnStknsetkbn() {
        return iwssnStknsetkbn;
    }

    public void setIwssnStknsetkbn(String pIwssnStknsetkbn) {
        iwssnStknsetkbn = pIwssnStknsetkbn;
    }

    private String iwssnStknsetkbnnm;

    public String getIwssnStknsetkbnnm() {
        return iwssnStknsetkbnnm;
    }

    public void setIwssnStknsetkbnnm(String pIwssnStknsetkbnnm) {
        iwssnStknsetkbnnm = pIwssnStknsetkbnnm;
    }

    private String iwssnKaripasswordykymd;

    public String getIwssnKaripasswordykymd() {
        return iwssnKaripasswordykymd;
    }

    public void setIwssnKaripasswordykymd(String pIwssnKaripasswordykymd) {
        iwssnKaripasswordykymd = pIwssnKaripasswordykymd;
    }

    private String iwssnYnkhrkmgkannittkbn;

    public String getIwssnYnkhrkmgkannittkbn() {
        return iwssnYnkhrkmgkannittkbn;
    }

    public void setIwssnYnkhrkmgkannittkbn(String pIwssnYnkhrkmgkannittkbn) {
        iwssnYnkhrkmgkannittkbn = pIwssnYnkhrkmgkannittkbn;
    }

    private String iwssnYnkhrkmgkannittkbnnm;

    public String getIwssnYnkhrkmgkannittkbnnm() {
        return iwssnYnkhrkmgkannittkbnnm;
    }

    public void setIwssnYnkhrkmgkannittkbnnm(String pIwssnYnkhrkmgkannittkbnnm) {
        iwssnYnkhrkmgkannittkbnnm = pIwssnYnkhrkmgkannittkbnnm;
    }

    private String iwssnDai2tsintelno;

    public String getIwssnDai2tsintelno() {
        return iwssnDai2tsintelno;
    }

    public void setIwssnDai2tsintelno(String pIwssnDai2tsintelno) {
        iwssnDai2tsintelno = pIwssnDai2tsintelno;
    }

    private String iwssnYenkansanp;

    public String getIwssnYenkansanp() {
        return iwssnYenkansanp;
    }

    public void setIwssnYenkansanp(String pIwssnYenkansanp) {
        iwssnYenkansanp = pIwssnYenkansanp;
    }

    private String iwssnYenkansanptuukasyu;

    public String getIwssnYenkansanptuukasyu() {
        return iwssnYenkansanptuukasyu;
    }

    public void setIwssnYenkansanptuukasyu(String pIwssnYenkansanptuukasyu) {
        iwssnYenkansanptuukasyu = pIwssnYenkansanptuukasyu;
    }

    private String iwssnKktikwsrate;

    public String getIwssnKktikwsrate() {
        return iwssnKktikwsrate;
    }

    public void setIwssnKktikwsrate(String pIwssnKktikwsrate) {
        iwssnKktikwsrate = pIwssnKktikwsrate;
    }

    private String iwssnKnsnkijyunymd;

    public String getIwssnKnsnkijyunymd() {
        return iwssnKnsnkijyunymd;
    }

    public void setIwssnKnsnkijyunymd(String pIwssnKnsnkijyunymd) {
        iwssnKnsnkijyunymd = pIwssnKnsnkijyunymd;
    }

    private String iwssnYykknmnryymd;

    public String getIwssnYykknmnryymd() {
        return iwssnYykknmnryymd;
    }

    public void setIwssnYykknmnryymd(String pIwssnYykknmnryymd) {
        iwssnYykknmnryymd = pIwssnYykknmnryymd;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
