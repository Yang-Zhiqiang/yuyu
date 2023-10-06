package yuyu.batch.biz.bzkaikei.bzsikinidoulistdatasks;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.kaikei.BzSegmentCdSyutoku;
import yuyu.common.biz.kaikei.SyouhinbetuSegmentBean;
import yuyu.def.MessageId;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_DensysKbn;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_SikinIdouKbn;
import yuyu.def.classification.C_SikinidougroupKbn;
import yuyu.def.classification.C_SikinidoumeisaiKbn;
import yuyu.def.classification.C_TaisyakuKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.db.entity.BM_SikinIdouGroup;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.BT_DenpyoData;
import yuyu.def.db.entity.BT_SikinIdouListSks;

import com.google.common.collect.Lists;

/**
 * 業務共通 経理･会計 伝票仕訳情報BEAN
 */
public class DenpyouSiwakeInfoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private BizDomManager bizDomManager;

    private BizDate syoriYmd;

    private C_DensysKbn denSysKbn;

    private String denRenno;

    private List<BT_DenpyoData> kariDenpyoDataLst;

    private List<BT_DenpyoData> kasiDenpyoDataLst;

    private final String SYORICD_BATCH_KAIYAKU = "RBA2";

    public DenpyouSiwakeInfoBean() {
        kariDenpyoDataLst = Lists.newArrayList();
        kasiDenpyoDataLst = Lists.newArrayList();
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

    public void addDenpyouData(BT_DenpyoData pDenpyoData) {
        if (C_TaisyakuKbn.KARIKATA.eq(pDenpyoData.getTaisyakukbn())) {
            kariDenpyoDataLst.add(pDenpyoData);
        }
        else if (C_TaisyakuKbn.KASIKATA.eq(pDenpyoData.getTaisyakukbn())) {
            kasiDenpyoDataLst.add(pDenpyoData);
        }
    }

    public List<BT_SikinIdouListSks> editSikinIdouListData() {
        List<BT_SikinIdouListSks> sikinIdouListSksLst = Lists.newArrayList();
        BT_SikinIdouListSks sikinIdouListSks = null;

        for (BT_DenpyoData denpyoData : kariDenpyoDataLst) {

            if (denpyoData.getKeiyakutuukagk().compareTo(BizCurrency.valueOf(0,
                denpyoData.getKeiyakutuukagk().getType())) != 0) {

                C_SikinidougroupKbn sikinidougroupKbn;
                C_Tuukasyu shrTuukasyu;
                C_SikinidoumeisaiKbn sikinidoumeisaiKbn;

                BzSegmentCdSyutoku bzSegmentCdSyutoku = SWAKInjector.getInstance(BzSegmentCdSyutoku.class);
                SyouhinbetuSegmentBean syouhinbetuSegmentBean = bzSegmentCdSyutoku.exec(denpyoData.getSyusyouhncd(), denpyoData.getKyktuukasyu());

               if (syouhinbetuSegmentBean.getErrorKbn().eq(C_ErrorKbn.ERROR)) {
                  throw new BizAppException(MessageUtil.getMessage(MessageId.EBA0048));
                }
                	
                C_Segcd segcd1 = syouhinbetuSegmentBean.getSegcd1();

                BM_SikinIdouGroup sikinIdouGroup = bizDomManager.getSikinIdouGroup(segcd1);

                if (sikinIdouGroup == null) {
                    sikinidougroupKbn = C_SikinidougroupKbn.BLNK;
                }
                else {
                    sikinidougroupKbn = sikinIdouGroup.getSikinidougroupkbn();
                }

                shrTuukasyu = denpyoData.getTuukasyu();

                if (SYORICD_BATCH_KAIYAKU.equals(denpyoData.getSyoricd())) {
                    sikinidoumeisaiKbn = C_SikinidoumeisaiKbn.DSKAIYAKU;
                }
                else {
                    sikinidoumeisaiKbn = C_SikinidoumeisaiKbn.BLNK;
                }

                sikinIdouListSks = new BT_SikinIdouListSks();

                sikinIdouListSks.setDensyskbn(denpyoData.getDensyskbn());
                sikinIdouListSks.setDenrenno(denpyoData.getDenrenno());
                sikinIdouListSks.setEdano(denpyoData.getEdano());
                sikinIdouListSks.setSyoriYmd(syoriYmd);
                sikinIdouListSks.setTyakkinymd(denpyoData.getDenymd());
                sikinIdouListSks.setSeg1cd(segcd1);
                sikinIdouListSks.setKyktuukasyu(denpyoData.getKyktuukasyu());
                sikinIdouListSks.setKeiyakutuukagk(denpyoData.getKeiyakutuukagk());
                sikinIdouListSks.setShrtuukasyu(shrTuukasyu);

                if (C_Tuukasyu.JPY.eq(shrTuukasyu)) {
                    sikinIdouListSks.setSiharaituukagk(denpyoData.getDenyenkagk());
                }
                else {
                    sikinIdouListSks.setSiharaituukagk(denpyoData.getDengaikagk());
                }

                sikinIdouListSks.setSikinidoukbn(C_SikinIdouKbn.BLNK);
                sikinIdouListSks.setSikinidougroupkbn(sikinidougroupKbn);
                sikinIdouListSks.setSikinidoumeisaikbn(sikinidoumeisaiKbn);

                BizPropertyInitializer.initialize(sikinIdouListSks);

                sikinIdouListSksLst.add(sikinIdouListSks);
            }
        }

        return sikinIdouListSksLst;
    }

    public void clear() {
        kariDenpyoDataLst.clear();
        kasiDenpyoDataLst.clear();
    }
}