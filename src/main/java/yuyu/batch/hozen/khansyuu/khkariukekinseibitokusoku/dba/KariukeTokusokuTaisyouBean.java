package yuyu.batch.hozen.khansyuu.khkariukekinseibitokusoku.dba;

import java.io.Serializable;
import java.math.BigDecimal;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.BizCurrencySum;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_KrkriyuuKbn;
import yuyu.def.classification.C_Krkseisanzumiflg;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;

/**
 * 仮受金整備督促対象Beanクラスです。<br />
 * @author  楊　飛
 * @version 2016/12/27 楊　飛 : 新規作成<br />
 *          2017/03/22 王　京浩：S社ナポレオン先行１次追加対応<br />
 *          2018/11/22 何　俊峰: 2019年3月25日対応
 */
public class KariukeTokusokuTaisyouBean implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** 証券番号 */
    @Getter
    @Setter
    private String syono;

    /** 区分キー */
    @Getter
    @Setter
    private String kbnkey;

    /** 仮受番号 */
    @Getter
    @Setter
    private Integer krkno;

    /** 仮受計上処理日 */
    @Getter
    @Setter
    private BizDate krkkeijyoymd;

    /** 仮受金額 */
    @Getter
    @Setter
    private BizCurrency krkgk;

    /** 発生伝票日付 */
    @Getter
    @Setter
    private BizDate hasseidenymd;

    /** 精算伝票日付 */
    @Getter
    @Setter
    private BizDate seisandenymd;

    /** 仮受精算済フラグ */
    @Getter
    @Setter
    private C_Krkseisanzumiflg krkseisanzumiflg;

    /** 仮受理由区分 */
    @Getter
    @Setter
    private C_KrkriyuuKbn krkriyuukbn;

    /** 入金内容区分 */
    @Getter
    @Setter
    private C_NyknaiyouKbn nyknaiyoukbn;

    /** 入金経路 */
    @Getter
    @Setter
    private C_Nykkeiro nykkeiro;

    /** 充当年月 */
    @Getter
    @Setter
    private BizDateYM jyuutouym;

    /** 充当回数（年） */
    @Getter
    @Setter
    private Integer jyutoukaisuuy;

    /** 充当回数（月） */
    @Getter
    @Setter
    private Integer jyutoukaisuum;

    /** 領収日 */
    @Getter
    @Setter
    private BizDate ryosyuymd;

    /** 払込回数 */
    @Getter
    @Setter
    private C_Hrkkaisuu hrkkaisuu;

    /**
     * Beanに詰め替え用のコンストラクタ
     * @param pSyono 証券番号
     * @param pKbnkey 区分キー
     * @param pKrkno 仮受番号
     * @param pKrkkeijyoymd 仮受計上処理日
     * @param pTypefieldname 仮受金額の通貨単位フィールド名
     * @param pValuefieldname 仮受金額の金額フィールド名
     * @param pHasseidenymd 発生伝票日付
     * @param pSeisandenymd 精算伝票日付
     * @param pKrkseisanzumiflg 仮受精算済フラグ
     * @param pKrkriyuukbn 仮受理由区分
     * @param pNyknaiyoukbn 入金内容区分
     * @param pNykkeiro 入金経路
     * @param pJyuutouym 充当年月
     * @param pJyutoukaisuuy 充当回数（年）
     * @param pJyutoukaisuum 充当回数（月）
     * @param pRyosyuymd 領収日
     * @param pHrkkaisuu 払込回数
     */
    public KariukeTokusokuTaisyouBean(String pSyono,
        String pKbnkey,
        Integer pKrkno,
        BizDate pKrkkeijyoymd,
        String pTypefieldname,
        BigDecimal pValuefieldname,
        BizDate pHasseidenymd,
        BizDate pSeisandenymd,
        C_Krkseisanzumiflg pKrkseisanzumiflg,
        C_KrkriyuuKbn pKrkriyuukbn,
        C_NyknaiyouKbn pNyknaiyoukbn,
        C_Nykkeiro pNykkeiro,
        BizDateYM pJyuutouym,
        Integer pJyutoukaisuuy,
        Integer pJyutoukaisuum,
        BizDate pRyosyuymd,
        C_Hrkkaisuu pHrkkaisuu) {

        syono = pSyono;
        kbnkey = pKbnkey;
        krkno = pKrkno;
        krkkeijyoymd = pKrkkeijyoymd;
        krkgk = new BizCurrencySum(pTypefieldname, pValuefieldname).toBizCurrency();
        hasseidenymd = pHasseidenymd;
        seisandenymd = pSeisandenymd;
        krkseisanzumiflg = pKrkseisanzumiflg;
        krkriyuukbn = pKrkriyuukbn;
        nyknaiyoukbn = pNyknaiyoukbn;
        nykkeiro = pNykkeiro;
        jyuutouym = pJyuutouym;
        jyutoukaisuuy = pJyutoukaisuuy;
        jyutoukaisuum = pJyutoukaisuum;
        ryosyuymd = pRyosyuymd;
        hrkkaisuu = pHrkkaisuu;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}
