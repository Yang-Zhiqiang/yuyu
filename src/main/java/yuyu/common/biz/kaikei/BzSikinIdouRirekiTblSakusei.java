package yuyu.common.biz.kaikei;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.db.EntityInserter;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.SaibanBiz;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_Delflag;
import yuyu.def.db.entity.BT_SikinIdouRireki;

/**
 * 業務共通 経理・会計 資金移動用履歴テーブル作成
 */
public class BzSikinIdouRirekiTblSakusei {

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private static Logger logger;

    public BzSikinIdouRirekiTblSakusei() {
        super();
    }

    public BT_SikinIdouRireki editSikinIdouRirekiTblEntity(SikinIdouRirekiDataBean pSikinIdouRirekiDataBean) {

        logger.debug("▽ 資金移動用履歴テーブル作成 開始");

        BT_SikinIdouRireki sikinIdouRireki = new BT_SikinIdouRireki();

        sikinIdouRireki.setSyoriYmd(pSikinIdouRirekiDataBean.getSyoriYmd());
        sikinIdouRireki.setKeirisyorirenno("");
        sikinIdouRireki.setSyono(pSikinIdouRirekiDataBean.getSyono());
        sikinIdouRireki.setHenkousikibetukey(pSikinIdouRirekiDataBean.getHenkouSikibetuKey());
        sikinIdouRireki.setTargetKinouId(pSikinIdouRirekiDataBean.getTargetKinouId());
        sikinIdouRireki.setSkno(pSikinIdouRirekiDataBean.getSkno());
        sikinIdouRireki.setSeikyuurirekino(pSikinIdouRirekiDataBean.getSeikyuuRirekiNo());
        sikinIdouRireki.setSakujyoflg(C_Delflag.BLNK);
        sikinIdouRireki.setNykshrkbn(pSikinIdouRirekiDataBean.getNykshrKbn());
        sikinIdouRireki.setSyoricd(pSikinIdouRirekiDataBean.getSyoricd());
        sikinIdouRireki.setDensyskbn(pSikinIdouRirekiDataBean.getDensysKbn());
        sikinIdouRireki.setDenrenno(pSikinIdouRirekiDataBean.getDenrenno());
        sikinIdouRireki.setSeg1cd(pSikinIdouRirekiDataBean.getSeg1cd());
        sikinIdouRireki.setKyktuukasyu(pSikinIdouRirekiDataBean.getKykTuukasyu());
        sikinIdouRireki.setSyutkkbn(pSikinIdouRirekiDataBean.getSyutkKbn());
        sikinIdouRireki.setHrkkaisuu(pSikinIdouRirekiDataBean.getHrkkaisuu());
        sikinIdouRireki.setSyouhncd(pSikinIdouRirekiDataBean.getSyouhnCd());
        sikinIdouRireki.setSyouhnsdno(pSikinIdouRirekiDataBean.getSyouhnSdno());
        sikinIdouRireki.setKyksyouhnrenno(pSikinIdouRirekiDataBean.getKykSyouhnRenno());
        sikinIdouRireki.setShrhousiteikbn(pSikinIdouRirekiDataBean.getShrhousiteiKbn());
        sikinIdouRireki.setPhendoukaisiym(pSikinIdouRirekiDataBean.getPhendouKaisiYm());
        sikinIdouRireki.setPhendoumaegk(pSikinIdouRirekiDataBean.getPhendoumaeGk());
        sikinIdouRireki.setPhendougogk(pSikinIdouRirekiDataBean.getPhendougoGk());
        sikinIdouRireki.setKykymd(pSikinIdouRirekiDataBean.getKykYmd());
        sikinIdouRireki.setSeirituymd(pSikinIdouRirekiDataBean.getSeirituYmd());
        sikinIdouRireki.setSyoumetuymd(pSikinIdouRirekiDataBean.getSyoumetuYmd());
        sikinIdouRireki.setMisyuupjyuutouym(pSikinIdouRirekiDataBean.getMisyuupJyuutouYm());
        sikinIdouRireki.setShrsyorikbn(pSikinIdouRirekiDataBean.getShrsyoriKbn());
        sikinIdouRireki.setSeikyuusyubetu(pSikinIdouRirekiDataBean.getSeikyuuSyubetu());
        sikinIdouRireki.setSyoumetujiyuu(pSikinIdouRirekiDataBean.getSyoumetuJiyuu());
        sikinIdouRireki.setJkipjytym(pSikinIdouRirekiDataBean.getJkipjytYm());
        sikinIdouRireki.setJyutoustartym(pSikinIdouRirekiDataBean.getJyutouStartYm());
        sikinIdouRireki.setJyutouendym(pSikinIdouRirekiDataBean.getJyutouEndYm());
        sikinIdouRireki.setNykkeiro(pSikinIdouRirekiDataBean.getNykkeiro());
        sikinIdouRireki.setNyknaiyoukbn(pSikinIdouRirekiDataBean.getNyknaiyouKbn());
        sikinIdouRireki.setNyktrksflg(pSikinIdouRirekiDataBean.getNyktrksFlg());
        sikinIdouRireki.setHrkp(pSikinIdouRirekiDataBean.getHrkp());
        sikinIdouRireki.setHokenryou(pSikinIdouRirekiDataBean.getHokenryou());

        BizPropertyInitializer.initialize(sikinIdouRireki);

        logger.debug("△ 資金移動用履歴テーブル作成 終了");

        return sikinIdouRireki;
    }

    public void insertSikinIdouRirekiTblOne(BT_SikinIdouRireki pSikinIdouRireki) {

        logger.debug("▽ 資金移動用履歴テーブル作成 開始");

        String keiriSyoriRenno = SaibanBiz.getKeirisyoriRenNo(pSikinIdouRireki.getSyoriYmd().toString());

        pSikinIdouRireki.setKeirisyorirenno(keiriSyoriRenno);

        bizDomManager.insert(pSikinIdouRireki);

        logger.debug("△ 資金移動用履歴テーブル作成 終了");
    }

    public void insertSikinIdouRirekiTblMany(List<BT_SikinIdouRireki> pSikinIdouRirekiLst) {

        logger.debug("▽ 資金移動用履歴テーブル作成 開始");

        String keiriSyoriRenno = null;

        try (EntityInserter<BT_SikinIdouRireki> entityInserterSikinIdouRireki = new EntityInserter<>()){

            for (BT_SikinIdouRireki sikinIdouRireki : pSikinIdouRirekiLst) {

                keiriSyoriRenno = SaibanBiz.getKeirisyoriRenNo(sikinIdouRireki.getSyoriYmd().toString());
                sikinIdouRireki.setKeirisyorirenno(keiriSyoriRenno);

                entityInserterSikinIdouRireki.add(sikinIdouRireki);
            }
        }

        logger.debug("△ 資金移動用履歴テーブル作成 終了");
    }
}