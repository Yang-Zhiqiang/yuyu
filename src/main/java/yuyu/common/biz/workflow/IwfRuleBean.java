package yuyu.common.biz.workflow;

import java.io.Serializable;

/**
 * IWF分岐条件Beanです。<br />
 * 当クラスに、フィールドを追加する際は、あわせて基盤利用フィールド（翻訳結果が入る）も同時に追加しなければならない。<br />
 */
public class IwfRuleBean implements Serializable {

    private static final long serialVersionUID = 20120126L;

    private String kekkaKbn;

    private String tensouSakiTskKbn;

    private String syouninSybt;

    //    private String riyouKbn;
    //
    //    private String soukinbiSijiFlg;
    //
    //    private String kekkaKbnNaiyou;
    //
    //    private String tensouSakiTskKbnNaiyou;
    //
    //    private String syouninSybtNaiyou;
    //
    //    private String riyouKbnNaiyou;
    //
    //    private String soukinbiSijiFlgNaiyou;

    public String getKekkaKbn() {
        return kekkaKbn;
    }

    public void setKekkaKbn(String pKekkaKbn) {
        this.kekkaKbn = pKekkaKbn;
        //        String naiyou = null;
        //        try {
        //            naiyou = BizAppCode.getCodeCnv(BizCodeName.sN_KEKKAKBN, String.valueOf(kekkaKbn));
        //        } catch (Exception e) {
        //            new RuntimeException("想定外の結果区分が設定されました。 [kekkaKbn=" + kekkaKbn + "]");
        //        }
        //        setKekkaKbnNaiyou(naiyou);
    }

    public String getTensouSakiTskKbn() {
        return tensouSakiTskKbn;
    }

    public void setTensouSakiTskKbn(String pTensouSakiTskKbn) {
        this.tensouSakiTskKbn = pTensouSakiTskKbn;
        //        String naiyou = null;
        //        try {
        //            naiyou = BizAppCode.getCodeCnv(BizCodeName.sN_TENSOUSAKITSKKBN, String.valueOf(tensouSakiTskKbn));
        //        } catch (Exception e) {
        //            new RuntimeException("想定外の転送先タスク区分が設定されました。 [tensouSakiTskKbn=" + tensouSakiTskKbn + "]");
        //        }
        //        setTensouSakiTskKbnNaiyou(naiyou);
    }

    public String getSyouninSybt() {
        return syouninSybt;
    }

    public void setSyouninSybt(String pSyouninSybt) {
        this.syouninSybt = pSyouninSybt;
        //        String naiyou = null;
        //        try {
        //            naiyou = BizAppCode.getCodeCnv(BizCodeName.sN_SYOUNINSYBT, String.valueOf(syouninSybt));
        //        } catch (Exception e) {
        //            new RuntimeException("想定外の承認種別が設定されました。 [pSyouninSybt=" + pSyouninSybt + "]");
        //        }
        //        setSyouninSybtNaiyou(naiyou);
    }

    //    public void setSyouninSybt(String pSyouninSybt) {
    //        if(!StringUtils.isNumeric(pSyouninSybt)){
    //            new RuntimeException("想定外の承認種別が設定されました。 [pSyouninSybt=" + pSyouninSybt + "]");
    //        }
    //        this.syouninSybt = Integer.valueOf(pSyouninSybt);
    //        String naiyou = null;
    //        try {
    //            naiyou = BizAppCode.getCodeCnv(BizCodeName.sN_SYOUNINSYBT, String.valueOf(syouninSybt));
    //        } catch (Exception e) {
    //            new RuntimeException("想定外の承認種別が設定されました。 [pSyouninSybt=" + syouninSybt + "]");
    //        }
    //        setSyouninSybtNaiyou(naiyou);
    //    }
    //
    //    public String getSoukinbiSijiFlg() {
    //        return soukinbiSijiFlg;
    //    }
    //
    //    public void setSoukinbiSijiFlg(String soukinbiSijiFlg) {
    //
    //                String naiyou = null;
    //                try {
    //                    naiyou = BizAppCode.getCodeCnv(BizCodeName.sN_TAISYOUKBN, soukinbiSijiFlg);
    //                } catch (Exception e) {
    //                    new RuntimeException("想定外の送金日指示フラグが指定されました。 [soukinbiSijiFlg=" + soukinbiSijiFlg + "]");
    //                }
    //                setSoukinbiSijiFlgNaiyou(naiyou);
    //
    //        this.soukinbiSijiFlg = soukinbiSijiFlg;
    //    }
    //
    //    public String getKekkaKbnNaiyou() {
    //        return kekkaKbnNaiyou;
    //    }
    //
    //    private void setKekkaKbnNaiyou(String pKekkaKbnNaiyou) {
    //        this.kekkaKbnNaiyou = pKekkaKbnNaiyou;
    //    }
    //
    //    public String getTensouSakiTskKbnNaiyou() {
    //        return tensouSakiTskKbnNaiyou;
    //    }
    //
    //    public void setTensouSakiTskKbnNaiyou(String pTensouSakiTskKbnNaiyou) {
    //        this.tensouSakiTskKbnNaiyou = pTensouSakiTskKbnNaiyou;
    //    }
    //
    //    public String getSyouninSybtNaiyou() {
    //        return syouninSybtNaiyou;
    //    }
    //
    //    public void setSyouninSybtNaiyou(String pSyouninSybtNaiyou) {
    //        this.syouninSybtNaiyou = pSyouninSybtNaiyou;
    //    }
    //
    //    public String getRiyouKbn() {
    //        return riyouKbn;
    //    }
    //
    //    public void setRiyouKbn(String pRiyouKbn) {
    //        this.riyouKbn = pRiyouKbn;
    //
    //    }
    //
    //    @Override
    //    public String toString() {
    //        return Objects.toStringHelper(this)
    //            .add("kekkaKbn", kekkaKbn)
    //            .add("tensouSakiTskKbn", tensouSakiTskKbn)
    //            .add("syouninSybt", syouninSybt)
    //            .add("riyouKbn", riyouKbn)
    //            .add("kekkaKbnNaiyou", kekkaKbnNaiyou)
    //            .add("tensouSakiTskKbnNaiyou", tensouSakiTskKbnNaiyou)
    //            .add("syouninSybtNaiyou", syouninSybtNaiyou)
    //            .add("riyouKbnNaiyou", riyouKbnNaiyou)
    //            .add("soukinbiSijiFlg", soukinbiSijiFlg)
    //            .add("soukinbiSijiFlgNaiyou", soukinbiSijiFlgNaiyou)
    //            .toString();
    //    }
    //
    //    public String getSoukinbiSijiFlgNaiyou() {
    //        return soukinbiSijiFlgNaiyou;
    //    }
    //
    //    public void setSoukinbiSijiFlgNaiyou(String soukinbiSijiFlgNaiyou) {
    //        this.soukinbiSijiFlgNaiyou = soukinbiSijiFlgNaiyou;
    //    }
}
