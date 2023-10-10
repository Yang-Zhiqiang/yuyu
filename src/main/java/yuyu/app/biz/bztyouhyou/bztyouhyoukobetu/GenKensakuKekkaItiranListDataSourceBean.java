package yuyu.app.biz.bztyouhyou.bztyouhyoukobetu;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;

/**
 * 帳票個別出力 - 検索結果一覧 の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenKensakuKekkaItiranListDataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String tyouhyouSyuturyokuLink;

    public String getTyouhyouSyuturyokuLink() {
        return tyouhyouSyuturyokuLink;
    }

    public void setTyouhyouSyuturyokuLink(String pTyouhyouSyuturyokuLink) {
        tyouhyouSyuturyokuLink = pTyouhyouSyuturyokuLink;
    }


    private String knskkmknm1;

    public String getKnskkmknm1() {
        return knskkmknm1;
    }

    public void setKnskkmknm1(String pKnskkmknm1) {
        knskkmknm1 = pKnskkmknm1;
    }


    private String knskkmknm2;

    public String getKnskkmknm2() {
        return knskkmknm2;
    }

    public void setKnskkmknm2(String pKnskkmknm2) {
        knskkmknm2 = pKnskkmknm2;
    }


    private String knskkmknm3;

    public String getKnskkmknm3() {
        return knskkmknm3;
    }

    public void setKnskkmknm3(String pKnskkmknm3) {
        knskkmknm3 = pKnskkmknm3;
    }


    private String knskkmknm4;

    public String getKnskkmknm4() {
        return knskkmknm4;
    }

    public void setKnskkmknm4(String pKnskkmknm4) {
        knskkmknm4 = pKnskkmknm4;
    }


    private String knskkmknm5;

    public String getKnskkmknm5() {
        return knskkmknm5;
    }

    public void setKnskkmknm5(String pKnskkmknm5) {
        knskkmknm5 = pKnskkmknm5;
    }


    private BizDate disptyouhyousakuseiymd;

    public BizDate getDisptyouhyousakuseiymd() {
        return disptyouhyousakuseiymd;
    }

    public void setDisptyouhyousakuseiymd(BizDate pDisptyouhyousakuseiymd) {
        disptyouhyousakuseiymd = pDisptyouhyousakuseiymd;
    }


    private Long dispoutkaisuu;

    public Long getDispoutkaisuu() {
        return dispoutkaisuu;
    }

    public void setDispoutkaisuu(Long pDispoutkaisuu) {
        dispoutkaisuu = pDispoutkaisuu;
    }


    private BizDate dispfstoutymd;

    public BizDate getDispfstoutymd() {
        return dispfstoutymd;
    }

    public void setDispfstoutymd(BizDate pDispfstoutymd) {
        dispfstoutymd = pDispfstoutymd;
    }


    private BizDate displstoutymd;

    public BizDate getDisplstoutymd() {
        return displstoutymd;
    }

    public void setDisplstoutymd(BizDate pDisplstoutymd) {
        displstoutymd = pDisplstoutymd;
    }

}
