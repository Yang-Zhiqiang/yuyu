package yuyu.batch.biz.bzkaikei.bzsikinidoulistdataskshijynbrshr;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import yuyu.batch.biz.bzkaikei.bzsikinidoulistdataskshijynbrshr.dba.SikinIdouListDataHijynbrShrBean;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.kaikei.BzSegmentCdSyutoku;
import yuyu.common.biz.kaikei.SyouhinbetuSegmentBean;
import yuyu.def.MessageId;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_DensysKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_SikinIdouKbn;
import yuyu.def.classification.C_SikinidougroupKbn;
import yuyu.def.classification.C_SikinidoumeisaiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BM_SikinIdouGroup;
import yuyu.def.db.entity.BT_SikinIdouListSks;

import com.google.common.collect.Lists;

/**
 * 業務共通 経理･会計 平準払支払用伝票仕訳情報BEAN
 */
public class HeijyunShrkInfoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final String SYORICD_BATCH_KAIYAKU = "RBA2";

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private AS_Kinou kinou;

    private BizDate syoriYmd;

    private C_DensysKbn denSysKbn;

    private String denRenno;

    private List<SikinIdouListDataHijynbrShrBean> sikinIdouListDataHijynbrShrBeanLst;

    private String syono;

    public HeijyunShrkInfoBean() {
        sikinIdouListDataHijynbrShrBeanLst = Lists.newArrayList();
    }

    public BizDate getSyoriYmd() {
        return syoriYmd;
    }

    public void setSyoriYmd(BizDate pSyoriYmd) {
        this.syoriYmd = pSyoriYmd;
    }

    public C_DensysKbn getDenSysKbn() {
        return denSysKbn;
    }

    public void setDenSysKbn(C_DensysKbn pDenSysKbn) {
        this.denSysKbn = pDenSysKbn;
    }

    public String getDenRenno() {
        return denRenno;
    }

    public void setDenRenno(String pDenRenno) {
        this.denRenno = pDenRenno;
    }

    public String getSyono() {
        return syono;
    }

    public void setSyono(String pSyono) {
        this.syono = pSyono;
    }

    protected void addDenpyouData(SikinIdouListDataHijynbrShrBean pSikinIdouListDataHijynbrShrBean) {

        sikinIdouListDataHijynbrShrBeanLst.add(pSikinIdouListDataHijynbrShrBean);
    }

    protected List<BT_SikinIdouListSks> editSikinIdouListData() {
        List<BT_SikinIdouListSks> sikinIdouListSksLst = Lists.newArrayList();

        for (SikinIdouListDataHijynbrShrBean sikinIdouListDataHijynbrShrBean : sikinIdouListDataHijynbrShrBeanLst) {

            C_SikinidougroupKbn sikinidougroupKbn;
            C_SikinidoumeisaiKbn sikinidoumeisaiKbn;
            C_Segcd seg1cd;

            BzSegmentCdSyutoku bzSegmentCdSyutoku = SWAKInjector.getInstance(BzSegmentCdSyutoku.class);

            SyouhinbetuSegmentBean syouhinbetuSegmentBean = bzSegmentCdSyutoku.exec(
                sikinIdouListDataHijynbrShrBean.getSyusyouhncd(), sikinIdouListDataHijynbrShrBean.getKyktuukasyu());

            if (C_ErrorKbn.ERROR.eq(syouhinbetuSegmentBean.getErrorKbn())) {
                throw new BizLogicException(MessageId.EBA0048, kinou.getKinouNm());
            }

            seg1cd = syouhinbetuSegmentBean.getSegcd1();

            BM_SikinIdouGroup sikinIdouGroup = bizDomManager.getSikinIdouGroup(seg1cd);

            if (sikinIdouGroup == null) {
                sikinidougroupKbn = C_SikinidougroupKbn.BLNK;
            }
            else {
                sikinidougroupKbn = sikinIdouGroup.getSikinidougroupkbn();
            }

            if (SYORICD_BATCH_KAIYAKU.equals(sikinIdouListDataHijynbrShrBean.getSyoricd())) {
                sikinidoumeisaiKbn = C_SikinidoumeisaiKbn.DSKAIYAKU;
            }
            else {
                sikinidoumeisaiKbn = C_SikinidoumeisaiKbn.BLNK;
            }

            BT_SikinIdouListSks sikinIdouListSks = new BT_SikinIdouListSks();
            sikinIdouListSks.setDensyskbn(sikinIdouListDataHijynbrShrBean.getDensyskbn());
            sikinIdouListSks.setDenrenno(sikinIdouListDataHijynbrShrBean.getDenrenno());
            sikinIdouListSks.setEdano(sikinIdouListDataHijynbrShrBean.getEdano());
            sikinIdouListSks.setSyoriYmd(syoriYmd);
            sikinIdouListSks.setTyakkinymd(sikinIdouListDataHijynbrShrBean.getDenymd());
            sikinIdouListSks.setSeg1cd(seg1cd);
            sikinIdouListSks.setKyktuukasyu(sikinIdouListDataHijynbrShrBean.getKyktuukasyu());
            sikinIdouListSks.setKeiyakutuukagk(sikinIdouListDataHijynbrShrBean.getHijynbrsikinidougk());
            sikinIdouListSks.setShrtuukasyu(sikinIdouListDataHijynbrShrBean.getTuukasyu());

            if (C_Tuukasyu.JPY.eq(sikinIdouListDataHijynbrShrBean.getTuukasyu())) {
                sikinIdouListSks.setSiharaituukagk(sikinIdouListDataHijynbrShrBean.getDenyenkagk());
            }
            else {
                sikinIdouListSks.setSiharaituukagk(sikinIdouListDataHijynbrShrBean.getDengaikagk());
            }

            sikinIdouListSks.setSikinidoukbn(C_SikinIdouKbn.BLNK);
            sikinIdouListSks.setSikinidougroupkbn(sikinidougroupKbn);
            sikinIdouListSks.setSikinidoumeisaikbn(sikinidoumeisaiKbn);
            BizPropertyInitializer.initialize(sikinIdouListSks);
            sikinIdouListSksLst.add(sikinIdouListSks);
        }
        return sikinIdouListSksLst;
    }

    protected void clear() {
        sikinIdouListDataHijynbrShrBeanLst.clear();
    }
}
