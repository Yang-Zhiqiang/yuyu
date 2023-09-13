package yuyu.def.hozen.result.bean;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.EntityContainer;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_AisyoumeiKbn;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_InsizeiShryouhiKbn;
import yuyu.def.classification.C_SinsaihkKbn;
import yuyu.def.classification.C_SyoukensaihkKbn;
import yuyu.def.classification.C_TantouCdKbn;
import yuyu.def.classification.C_TokusyuSyoriNaiyouKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IT_HhknSya;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSya;

/**
 * 証券作成契約明細リスト情報Beanクラスです。<br />
 */
@AllArgsConstructor
public class SyoukenSkseiKyMeisaiListInfosByKakutyoujobcdItemsBean implements Serializable,EntityContainer {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private String syono;

    @Getter @Setter
    private BizDate tyouhyouymd;

    @Getter @Setter
    private C_SinsaihkKbn sinsaihkkbn;

    @Getter @Setter
    private C_SyoukensaihkKbn syoukensaihkkbn;

    @Getter @Setter
    private C_InsizeiShryouhiKbn insizeishryouhikbn;

    @Getter @Setter
    private C_HassouKbn hassoukbn;

    @Getter @Setter
    private C_UmuKbn koujyosyoumeiumukbn;

    @Getter @Setter
    private C_UmuKbn suiihyouumukbn;

    @Getter @Setter
    private C_UmuKbn kanryoutuutiumukbn;

    @Getter @Setter
    private C_UmuKbn stdrsktirasidouhuukbn;

    @Getter @Setter
    private C_UmuKbn dstirasidouhuukbn;

    @Getter @Setter
    private C_AisyoumeiKbn aisyoumeikbn;

    @Getter @Setter
    private String hknsyukigou;

    @Getter @Setter
    private C_TokusyuSyoriNaiyouKbn tokusyusyorinaiyoukbn1;

    @Getter @Setter
    private C_TokusyuSyoriNaiyouKbn tokusyusyorinaiyoukbn2;

    @Getter @Setter
    private C_TokusyuSyoriNaiyouKbn tokusyusyorinaiyoukbn3;

    @Getter @Setter
    private C_TokusyuSyoriNaiyouKbn tokusyusyorinaiyoukbn4;

    @Getter @Setter
    private C_TokusyuSyoriNaiyouKbn tokusyusyorinaiyoukbn5;

    @Getter @Setter
    private C_TokusyuSyoriNaiyouKbn tokusyusyorinaiyoukbn6;

    @Getter @Setter
    private C_TokusyuSyoriNaiyouKbn tokusyusyorinaiyoukbn7;

    @Getter @Setter
    private C_TokusyuSyoriNaiyouKbn tokusyusyorinaiyoukbn8;

    @Getter @Setter
    private C_TokusyuSyoriNaiyouKbn tokusyusyorinaiyoukbn9;

    @Getter @Setter
    private C_TokusyuSyoriNaiyouKbn tokusyusyorinaiyoukbn10;

    @Getter @Setter
    private C_TokusyuSyoriNaiyouKbn tokusyusyorinaiyoukbn11;

    @Getter @Setter
    private C_TokusyuSyoriNaiyouKbn tokusyusyorinaiyoukbn12;

    @Getter @Setter
    private C_TokusyuSyoriNaiyouKbn tokusyusyorinaiyoukbn13;

    @Getter @Setter
    private C_TokusyuSyoriNaiyouKbn tokusyusyorinaiyoukbn14;

    @Getter @Setter
    private C_TokusyuSyoriNaiyouKbn tokusyusyorinaiyoukbn15;

    @Getter @Setter
    private C_TokusyuSyoriNaiyouKbn tokusyusyorinaiyoukbn16;

    @Getter @Setter
    private C_TokusyuSyoriNaiyouKbn tokusyusyorinaiyoukbn17;

    @Getter @Setter
    private String gyoumuKousinKinou;

    @Getter @Setter
    private String gyoumuKousinsyaId;

    @Getter @Setter
    private C_TantouCdKbn tantocd;

    @Getter @Setter
    private String yakkanbunsyono;

    @Getter @Setter
    private IT_KykKihon iT_KykKihon;

    @Getter @Setter
    private IT_KykSya iT_KykSya;

    @Getter @Setter
    private IT_HhknSya iT_HhknSya;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}
