package yuyu.def.sinkeiyaku.result.bean;

import java.io.Serializable;

import jp.co.slcs.swak.db.EntityContainer;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.db.entity.BM_Dairiten;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.HM_SkHubiKoumoku;
import yuyu.def.db.entity.HM_SkHubiNaiyou;
import yuyu.def.db.entity.HM_SkSeibiSijiNaiyou;
import yuyu.def.db.entity.HT_MosDairiten;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_MosSyouhn;
import yuyu.def.db.entity.HT_SkHubi;
import yuyu.def.db.entity.HT_SkHubiDetail;
import yuyu.def.db.entity.HT_SyoriCTL;

/**
 * 新契約不備分析情報Beanクラスです。<br />
 */
@AllArgsConstructor
public class SkhubibunsekiInfosBean implements Serializable, EntityContainer {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private HT_SyoriCTL syoriCTL;

    @Getter @Setter
    private HT_MosKihon mosKihon;

    @Getter @Setter
    private HT_MosDairiten mosDairiten;

    @Getter @Setter
    private HT_SkHubi skHubi;

    @Getter @Setter
    private BM_Dairiten dairiten;

    @Getter @Setter
    private HT_SkHubiDetail skHubiDetail;

    @Getter @Setter
    private HM_SkHubiNaiyou skHubiNaiyou;

    @Getter @Setter
    private HM_SkHubiKoumoku skHubiKoumoku;

    @Getter @Setter
    private HM_SkSeibiSijiNaiyou skSeibiSijiNaiyou;

    @Getter @Setter
    private HT_MosSyouhn mosSyouhn;

    @Getter @Setter
    private BM_SyouhnZokusei syouhnZokusei;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
