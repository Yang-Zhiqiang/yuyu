package yuyu.app.sinkeiyaku.skkettei.skkankyousatei;

import java.io.Serializable;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_AnkenJyoutaiKbn;
import yuyu.def.classification.C_KykKbn;
import yuyu.def.classification.C_KykSyubetuKbn;

/**
 * 環境査定 - ●他社加入状況 の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenTasyaKanyuuJoukyouDataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Boolean tasyaout;

    public Boolean getTasyaout() {
        return tasyaout == null ? Boolean.FALSE : tasyaout;
    }

    public void setTasyaout(Boolean pTasyaout) {
        tasyaout = pTasyaout == null ? Boolean.FALSE : pTasyaout;
    }


    private BizNumber tasyano;

    public BizNumber getTasyano() {
        return tasyano;
    }

    @DataConvert("toSingleByte")
    public void setTasyano(BizNumber pTasyano) {
        tasyano = pTasyano;
    }


    private C_AnkenJyoutaiKbn tasyaankenjyoutai;

    public C_AnkenJyoutaiKbn getTasyaankenjyoutai() {
        return tasyaankenjyoutai;
    }

    public void setTasyaankenjyoutai(C_AnkenJyoutaiKbn pTasyaankenjyoutai) {
        tasyaankenjyoutai = pTasyaankenjyoutai;
    }


    private C_KykSyubetuKbn tasyakyksyubetu;

    public C_KykSyubetuKbn getTasyakyksyubetu() {
        return tasyakyksyubetu;
    }

    public void setTasyakyksyubetu(C_KykSyubetuKbn pTasyakyksyubetu) {
        tasyakyksyubetu = pTasyakyksyubetu;
    }


    private String tasyakaisyacd;

    public String getTasyakaisyacd() {
        return tasyakaisyacd;
    }

    public void setTasyakaisyacd(String pTasyakaisyacd) {
        tasyakaisyacd = pTasyakaisyacd;
    }


    private String tasyakaisyanm;

    public String getTasyakaisyanm() {
        return tasyakaisyanm;
    }

    public void setTasyakaisyanm(String pTasyakaisyanm) {
        tasyakaisyanm = pTasyakaisyanm;
    }


    private C_KykKbn tasyakykkbn;

    public C_KykKbn getTasyakykkbn() {
        return tasyakykkbn;
    }

    public void setTasyakykkbn(C_KykKbn pTasyakykkbn) {
        tasyakykkbn = pTasyakykkbn;
    }


    private String tasyakyknmkn;

    public String getTasyakyknmkn() {
        return tasyakyknmkn;
    }

    public void setTasyakyknmkn(String pTasyakyknmkn) {
        tasyakyknmkn = pTasyakyknmkn;
    }


    private String tasyakyknmkj;

    public String getTasyakyknmkj() {
        return tasyakyknmkj;
    }

    public void setTasyakyknmkj(String pTasyakyknmkj) {
        tasyakyknmkj = pTasyakyknmkj;
    }


    private String tasyahhknnmkn;

    public String getTasyahhknnmkn() {
        return tasyahhknnmkn;
    }

    public void setTasyahhknnmkn(String pTasyahhknnmkn) {
        tasyahhknnmkn = pTasyahhknnmkn;
    }


    private String tasyahhknnmkj;

    public String getTasyahhknnmkj() {
        return tasyahhknnmkj;
    }

    public void setTasyahhknnmkj(String pTasyahhknnmkj) {
        tasyahhknnmkj = pTasyahhknnmkj;
    }


    private String tasyasyuutyuu;

    public String getTasyasyuutyuu() {
        return tasyasyuutyuu;
    }

    public void setTasyasyuutyuu(String pTasyasyuutyuu) {
        tasyasyuutyuu = pTasyasyuutyuu;
    }


    private BizDate tasyakykymd;

    public BizDate getTasyakykymd() {
        return tasyakykymd;
    }

    @DataConvert("toSingleByte")
    public void setTasyakykymd(BizDate pTasyakykymd) {
        tasyakykymd = pTasyakykymd;
    }


    private BizDate tasyatrkymd;

    public BizDate getTasyatrkymd() {
        return tasyatrkymd;
    }

    @DataConvert("toSingleByte")
    public void setTasyatrkymd(BizDate pTasyatrkymd) {
        tasyatrkymd = pTasyatrkymd;
    }


    private BizNumber tasyasibusmantyen;

    public BizNumber getTasyasibusmantyen() {
        return tasyasibusmantyen;
    }

    public void setTasyasibusmantyen(BizNumber pTasyasibusmantyen) {
        tasyasibusmantyen = pTasyasibusmantyen;
    }


    private BizNumber tasyasaigaismanyen;

    public BizNumber getTasyasaigaismanyen() {
        return tasyasaigaismanyen;
    }

    public void setTasyasaigaismanyen(BizNumber pTasyasaigaismanyen) {
        tasyasaigaismanyen = pTasyasaigaismanyen;
    }


    private BizNumber tasyasaigaisenyen;

    public BizNumber getTasyasaigaisenyen() {
        return tasyasaigaisenyen;
    }

    public void setTasyasaigaisenyen(BizNumber pTasyasaigaisenyen) {
        tasyasaigaisenyen = pTasyasaigaisenyen;
    }


    private BizNumber tasyasippeisenyen;

    public BizNumber getTasyasippeisenyen() {
        return tasyasippeisenyen;
    }

    public void setTasyasippeisenyen(BizNumber pTasyasippeisenyen) {
        tasyasippeisenyen = pTasyasippeisenyen;
    }


    private BizNumber tasyaseijinbyousenyen;

    public BizNumber getTasyaseijinbyousenyen() {
        return tasyaseijinbyousenyen;
    }

    public void setTasyaseijinbyousenyen(BizNumber pTasyaseijinbyousenyen) {
        tasyaseijinbyousenyen = pTasyaseijinbyousenyen;
    }


    private BizNumber tasyasonotasenyen;

    public BizNumber getTasyasonotasenyen() {
        return tasyasonotasenyen;
    }

    public void setTasyasonotasenyen(BizNumber pTasyasonotasenyen) {
        tasyasonotasenyen = pTasyasonotasenyen;
    }


    private String tasyakanyuusyano;

    public String getTasyakanyuusyano() {
        return tasyakanyuusyano;
    }

    public void setTasyakanyuusyano(String pTasyakanyuusyano) {
        tasyakanyuusyano = pTasyakanyuusyano;
    }


    private String tasyahknkykkanrino;

    public String getTasyahknkykkanrino() {
        return tasyahknkykkanrino;
    }

    public void setTasyahknkykkanrino(String pTasyahknkykkanrino) {
        tasyahknkykkanrino = pTasyahknkykkanrino;
    }

}
