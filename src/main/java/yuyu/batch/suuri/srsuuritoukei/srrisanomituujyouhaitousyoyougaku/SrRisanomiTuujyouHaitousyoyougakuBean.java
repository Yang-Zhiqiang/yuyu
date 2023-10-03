package yuyu.batch.suuri.srsuuritoukei.srrisanomituujyouhaitousyoyougaku;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_ErrorKbn;

/**
 * 利差のみ配当所要額算出結果Beanクラス
 */
public class SrRisanomiTuujyouHaitousyoyougakuBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private int resultFlg;

    private C_ErrorKbn errorKbn;

    private BizCurrency tounendmtwrhrgkruikeigk;

    private BizCurrency warihurigakurisoku1;

    private BizCurrency warihurigakurisoku2;

    private BizCurrency yokunendosyoyougakuyou;

    private BizCurrency yokuyokunendosyoyougkyou;

    private BizCurrency yuukoutyuusyoyougaku;

    private BizCurrency syoumetuyousyoyougaku1;

    private BizCurrency syoumetuyousyoyougaku2;

    private BizCurrency dtaisyouv;

    private BizCurrency tenkanyousyoyougaku1;

    private BizCurrency tenkanyousyoyougaku2;

    private BizCurrency tnknyutuujyoudsyoyougk1;

    private BizCurrency tnknyutuujyoudsyoyougk2;

    private BizCurrency gaikayokunendosyoyougakuyou;

    private BizCurrency gaikayokuyokunendosyoyougkyou;

    private BizNumber dkeisankawaserate;

    private BizDate dkeisankawaseratetekiyouymd;

    public SrRisanomiTuujyouHaitousyoyougakuBean() {

    }

    public int isResultFlg() {
        return resultFlg;
    }

    public void setResultFlg(int pResultFlg) {
        this.resultFlg = pResultFlg;
    }

    public C_ErrorKbn getErrorKbn() {
        return errorKbn;
    }

    public void setErrorKbn(C_ErrorKbn pErrorKbn) {
        this.errorKbn = pErrorKbn;
    }

    public BizCurrency getTounendmtwrhrgkruikeigk() {
        return tounendmtwrhrgkruikeigk;
    }

    public void setTounendmtwrhrgkruikeigk(BizCurrency pTounendmtwrhrgkruikeigk) {
        this.tounendmtwrhrgkruikeigk = pTounendmtwrhrgkruikeigk;
    }

    public BizCurrency getWarihurigakurisoku1() {
        return warihurigakurisoku1;
    }

    public void setWarihurigakurisoku1(BizCurrency pWarihurigakurisoku1) {
        this.warihurigakurisoku1 = pWarihurigakurisoku1;
    }

    public BizCurrency getWarihurigakurisoku2() {
        return warihurigakurisoku2;
    }

    public void setWarihurigakurisoku2(BizCurrency pWarihurigakurisoku2) {
        this.warihurigakurisoku2 = pWarihurigakurisoku2;
    }

    public BizCurrency getYokunendosyoyougakuyou() {
        return yokunendosyoyougakuyou;
    }

    public void setYokunendosyoyougakuyou(BizCurrency pYokunendosyoyougakuyou) {
        this.yokunendosyoyougakuyou = pYokunendosyoyougakuyou;
    }

    public BizCurrency getYokuyokunendosyoyougkyou() {
        return yokuyokunendosyoyougkyou;
    }

    public void setYokuyokunendosyoyougkyou(BizCurrency pYokuyokunendosyoyougkyou) {
        this.yokuyokunendosyoyougkyou = pYokuyokunendosyoyougkyou;
    }

    public BizCurrency getYuukoutyuusyoyougaku() {
        return yuukoutyuusyoyougaku;
    }

    public void setYuukoutyuusyoyougaku(BizCurrency pYuukoutyuusyoyougaku) {
        this.yuukoutyuusyoyougaku = pYuukoutyuusyoyougaku;
    }

    public BizCurrency getSyoumetuyousyoyougaku1() {
        return syoumetuyousyoyougaku1;
    }

    public void setSyoumetuyousyoyougaku1(BizCurrency pSyoumetuyousyoyougaku1) {
        this.syoumetuyousyoyougaku1 = pSyoumetuyousyoyougaku1;
    }

    public BizCurrency getSyoumetuyousyoyougaku2() {
        return syoumetuyousyoyougaku2;
    }

    public void setSyoumetuyousyoyougaku2(BizCurrency pSyoumetuyousyoyougaku2) {
        this.syoumetuyousyoyougaku2 = pSyoumetuyousyoyougaku2;
    }

    public BizCurrency getDtaisyouv() {
        return dtaisyouv;
    }

    public void setDtaisyouv(BizCurrency pDtaisyouv) {
        this.dtaisyouv = pDtaisyouv;
    }

    public BizCurrency getTenkanyousyoyougaku1() {
        return tenkanyousyoyougaku1;
    }

    public void setTenkanyousyoyougaku1(BizCurrency pTenkanyousyoyougaku1) {
        this.tenkanyousyoyougaku1 = pTenkanyousyoyougaku1;
    }

    public BizCurrency getTenkanyousyoyougaku2() {
        return tenkanyousyoyougaku2;
    }

    public void setTenkanyousyoyougaku2(BizCurrency pTenkanyousyoyougaku2) {
        this.tenkanyousyoyougaku2 = pTenkanyousyoyougaku2;
    }

    public BizCurrency getTnknyutuujyoudsyoyougk1() {
        return tnknyutuujyoudsyoyougk1;
    }

    public void setTnknyutuujyoudsyoyougk1(BizCurrency pTnknyutuujyoudsyoyougk1) {
        this.tnknyutuujyoudsyoyougk1 = pTnknyutuujyoudsyoyougk1;
    }

    public BizCurrency getTnknyutuujyoudsyoyougk2() {
        return tnknyutuujyoudsyoyougk2;
    }

    public void setTnknyutuujyoudsyoyougk2(BizCurrency pTnknyutuujyoudsyoyougk2) {
        this.tnknyutuujyoudsyoyougk2 = pTnknyutuujyoudsyoyougk2;
    }

    public BizCurrency getGaikayokunendosyoyougakuyou() {
        return gaikayokunendosyoyougakuyou;
    }

    public void setGaikayokunendosyoyougakuyou(BizCurrency pGaikayokunendosyoyougakuyou) {
        this.gaikayokunendosyoyougakuyou = pGaikayokunendosyoyougakuyou;
    }

    public BizCurrency getGaikayokuyokunendosyoyougkyou() {
        return gaikayokuyokunendosyoyougkyou;
    }

    public void setGaikayokuyokunendosyoyougkyou(BizCurrency pGaikayokuyokunendosyoyougkyou) {
        this.gaikayokuyokunendosyoyougkyou = pGaikayokuyokunendosyoyougkyou;
    }

    public BizNumber getDkeisankawaserate() {
        return dkeisankawaserate;
    }

    public void setDkeisankawaserate(BizNumber pDkeisankawaserate) {
        this.dkeisankawaserate = pDkeisankawaserate;
    }

    public BizDate getDkeisankawaseratetekiyouymd() {
        return dkeisankawaseratetekiyouymd;
    }

    public void setDkeisankawaseratetekiyouymd(BizDate pDkeisankawaseratetekiyouymd) {
        this.dkeisankawaseratetekiyouymd = pDkeisankawaseratetekiyouymd;
    }
}