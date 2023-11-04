package yuyu.app.base.system.tokuteibikadoutimetouroku;

import static yuyu.app.base.system.tokuteibikadoutimetouroku.SeleniumTokuteibiKadouTimeTourokuConstants.*;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateConfig;
import jp.co.slcs.swak.date.SeirekiWarekiKbn;
import yuyu.common.base.format.ReportBizDateFormatUtil;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.classification.C_EigyoubiKbn;
import yuyu.def.classification.C_KadouTimeSiteiKbn;
import yuyu.def.classification.C_KadouTimeYoubiKbn;
import yuyu.def.db.entity.AT_KadouTime;
import yuyu.def.db.entity.AT_KadouTimeGroup;
import yuyu.def.db.entity.AT_TokuteibiKadouTime;

public class SeleniumTokuteibiKadouTimeTourokuDB {

    @Inject
    private BaseDomManager baseDomManager;

    @Transactional
    public void createTestB0003_01(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null == kadouTimeGroup ) {
            kadouTimeGroup = new AT_KadouTimeGroup();
            kadouTimeGroup.setKadouTimeGroupCd(ALREADYKADOUTIMEGROUPCD);
            kadouTimeGroup.setKadouTimeGroupNm(ALREADYKADOUTIMEGROUPNM);
            kadouTimeGroup.setHolidayGroupCd(ALREADYKADOUTIMEGROUP_HOLIDAYGROUPCD);
            kadouTimeGroup.setKadouTimeGroupDescription(ALREADYKADOUTIMEGROUPBIKOU);

            baseDomManager.insert(kadouTimeGroup);
        }
    }

    @Transactional
    public void createTestB0003_02(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {

            C_KadouTimeYoubiKbn[] kadouTimeYoubiKbns = {C_KadouTimeYoubiKbn.GETUYOU, C_KadouTimeYoubiKbn.KAYOU, C_KadouTimeYoubiKbn.SUIYOU
                , C_KadouTimeYoubiKbn.MOKUYOU, C_KadouTimeYoubiKbn.KINYOU, C_KadouTimeYoubiKbn.DOYOU, C_KadouTimeYoubiKbn.NITIYOU, C_KadouTimeYoubiKbn.HYOUJYUN};
            C_EigyoubiKbn[] eigyoubiKbns = {C_EigyoubiKbn.EIGYOUBI, C_EigyoubiKbn.HIEIGYOUBI};

            for( C_EigyoubiKbn eigyoubiKbn : eigyoubiKbns ) {
                AT_KadouTime kadouTime = null;
                for ( C_KadouTimeYoubiKbn youbiKbn : kadouTimeYoubiKbns ) {

                    kadouTime = kadouTimeGroup.getKadouTime(youbiKbn, eigyoubiKbn);
                    if ( null == kadouTime ) {

                        kadouTime = kadouTimeGroup.createKadouTime();
                        kadouTime.setEigyoubiKbn(eigyoubiKbn);
                        kadouTime.setKadouTimeYoubiKbn(youbiKbn);
                        kadouTime.setKadouTimeSiteiKbn(C_KadouTimeSiteiKbn.HYOUJUN);
                        if( C_KadouTimeYoubiKbn.HYOUJYUN.eq(youbiKbn) ) {
                            kadouTime.setKadouTimeSiteiKbn(C_KadouTimeSiteiKbn.ZENJITURIYOU_KA);
                        }
                    }

                    baseDomManager.update(kadouTimeGroup);
                }
            }
        }
    }

    @Transactional
    public void deleteTestB0003_01(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {
            kadouTimeGroup.getKadouTimes().removeAll(kadouTimeGroup.getKadouTimes());
            kadouTimeGroup.getTokuteibiKadouTimes().removeAll(kadouTimeGroup.getTokuteibiKadouTimes());

            baseDomManager.update(kadouTimeGroup);
            baseDomManager.delete(kadouTimeGroup);
        }
    }

    @Transactional
    public void createTestB0005_01(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null == kadouTimeGroup ) {
            kadouTimeGroup = new AT_KadouTimeGroup();
            kadouTimeGroup.setKadouTimeGroupCd(ALREADYKADOUTIMEGROUPCD);
            kadouTimeGroup.setKadouTimeGroupNm(ALREADYKADOUTIMEGROUPNM);
            kadouTimeGroup.setHolidayGroupCd(ALREADYKADOUTIMEGROUP_HOLIDAYGROUPCD);
            kadouTimeGroup.setKadouTimeGroupDescription(ALREADYKADOUTIMEGROUPBIKOU);

            baseDomManager.insert(kadouTimeGroup);
        }
    }

    @Transactional
    public void createTestB0005_02(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {

            C_KadouTimeYoubiKbn[] kadouTimeYoubiKbns = {C_KadouTimeYoubiKbn.GETUYOU, C_KadouTimeYoubiKbn.KAYOU, C_KadouTimeYoubiKbn.SUIYOU
                , C_KadouTimeYoubiKbn.MOKUYOU, C_KadouTimeYoubiKbn.KINYOU, C_KadouTimeYoubiKbn.DOYOU, C_KadouTimeYoubiKbn.NITIYOU, C_KadouTimeYoubiKbn.HYOUJYUN};
            C_EigyoubiKbn[] eigyoubiKbns = {C_EigyoubiKbn.EIGYOUBI, C_EigyoubiKbn.HIEIGYOUBI};

            for( C_EigyoubiKbn eigyoubiKbn : eigyoubiKbns ) {
                AT_KadouTime kadouTime = null;
                for ( C_KadouTimeYoubiKbn youbiKbn : kadouTimeYoubiKbns ) {

                    kadouTime = kadouTimeGroup.getKadouTime(youbiKbn, eigyoubiKbn);
                    if ( null == kadouTime ) {

                        kadouTime = kadouTimeGroup.createKadouTime();
                        kadouTime.setEigyoubiKbn(eigyoubiKbn);
                        kadouTime.setKadouTimeYoubiKbn(youbiKbn);
                        kadouTime.setKadouTimeSiteiKbn(C_KadouTimeSiteiKbn.HYOUJUN);
                        if( C_KadouTimeYoubiKbn.HYOUJYUN.eq(youbiKbn) ) {
                            kadouTime.setKadouTimeSiteiKbn(C_KadouTimeSiteiKbn.ZENJITURIYOU_KA);
                        }
                    }

                    baseDomManager.update(kadouTimeGroup);
                }
            }
        }
    }

    @Transactional
    public void createTestB0005_03(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {


            AT_TokuteibiKadouTime tokuteibiKadouTime = kadouTimeGroup.getTokuteibiKadouTime(ALREADYSYORIYMD);
            if ( null == tokuteibiKadouTime ) {
                tokuteibiKadouTime = kadouTimeGroup.createTokuteibiKadouTime();
                tokuteibiKadouTime.setKadouTimeSiteiYmd(ALREADYSYORIYMD);
                tokuteibiKadouTime.setKadouTimeSiteiKbn(ALREADYSITEIKBN);

                baseDomManager.update(kadouTimeGroup);
            }
        }
    }

    @Transactional
    public void deleteTestB0005_01(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {
            kadouTimeGroup.getKadouTimes().removeAll(kadouTimeGroup.getKadouTimes());
            kadouTimeGroup.getTokuteibiKadouTimes().removeAll(kadouTimeGroup.getTokuteibiKadouTimes());

            baseDomManager.update(kadouTimeGroup);
            baseDomManager.delete(kadouTimeGroup);
        }
    }

    @Transactional
    public void createTestB0006_01(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null == kadouTimeGroup ) {
            kadouTimeGroup = new AT_KadouTimeGroup();
            kadouTimeGroup.setKadouTimeGroupCd(ALREADYKADOUTIMEGROUPCD);
            kadouTimeGroup.setKadouTimeGroupNm(ALREADYKADOUTIMEGROUPNM);
            kadouTimeGroup.setHolidayGroupCd(ALREADYKADOUTIMEGROUP_HOLIDAYGROUPCD);
            kadouTimeGroup.setKadouTimeGroupDescription(ALREADYKADOUTIMEGROUPBIKOU);

            baseDomManager.insert(kadouTimeGroup);
        }
    }

    @Transactional
    public void createTestB0006_02(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {

            C_KadouTimeYoubiKbn[] kadouTimeYoubiKbns = {C_KadouTimeYoubiKbn.GETUYOU, C_KadouTimeYoubiKbn.KAYOU, C_KadouTimeYoubiKbn.SUIYOU
                , C_KadouTimeYoubiKbn.MOKUYOU, C_KadouTimeYoubiKbn.KINYOU, C_KadouTimeYoubiKbn.DOYOU, C_KadouTimeYoubiKbn.NITIYOU, C_KadouTimeYoubiKbn.HYOUJYUN};
            C_EigyoubiKbn[] eigyoubiKbns = {C_EigyoubiKbn.EIGYOUBI, C_EigyoubiKbn.HIEIGYOUBI};

            for( C_EigyoubiKbn eigyoubiKbn : eigyoubiKbns ) {
                AT_KadouTime kadouTime = null;
                for ( C_KadouTimeYoubiKbn youbiKbn : kadouTimeYoubiKbns ) {

                    kadouTime = kadouTimeGroup.getKadouTime(youbiKbn, eigyoubiKbn);
                    if ( null == kadouTime ) {

                        kadouTime = kadouTimeGroup.createKadouTime();
                        kadouTime.setEigyoubiKbn(eigyoubiKbn);
                        kadouTime.setKadouTimeYoubiKbn(youbiKbn);
                        kadouTime.setKadouTimeSiteiKbn(C_KadouTimeSiteiKbn.HYOUJUN);
                        if( C_KadouTimeYoubiKbn.HYOUJYUN.eq(youbiKbn) ) {
                            kadouTime.setKadouTimeSiteiKbn(C_KadouTimeSiteiKbn.ZENJITURIYOU_KA);
                        }
                    }

                    baseDomManager.update(kadouTimeGroup);
                }
            }
        }
    }

    @Transactional
    public void createTestB0006_03(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {


            AT_TokuteibiKadouTime tokuteibiKadouTime = kadouTimeGroup.getTokuteibiKadouTime(ALREADYSYORIYMD);
            if ( null == tokuteibiKadouTime ) {
                tokuteibiKadouTime = kadouTimeGroup.createTokuteibiKadouTime();
                tokuteibiKadouTime.setKadouTimeSiteiYmd(ALREADYSYORIYMD);
                tokuteibiKadouTime.setKadouTimeSiteiKbn(ALREADYSITEIKBN);

                baseDomManager.update(kadouTimeGroup);
            }
        }
    }

    @Transactional
    public void deleteTestB0006_01(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {
            kadouTimeGroup.getKadouTimes().removeAll(kadouTimeGroup.getKadouTimes());
            kadouTimeGroup.getTokuteibiKadouTimes().removeAll(kadouTimeGroup.getTokuteibiKadouTimes());

            baseDomManager.update(kadouTimeGroup);
            baseDomManager.delete(kadouTimeGroup);
        }
    }

    @Transactional
    public void createTestB0007_01(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null == kadouTimeGroup ) {
            kadouTimeGroup = new AT_KadouTimeGroup();
            kadouTimeGroup.setKadouTimeGroupCd(ALREADYKADOUTIMEGROUPCD);
            kadouTimeGroup.setKadouTimeGroupNm(ALREADYKADOUTIMEGROUPNM);
            kadouTimeGroup.setHolidayGroupCd(ALREADYKADOUTIMEGROUP_HOLIDAYGROUPCD);
            kadouTimeGroup.setKadouTimeGroupDescription(ALREADYKADOUTIMEGROUPBIKOU);

            baseDomManager.insert(kadouTimeGroup);
        }
    }

    @Transactional
    public void createTestB0007_02(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {

            C_KadouTimeYoubiKbn[] kadouTimeYoubiKbns = {C_KadouTimeYoubiKbn.GETUYOU, C_KadouTimeYoubiKbn.KAYOU, C_KadouTimeYoubiKbn.SUIYOU
                , C_KadouTimeYoubiKbn.MOKUYOU, C_KadouTimeYoubiKbn.KINYOU, C_KadouTimeYoubiKbn.DOYOU, C_KadouTimeYoubiKbn.NITIYOU, C_KadouTimeYoubiKbn.HYOUJYUN};
            C_EigyoubiKbn[] eigyoubiKbns = {C_EigyoubiKbn.EIGYOUBI, C_EigyoubiKbn.HIEIGYOUBI};

            for( C_EigyoubiKbn eigyoubiKbn : eigyoubiKbns ) {
                AT_KadouTime kadouTime = null;
                for ( C_KadouTimeYoubiKbn youbiKbn : kadouTimeYoubiKbns ) {

                    kadouTime = kadouTimeGroup.getKadouTime(youbiKbn, eigyoubiKbn);
                    if ( null == kadouTime ) {

                        kadouTime = kadouTimeGroup.createKadouTime();
                        kadouTime.setEigyoubiKbn(eigyoubiKbn);
                        kadouTime.setKadouTimeYoubiKbn(youbiKbn);
                        kadouTime.setKadouTimeSiteiKbn(C_KadouTimeSiteiKbn.HYOUJUN);
                        if( C_KadouTimeYoubiKbn.HYOUJYUN.eq(youbiKbn) ) {
                            kadouTime.setKadouTimeSiteiKbn(C_KadouTimeSiteiKbn.ZENJITURIYOU_KA);
                        }
                    }

                    baseDomManager.update(kadouTimeGroup);
                }
            }
        }
    }

    @Transactional
    public void createTestB0007_03(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {


            AT_TokuteibiKadouTime tokuteibiKadouTime = kadouTimeGroup.getTokuteibiKadouTime(ALREADYSYORIYMD);
            if ( null == tokuteibiKadouTime ) {
                tokuteibiKadouTime = kadouTimeGroup.createTokuteibiKadouTime();
                tokuteibiKadouTime.setKadouTimeSiteiYmd(ALREADYSYORIYMD);
                tokuteibiKadouTime.setKadouTimeSiteiKbn(ALREADYSITEIKBN);

                baseDomManager.update(kadouTimeGroup);
            }
        }
    }

    @Transactional
    public void deleteTestB0007_01(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {
            kadouTimeGroup.getKadouTimes().removeAll(kadouTimeGroup.getKadouTimes());
            kadouTimeGroup.getTokuteibiKadouTimes().removeAll(kadouTimeGroup.getTokuteibiKadouTimes());

            baseDomManager.update(kadouTimeGroup);
            baseDomManager.delete(kadouTimeGroup);
        }
    }

    @Transactional
    public void createTestB0008_01(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null == kadouTimeGroup ) {
            kadouTimeGroup = new AT_KadouTimeGroup();
            kadouTimeGroup.setKadouTimeGroupCd(ALREADYKADOUTIMEGROUPCD);
            kadouTimeGroup.setKadouTimeGroupNm(ALREADYKADOUTIMEGROUPNM);
            kadouTimeGroup.setHolidayGroupCd(ALREADYKADOUTIMEGROUP_HOLIDAYGROUPCD);
            kadouTimeGroup.setKadouTimeGroupDescription(ALREADYKADOUTIMEGROUPBIKOU);

            baseDomManager.insert(kadouTimeGroup);
        }
    }

    @Transactional
    public void createTestB0008_02(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {

            C_KadouTimeYoubiKbn[] kadouTimeYoubiKbns = {C_KadouTimeYoubiKbn.GETUYOU, C_KadouTimeYoubiKbn.KAYOU, C_KadouTimeYoubiKbn.SUIYOU
                , C_KadouTimeYoubiKbn.MOKUYOU, C_KadouTimeYoubiKbn.KINYOU, C_KadouTimeYoubiKbn.DOYOU, C_KadouTimeYoubiKbn.NITIYOU, C_KadouTimeYoubiKbn.HYOUJYUN};
            C_EigyoubiKbn[] eigyoubiKbns = {C_EigyoubiKbn.EIGYOUBI, C_EigyoubiKbn.HIEIGYOUBI};

            for( C_EigyoubiKbn eigyoubiKbn : eigyoubiKbns ) {
                AT_KadouTime kadouTime = null;
                for ( C_KadouTimeYoubiKbn youbiKbn : kadouTimeYoubiKbns ) {

                    kadouTime = kadouTimeGroup.getKadouTime(youbiKbn, eigyoubiKbn);
                    if ( null == kadouTime ) {

                        kadouTime = kadouTimeGroup.createKadouTime();
                        kadouTime.setEigyoubiKbn(eigyoubiKbn);
                        kadouTime.setKadouTimeYoubiKbn(youbiKbn);
                        kadouTime.setKadouTimeSiteiKbn(C_KadouTimeSiteiKbn.HYOUJUN);
                        if( C_KadouTimeYoubiKbn.HYOUJYUN.eq(youbiKbn) ) {
                            kadouTime.setKadouTimeSiteiKbn(C_KadouTimeSiteiKbn.ZENJITURIYOU_KA);
                        }
                    }

                    baseDomManager.update(kadouTimeGroup);
                }
            }
        }
    }

    @Transactional
    public void createTestB0008_03(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {


            AT_TokuteibiKadouTime tokuteibiKadouTime = kadouTimeGroup.getTokuteibiKadouTime(ALREADYSYORIYMD);
            if ( null == tokuteibiKadouTime ) {
                tokuteibiKadouTime = kadouTimeGroup.createTokuteibiKadouTime();
                tokuteibiKadouTime.setKadouTimeSiteiYmd(ALREADYSYORIYMD);
                tokuteibiKadouTime.setKadouTimeSiteiKbn(ALREADYSITEIKBN);

                baseDomManager.update(kadouTimeGroup);
            }
        }
    }

    @Transactional
    public void deleteTestB0008_01(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {
            kadouTimeGroup.getKadouTimes().removeAll(kadouTimeGroup.getKadouTimes());
            kadouTimeGroup.getTokuteibiKadouTimes().removeAll(kadouTimeGroup.getTokuteibiKadouTimes());

            baseDomManager.update(kadouTimeGroup);
            baseDomManager.delete(kadouTimeGroup);
        }
    }

    @Transactional
    public void createTestB0010_01(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null == kadouTimeGroup ) {
            kadouTimeGroup = new AT_KadouTimeGroup();
            kadouTimeGroup.setKadouTimeGroupCd(ALREADYKADOUTIMEGROUPCD);
            kadouTimeGroup.setKadouTimeGroupNm(ALREADYKADOUTIMEGROUPNM);
            kadouTimeGroup.setHolidayGroupCd(ALREADYKADOUTIMEGROUP_HOLIDAYGROUPCD);
            kadouTimeGroup.setKadouTimeGroupDescription(ALREADYKADOUTIMEGROUPBIKOU);

            baseDomManager.insert(kadouTimeGroup);
        }
    }

    @Transactional
    public void createTestB0010_02(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {

            C_KadouTimeYoubiKbn[] kadouTimeYoubiKbns = {C_KadouTimeYoubiKbn.GETUYOU, C_KadouTimeYoubiKbn.KAYOU, C_KadouTimeYoubiKbn.SUIYOU
                , C_KadouTimeYoubiKbn.MOKUYOU, C_KadouTimeYoubiKbn.KINYOU, C_KadouTimeYoubiKbn.DOYOU, C_KadouTimeYoubiKbn.NITIYOU, C_KadouTimeYoubiKbn.HYOUJYUN};
            C_EigyoubiKbn[] eigyoubiKbns = {C_EigyoubiKbn.EIGYOUBI, C_EigyoubiKbn.HIEIGYOUBI};

            for( C_EigyoubiKbn eigyoubiKbn : eigyoubiKbns ) {
                AT_KadouTime kadouTime = null;
                for ( C_KadouTimeYoubiKbn youbiKbn : kadouTimeYoubiKbns ) {

                    kadouTime = kadouTimeGroup.getKadouTime(youbiKbn, eigyoubiKbn);
                    if ( null == kadouTime ) {

                        kadouTime = kadouTimeGroup.createKadouTime();
                        kadouTime.setEigyoubiKbn(eigyoubiKbn);
                        kadouTime.setKadouTimeYoubiKbn(youbiKbn);
                        kadouTime.setKadouTimeSiteiKbn(C_KadouTimeSiteiKbn.HYOUJUN);
                        if( C_KadouTimeYoubiKbn.HYOUJYUN.eq(youbiKbn) ) {
                            kadouTime.setKadouTimeSiteiKbn(C_KadouTimeSiteiKbn.ZENJITURIYOU_KA);
                        }
                    }

                    baseDomManager.update(kadouTimeGroup);
                }
            }
        }
    }

    @Transactional
    public void deleteTestB0010_01(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {
            kadouTimeGroup.getKadouTimes().removeAll(kadouTimeGroup.getKadouTimes());
            kadouTimeGroup.getTokuteibiKadouTimes().removeAll(kadouTimeGroup.getTokuteibiKadouTimes());

            baseDomManager.update(kadouTimeGroup);
            baseDomManager.delete(kadouTimeGroup);
        }
    }

    @Transactional
    public void createTestB0011_01(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null == kadouTimeGroup ) {
            kadouTimeGroup = new AT_KadouTimeGroup();
            kadouTimeGroup.setKadouTimeGroupCd(ALREADYKADOUTIMEGROUPCD);
            kadouTimeGroup.setKadouTimeGroupNm(ALREADYKADOUTIMEGROUPNM);
            kadouTimeGroup.setHolidayGroupCd(ALREADYKADOUTIMEGROUP_HOLIDAYGROUPCD);
            kadouTimeGroup.setKadouTimeGroupDescription(ALREADYKADOUTIMEGROUPBIKOU);

            baseDomManager.insert(kadouTimeGroup);
        }
    }

    @Transactional
    public void createTestB0011_02(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {

            C_KadouTimeYoubiKbn[] kadouTimeYoubiKbns = {C_KadouTimeYoubiKbn.GETUYOU, C_KadouTimeYoubiKbn.KAYOU, C_KadouTimeYoubiKbn.SUIYOU
                , C_KadouTimeYoubiKbn.MOKUYOU, C_KadouTimeYoubiKbn.KINYOU, C_KadouTimeYoubiKbn.DOYOU, C_KadouTimeYoubiKbn.NITIYOU, C_KadouTimeYoubiKbn.HYOUJYUN};
            C_EigyoubiKbn[] eigyoubiKbns = {C_EigyoubiKbn.EIGYOUBI, C_EigyoubiKbn.HIEIGYOUBI};

            for( C_EigyoubiKbn eigyoubiKbn : eigyoubiKbns ) {
                AT_KadouTime kadouTime = null;
                for ( C_KadouTimeYoubiKbn youbiKbn : kadouTimeYoubiKbns ) {

                    kadouTime = kadouTimeGroup.getKadouTime(youbiKbn, eigyoubiKbn);
                    if ( null == kadouTime ) {

                        kadouTime = kadouTimeGroup.createKadouTime();
                        kadouTime.setEigyoubiKbn(eigyoubiKbn);
                        kadouTime.setKadouTimeYoubiKbn(youbiKbn);
                        kadouTime.setKadouTimeSiteiKbn(C_KadouTimeSiteiKbn.HYOUJUN);
                        if( C_KadouTimeYoubiKbn.HYOUJYUN.eq(youbiKbn) ) {
                            kadouTime.setKadouTimeSiteiKbn(C_KadouTimeSiteiKbn.ZENJITURIYOU_KA);
                        }
                    }

                    baseDomManager.update(kadouTimeGroup);
                }
            }
        }
    }

    @Transactional
    public void deleteTestB0011_01(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {
            kadouTimeGroup.getKadouTimes().removeAll(kadouTimeGroup.getKadouTimes());
            kadouTimeGroup.getTokuteibiKadouTimes().removeAll(kadouTimeGroup.getTokuteibiKadouTimes());

            baseDomManager.update(kadouTimeGroup);
            baseDomManager.delete(kadouTimeGroup);
        }
    }

    @Transactional
    public void createTestB0012_01(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null == kadouTimeGroup ) {
            kadouTimeGroup = new AT_KadouTimeGroup();
            kadouTimeGroup.setKadouTimeGroupCd(ALREADYKADOUTIMEGROUPCD);
            kadouTimeGroup.setKadouTimeGroupNm(ALREADYKADOUTIMEGROUPNM);
            kadouTimeGroup.setHolidayGroupCd(ALREADYKADOUTIMEGROUP_HOLIDAYGROUPCD);
            kadouTimeGroup.setKadouTimeGroupDescription(ALREADYKADOUTIMEGROUPBIKOU);

            baseDomManager.insert(kadouTimeGroup);
        }
    }

    @Transactional
    public void createTestB0012_02(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {

            C_KadouTimeYoubiKbn[] kadouTimeYoubiKbns = {C_KadouTimeYoubiKbn.GETUYOU, C_KadouTimeYoubiKbn.KAYOU, C_KadouTimeYoubiKbn.SUIYOU
                , C_KadouTimeYoubiKbn.MOKUYOU, C_KadouTimeYoubiKbn.KINYOU, C_KadouTimeYoubiKbn.DOYOU, C_KadouTimeYoubiKbn.NITIYOU, C_KadouTimeYoubiKbn.HYOUJYUN};
            C_EigyoubiKbn[] eigyoubiKbns = {C_EigyoubiKbn.EIGYOUBI, C_EigyoubiKbn.HIEIGYOUBI};

            for( C_EigyoubiKbn eigyoubiKbn : eigyoubiKbns ) {
                AT_KadouTime kadouTime = null;
                for ( C_KadouTimeYoubiKbn youbiKbn : kadouTimeYoubiKbns ) {

                    kadouTime = kadouTimeGroup.getKadouTime(youbiKbn, eigyoubiKbn);
                    if ( null == kadouTime ) {

                        kadouTime = kadouTimeGroup.createKadouTime();
                        kadouTime.setEigyoubiKbn(eigyoubiKbn);
                        kadouTime.setKadouTimeYoubiKbn(youbiKbn);
                        kadouTime.setKadouTimeSiteiKbn(C_KadouTimeSiteiKbn.HYOUJUN);
                        if( C_KadouTimeYoubiKbn.HYOUJYUN.eq(youbiKbn) ) {
                            kadouTime.setKadouTimeSiteiKbn(C_KadouTimeSiteiKbn.ZENJITURIYOU_KA);
                        }
                    }

                    baseDomManager.update(kadouTimeGroup);
                }
            }
        }
    }

    @Transactional
    public void deleteTestB0012_01(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {
            kadouTimeGroup.getKadouTimes().removeAll(kadouTimeGroup.getKadouTimes());
            kadouTimeGroup.getTokuteibiKadouTimes().removeAll(kadouTimeGroup.getTokuteibiKadouTimes());

            baseDomManager.update(kadouTimeGroup);
            baseDomManager.delete(kadouTimeGroup);
        }
    }

    @Transactional
    public void createTestB0013_01(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null == kadouTimeGroup ) {
            kadouTimeGroup = new AT_KadouTimeGroup();
            kadouTimeGroup.setKadouTimeGroupCd(ALREADYKADOUTIMEGROUPCD);
            kadouTimeGroup.setKadouTimeGroupNm(ALREADYKADOUTIMEGROUPNM);
            kadouTimeGroup.setHolidayGroupCd(ALREADYKADOUTIMEGROUP_HOLIDAYGROUPCD);
            kadouTimeGroup.setKadouTimeGroupDescription(ALREADYKADOUTIMEGROUPBIKOU);

            baseDomManager.insert(kadouTimeGroup);
        }
    }

    @Transactional
    public void createTestB0013_02(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {

            C_KadouTimeYoubiKbn[] kadouTimeYoubiKbns = {C_KadouTimeYoubiKbn.GETUYOU, C_KadouTimeYoubiKbn.KAYOU, C_KadouTimeYoubiKbn.SUIYOU
                , C_KadouTimeYoubiKbn.MOKUYOU, C_KadouTimeYoubiKbn.KINYOU, C_KadouTimeYoubiKbn.DOYOU, C_KadouTimeYoubiKbn.NITIYOU, C_KadouTimeYoubiKbn.HYOUJYUN};
            C_EigyoubiKbn[] eigyoubiKbns = {C_EigyoubiKbn.EIGYOUBI, C_EigyoubiKbn.HIEIGYOUBI};

            for( C_EigyoubiKbn eigyoubiKbn : eigyoubiKbns ) {
                AT_KadouTime kadouTime = null;
                for ( C_KadouTimeYoubiKbn youbiKbn : kadouTimeYoubiKbns ) {

                    kadouTime = kadouTimeGroup.getKadouTime(youbiKbn, eigyoubiKbn);
                    if ( null == kadouTime ) {

                        kadouTime = kadouTimeGroup.createKadouTime();
                        kadouTime.setEigyoubiKbn(eigyoubiKbn);
                        kadouTime.setKadouTimeYoubiKbn(youbiKbn);
                        kadouTime.setKadouTimeSiteiKbn(C_KadouTimeSiteiKbn.HYOUJUN);
                        if( C_KadouTimeYoubiKbn.HYOUJYUN.eq(youbiKbn) ) {
                            kadouTime.setKadouTimeSiteiKbn(C_KadouTimeSiteiKbn.ZENJITURIYOU_KA);
                        }
                    }

                    baseDomManager.update(kadouTimeGroup);
                }
            }
        }
    }

    @Transactional
    public void deleteTestB0013_01(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {
            kadouTimeGroup.getKadouTimes().removeAll(kadouTimeGroup.getKadouTimes());
            kadouTimeGroup.getTokuteibiKadouTimes().removeAll(kadouTimeGroup.getTokuteibiKadouTimes());

            baseDomManager.update(kadouTimeGroup);
            baseDomManager.delete(kadouTimeGroup);
        }
    }

    @Transactional
    public void createTestB0014_01(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null == kadouTimeGroup ) {
            kadouTimeGroup = new AT_KadouTimeGroup();
            kadouTimeGroup.setKadouTimeGroupCd(ALREADYKADOUTIMEGROUPCD);
            kadouTimeGroup.setKadouTimeGroupNm(ALREADYKADOUTIMEGROUPNM);
            kadouTimeGroup.setHolidayGroupCd(ALREADYKADOUTIMEGROUP_HOLIDAYGROUPCD);
            kadouTimeGroup.setKadouTimeGroupDescription(ALREADYKADOUTIMEGROUPBIKOU);

            baseDomManager.insert(kadouTimeGroup);
        }
    }

    @Transactional
    public void createTestB0014_02(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {

            C_KadouTimeYoubiKbn[] kadouTimeYoubiKbns = {C_KadouTimeYoubiKbn.GETUYOU, C_KadouTimeYoubiKbn.KAYOU, C_KadouTimeYoubiKbn.SUIYOU
                , C_KadouTimeYoubiKbn.MOKUYOU, C_KadouTimeYoubiKbn.KINYOU, C_KadouTimeYoubiKbn.DOYOU, C_KadouTimeYoubiKbn.NITIYOU, C_KadouTimeYoubiKbn.HYOUJYUN};
            C_EigyoubiKbn[] eigyoubiKbns = {C_EigyoubiKbn.EIGYOUBI, C_EigyoubiKbn.HIEIGYOUBI};

            for( C_EigyoubiKbn eigyoubiKbn : eigyoubiKbns ) {
                AT_KadouTime kadouTime = null;
                for ( C_KadouTimeYoubiKbn youbiKbn : kadouTimeYoubiKbns ) {

                    kadouTime = kadouTimeGroup.getKadouTime(youbiKbn, eigyoubiKbn);
                    if ( null == kadouTime ) {

                        kadouTime = kadouTimeGroup.createKadouTime();
                        kadouTime.setEigyoubiKbn(eigyoubiKbn);
                        kadouTime.setKadouTimeYoubiKbn(youbiKbn);
                        kadouTime.setKadouTimeSiteiKbn(C_KadouTimeSiteiKbn.HYOUJUN);
                        if( C_KadouTimeYoubiKbn.HYOUJYUN.eq(youbiKbn) ) {
                            kadouTime.setKadouTimeSiteiKbn(C_KadouTimeSiteiKbn.ZENJITURIYOU_KA);
                        }
                    }

                    baseDomManager.update(kadouTimeGroup);
                }
            }
        }
    }

    @Transactional
    public void deleteTestB0014_01(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {
            kadouTimeGroup.getKadouTimes().removeAll(kadouTimeGroup.getKadouTimes());
            kadouTimeGroup.getTokuteibiKadouTimes().removeAll(kadouTimeGroup.getTokuteibiKadouTimes());

            baseDomManager.update(kadouTimeGroup);
            baseDomManager.delete(kadouTimeGroup);
        }
    }

    @Transactional
    public void createTestB0015_01(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null == kadouTimeGroup ) {
            kadouTimeGroup = new AT_KadouTimeGroup();
            kadouTimeGroup.setKadouTimeGroupCd(ALREADYKADOUTIMEGROUPCD);
            kadouTimeGroup.setKadouTimeGroupNm(ALREADYKADOUTIMEGROUPNM);
            kadouTimeGroup.setHolidayGroupCd(ALREADYKADOUTIMEGROUP_HOLIDAYGROUPCD);
            kadouTimeGroup.setKadouTimeGroupDescription(ALREADYKADOUTIMEGROUPBIKOU);

            baseDomManager.insert(kadouTimeGroup);
        }
    }

    @Transactional
    public void createTestB0015_02(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {

            C_KadouTimeYoubiKbn[] kadouTimeYoubiKbns = {C_KadouTimeYoubiKbn.GETUYOU, C_KadouTimeYoubiKbn.KAYOU, C_KadouTimeYoubiKbn.SUIYOU
                , C_KadouTimeYoubiKbn.MOKUYOU, C_KadouTimeYoubiKbn.KINYOU, C_KadouTimeYoubiKbn.DOYOU, C_KadouTimeYoubiKbn.NITIYOU, C_KadouTimeYoubiKbn.HYOUJYUN};
            C_EigyoubiKbn[] eigyoubiKbns = {C_EigyoubiKbn.EIGYOUBI, C_EigyoubiKbn.HIEIGYOUBI};

            for( C_EigyoubiKbn eigyoubiKbn : eigyoubiKbns ) {
                AT_KadouTime kadouTime = null;
                for ( C_KadouTimeYoubiKbn youbiKbn : kadouTimeYoubiKbns ) {

                    kadouTime = kadouTimeGroup.getKadouTime(youbiKbn, eigyoubiKbn);
                    if ( null == kadouTime ) {

                        kadouTime = kadouTimeGroup.createKadouTime();
                        kadouTime.setEigyoubiKbn(eigyoubiKbn);
                        kadouTime.setKadouTimeYoubiKbn(youbiKbn);
                        kadouTime.setKadouTimeSiteiKbn(C_KadouTimeSiteiKbn.HYOUJUN);
                        if( C_KadouTimeYoubiKbn.HYOUJYUN.eq(youbiKbn) ) {
                            kadouTime.setKadouTimeSiteiKbn(C_KadouTimeSiteiKbn.ZENJITURIYOU_KA);
                        }
                    }

                    baseDomManager.update(kadouTimeGroup);
                }
            }
        }
    }

    @Transactional
    public void deleteTestB0015_01(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {
            kadouTimeGroup.getKadouTimes().removeAll(kadouTimeGroup.getKadouTimes());
            kadouTimeGroup.getTokuteibiKadouTimes().removeAll(kadouTimeGroup.getTokuteibiKadouTimes());

            baseDomManager.update(kadouTimeGroup);
            baseDomManager.delete(kadouTimeGroup);
        }
    }

    @Transactional
    public void createTestB0016_01(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null == kadouTimeGroup ) {
            kadouTimeGroup = new AT_KadouTimeGroup();
            kadouTimeGroup.setKadouTimeGroupCd(ALREADYKADOUTIMEGROUPCD);
            kadouTimeGroup.setKadouTimeGroupNm(ALREADYKADOUTIMEGROUPNM);
            kadouTimeGroup.setHolidayGroupCd(ALREADYKADOUTIMEGROUP_HOLIDAYGROUPCD);
            kadouTimeGroup.setKadouTimeGroupDescription(ALREADYKADOUTIMEGROUPBIKOU);

            baseDomManager.insert(kadouTimeGroup);
        }
    }

    @Transactional
    public void createTestB0016_02(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {

            C_KadouTimeYoubiKbn[] kadouTimeYoubiKbns = {C_KadouTimeYoubiKbn.GETUYOU, C_KadouTimeYoubiKbn.KAYOU, C_KadouTimeYoubiKbn.SUIYOU
                , C_KadouTimeYoubiKbn.MOKUYOU, C_KadouTimeYoubiKbn.KINYOU, C_KadouTimeYoubiKbn.DOYOU, C_KadouTimeYoubiKbn.NITIYOU, C_KadouTimeYoubiKbn.HYOUJYUN};
            C_EigyoubiKbn[] eigyoubiKbns = {C_EigyoubiKbn.EIGYOUBI, C_EigyoubiKbn.HIEIGYOUBI};

            for( C_EigyoubiKbn eigyoubiKbn : eigyoubiKbns ) {
                AT_KadouTime kadouTime = null;
                for ( C_KadouTimeYoubiKbn youbiKbn : kadouTimeYoubiKbns ) {
                    List<AT_KadouTime> kadouTimes = kadouTimeGroup.getKadouTimes();
                    if( kadouTimes.size() < 16) {

                        kadouTime = kadouTimeGroup.createKadouTime();
                        kadouTime.setEigyoubiKbn(eigyoubiKbn);
                        kadouTime.setKadouTimeYoubiKbn(youbiKbn);
                        kadouTime.setKadouTimeSiteiKbn(C_KadouTimeSiteiKbn.HYOUJUN);
                        if( C_KadouTimeYoubiKbn.HYOUJYUN.eq(youbiKbn) ) {
                            kadouTime.setKadouTimeSiteiKbn(C_KadouTimeSiteiKbn.ZENJITURIYOU_KA);
                        }
                    }
                }
            }
            baseDomManager.update(kadouTimeGroup);
        }
    }

    @Transactional
    public void createTestB0016_03(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {


            AT_TokuteibiKadouTime tokuteibiKadouTime = kadouTimeGroup.getTokuteibiKadouTime(ALREADYSYORIYMD);
            if ( null == tokuteibiKadouTime ) {
                tokuteibiKadouTime = kadouTimeGroup.createTokuteibiKadouTime();
                tokuteibiKadouTime.setKadouTimeSiteiYmd(ALREADYSYORIYMD);
                tokuteibiKadouTime.setKadouTimeSiteiKbn(ALREADYSITEIKBN);

                baseDomManager.update(kadouTimeGroup);
            }
        }
    }

    @Transactional
    public void deleteTestB0016_01(){

        baseDomManager.clear();
        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {
            kadouTimeGroup.getKadouTimes().removeAll(kadouTimeGroup.getKadouTimes());
            kadouTimeGroup.getTokuteibiKadouTimes().removeAll(kadouTimeGroup.getTokuteibiKadouTimes());

            baseDomManager.update(kadouTimeGroup);
            baseDomManager.delete(kadouTimeGroup);
        }
    }

    @Transactional
    public void createTestB0017_01(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null == kadouTimeGroup ) {
            kadouTimeGroup = new AT_KadouTimeGroup();
            kadouTimeGroup.setKadouTimeGroupCd(ALREADYKADOUTIMEGROUPCD);
            kadouTimeGroup.setKadouTimeGroupNm(ALREADYKADOUTIMEGROUPNM);
            kadouTimeGroup.setHolidayGroupCd(ALREADYKADOUTIMEGROUP_HOLIDAYGROUPCD);
            kadouTimeGroup.setKadouTimeGroupDescription(ALREADYKADOUTIMEGROUPBIKOU);

            baseDomManager.insert(kadouTimeGroup);
        }
    }

    @Transactional
    public void createTestB0017_02(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {

            C_KadouTimeYoubiKbn[] kadouTimeYoubiKbns = {C_KadouTimeYoubiKbn.GETUYOU, C_KadouTimeYoubiKbn.KAYOU, C_KadouTimeYoubiKbn.SUIYOU
                , C_KadouTimeYoubiKbn.MOKUYOU, C_KadouTimeYoubiKbn.KINYOU, C_KadouTimeYoubiKbn.DOYOU, C_KadouTimeYoubiKbn.NITIYOU, C_KadouTimeYoubiKbn.HYOUJYUN};
            C_EigyoubiKbn[] eigyoubiKbns = {C_EigyoubiKbn.EIGYOUBI, C_EigyoubiKbn.HIEIGYOUBI};

            for( C_EigyoubiKbn eigyoubiKbn : eigyoubiKbns ) {
                AT_KadouTime kadouTime = null;
                for ( C_KadouTimeYoubiKbn youbiKbn : kadouTimeYoubiKbns ) {

                    kadouTime = kadouTimeGroup.getKadouTime(youbiKbn, eigyoubiKbn);
                    if ( null == kadouTime ) {

                        kadouTime = kadouTimeGroup.createKadouTime();
                        kadouTime.setEigyoubiKbn(eigyoubiKbn);
                        kadouTime.setKadouTimeYoubiKbn(youbiKbn);
                        kadouTime.setKadouTimeSiteiKbn(C_KadouTimeSiteiKbn.HYOUJUN);
                        if( C_KadouTimeYoubiKbn.HYOUJYUN.eq(youbiKbn) ) {
                            kadouTime.setKadouTimeSiteiKbn(C_KadouTimeSiteiKbn.ZENJITURIYOU_KA);
                        }
                    }

                    baseDomManager.update(kadouTimeGroup);
                }
            }
        }
    }

    @Transactional
    public void deleteTestB0017_01(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {
            kadouTimeGroup.getKadouTimes().removeAll(kadouTimeGroup.getKadouTimes());
            kadouTimeGroup.getTokuteibiKadouTimes().removeAll(kadouTimeGroup.getTokuteibiKadouTimes());

            baseDomManager.update(kadouTimeGroup);
            baseDomManager.delete(kadouTimeGroup);
        }
    }

    @Transactional
    public void createTestB0018_01(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null == kadouTimeGroup ) {
            kadouTimeGroup = new AT_KadouTimeGroup();
            kadouTimeGroup.setKadouTimeGroupCd(ALREADYKADOUTIMEGROUPCD);
            kadouTimeGroup.setKadouTimeGroupNm(ALREADYKADOUTIMEGROUPNM);
            kadouTimeGroup.setHolidayGroupCd(ALREADYKADOUTIMEGROUP_HOLIDAYGROUPCD);
            kadouTimeGroup.setKadouTimeGroupDescription(ALREADYKADOUTIMEGROUPBIKOU);

            baseDomManager.insert(kadouTimeGroup);
        }
    }


    @Transactional
    public void createTestB0018_02(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {

            C_KadouTimeYoubiKbn[] kadouTimeYoubiKbns = {C_KadouTimeYoubiKbn.GETUYOU, C_KadouTimeYoubiKbn.KAYOU, C_KadouTimeYoubiKbn.SUIYOU
                , C_KadouTimeYoubiKbn.MOKUYOU, C_KadouTimeYoubiKbn.KINYOU, C_KadouTimeYoubiKbn.DOYOU, C_KadouTimeYoubiKbn.NITIYOU, C_KadouTimeYoubiKbn.HYOUJYUN};
            C_EigyoubiKbn[] eigyoubiKbns = {C_EigyoubiKbn.EIGYOUBI, C_EigyoubiKbn.HIEIGYOUBI};

            for( C_EigyoubiKbn eigyoubiKbn : eigyoubiKbns ) {
                AT_KadouTime kadouTime = null;
                for ( C_KadouTimeYoubiKbn youbiKbn : kadouTimeYoubiKbns ) {
                    List<AT_KadouTime> kadouTimes = kadouTimeGroup.getKadouTimes();
                    if( kadouTimes.size() < 16) {

                        kadouTime = kadouTimeGroup.createKadouTime();
                        kadouTime.setEigyoubiKbn(eigyoubiKbn);
                        kadouTime.setKadouTimeYoubiKbn(youbiKbn);
                        kadouTime.setKadouTimeSiteiKbn(C_KadouTimeSiteiKbn.HYOUJUN);
                        if( C_KadouTimeYoubiKbn.HYOUJYUN.eq(youbiKbn) ) {
                            kadouTime.setKadouTimeSiteiKbn(C_KadouTimeSiteiKbn.ZENJITURIYOU_KA);
                        }
                    }
                }
            }
            baseDomManager.update(kadouTimeGroup);
        }
    }

    @Transactional
    public void createTestB0018_03(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {


            AT_TokuteibiKadouTime tokuteibiKadouTime = kadouTimeGroup.getTokuteibiKadouTime(ALREADYSYORIYMD);
            if ( null == tokuteibiKadouTime ) {
                tokuteibiKadouTime = kadouTimeGroup.createTokuteibiKadouTime();
                tokuteibiKadouTime.setKadouTimeSiteiYmd(ALREADYSYORIYMD);
                tokuteibiKadouTime.setKadouTimeSiteiKbn(ALREADYSITEIKBN);

                baseDomManager.update(kadouTimeGroup);
            }
        }
    }

    @Transactional
    public void deleteTestB0018_01(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {
            kadouTimeGroup.getKadouTimes().removeAll(kadouTimeGroup.getKadouTimes());
            kadouTimeGroup.getTokuteibiKadouTimes().removeAll(kadouTimeGroup.getTokuteibiKadouTimes());

            baseDomManager.update(kadouTimeGroup);
            baseDomManager.delete(kadouTimeGroup);
        }
    }

    @Transactional
    public void createTestB0019_01(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null == kadouTimeGroup ) {
            kadouTimeGroup = new AT_KadouTimeGroup();
            kadouTimeGroup.setKadouTimeGroupCd(ALREADYKADOUTIMEGROUPCD);
            kadouTimeGroup.setKadouTimeGroupNm(ALREADYKADOUTIMEGROUPNM);
            kadouTimeGroup.setHolidayGroupCd(ALREADYKADOUTIMEGROUP_HOLIDAYGROUPCD);
            kadouTimeGroup.setKadouTimeGroupDescription(ALREADYKADOUTIMEGROUPBIKOU);

            baseDomManager.insert(kadouTimeGroup);
        }
    }


    @Transactional
    public void createTestB0019_02(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {

            C_KadouTimeYoubiKbn[] kadouTimeYoubiKbns = {C_KadouTimeYoubiKbn.GETUYOU, C_KadouTimeYoubiKbn.KAYOU, C_KadouTimeYoubiKbn.SUIYOU
                , C_KadouTimeYoubiKbn.MOKUYOU, C_KadouTimeYoubiKbn.KINYOU, C_KadouTimeYoubiKbn.DOYOU, C_KadouTimeYoubiKbn.NITIYOU, C_KadouTimeYoubiKbn.HYOUJYUN};
            C_EigyoubiKbn[] eigyoubiKbns = {C_EigyoubiKbn.EIGYOUBI, C_EigyoubiKbn.HIEIGYOUBI};

            for( C_EigyoubiKbn eigyoubiKbn : eigyoubiKbns ) {
                AT_KadouTime kadouTime = null;
                for ( C_KadouTimeYoubiKbn youbiKbn : kadouTimeYoubiKbns ) {
                    List<AT_KadouTime> kadouTimes = kadouTimeGroup.getKadouTimes();
                    if( kadouTimes.size() < 16) {

                        kadouTime = kadouTimeGroup.createKadouTime();
                        kadouTime.setEigyoubiKbn(eigyoubiKbn);
                        kadouTime.setKadouTimeYoubiKbn(youbiKbn);
                        kadouTime.setKadouTimeSiteiKbn(C_KadouTimeSiteiKbn.HYOUJUN);
                        if( C_KadouTimeYoubiKbn.HYOUJYUN.eq(youbiKbn) ) {
                            kadouTime.setKadouTimeSiteiKbn(C_KadouTimeSiteiKbn.ZENJITURIYOU_KA);
                        }
                    }
                }
            }
            baseDomManager.update(kadouTimeGroup);
        }
    }

    @Transactional
    public void createTestB0019_03(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if( null != kadouTimeGroup ) {


            AT_TokuteibiKadouTime tokuteibiKadouTime = kadouTimeGroup.getTokuteibiKadouTime(ALREADYSYORIYMD);
            if ( null == tokuteibiKadouTime ) {
                tokuteibiKadouTime = kadouTimeGroup.createTokuteibiKadouTime();
                tokuteibiKadouTime.setKadouTimeSiteiYmd(ALREADYSYORIYMD);
                tokuteibiKadouTime.setKadouTimeSiteiKbn(ALREADYSITEIKBN);

                baseDomManager.update(kadouTimeGroup);
            }
        }
    }

    @Transactional
    public void deleteTestB0019_01(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {
            kadouTimeGroup.getKadouTimes().removeAll(kadouTimeGroup.getKadouTimes());
            kadouTimeGroup.getTokuteibiKadouTimes().removeAll(kadouTimeGroup.getTokuteibiKadouTimes());

            baseDomManager.update(kadouTimeGroup);
            baseDomManager.delete(kadouTimeGroup);
        }
    }

    @Transactional
    public void createTestB0020_01(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null == kadouTimeGroup ) {
            kadouTimeGroup = new AT_KadouTimeGroup();
            kadouTimeGroup.setKadouTimeGroupCd(ALREADYKADOUTIMEGROUPCD);
            kadouTimeGroup.setKadouTimeGroupNm(ALREADYKADOUTIMEGROUPNM);
            kadouTimeGroup.setHolidayGroupCd(ALREADYKADOUTIMEGROUP_HOLIDAYGROUPCD);
            kadouTimeGroup.setKadouTimeGroupDescription(ALREADYKADOUTIMEGROUPBIKOU);

            baseDomManager.insert(kadouTimeGroup);
        }
    }

    @Transactional
    public void createTestB0020_02(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {

            C_KadouTimeYoubiKbn[] kadouTimeYoubiKbns = {C_KadouTimeYoubiKbn.GETUYOU, C_KadouTimeYoubiKbn.KAYOU, C_KadouTimeYoubiKbn.SUIYOU
                , C_KadouTimeYoubiKbn.MOKUYOU, C_KadouTimeYoubiKbn.KINYOU, C_KadouTimeYoubiKbn.DOYOU, C_KadouTimeYoubiKbn.NITIYOU, C_KadouTimeYoubiKbn.HYOUJYUN};
            C_EigyoubiKbn[] eigyoubiKbns = {C_EigyoubiKbn.EIGYOUBI, C_EigyoubiKbn.HIEIGYOUBI};

            for( C_EigyoubiKbn eigyoubiKbn : eigyoubiKbns ) {
                AT_KadouTime kadouTime = null;
                for ( C_KadouTimeYoubiKbn youbiKbn : kadouTimeYoubiKbns ) {

                    kadouTime = kadouTimeGroup.getKadouTime(youbiKbn, eigyoubiKbn);
                    if ( null == kadouTime ) {

                        kadouTime = kadouTimeGroup.createKadouTime();
                        kadouTime.setEigyoubiKbn(eigyoubiKbn);
                        kadouTime.setKadouTimeYoubiKbn(youbiKbn);
                        kadouTime.setKadouTimeSiteiKbn(C_KadouTimeSiteiKbn.HYOUJUN);
                        if( C_KadouTimeYoubiKbn.HYOUJYUN.eq(youbiKbn) ) {
                            kadouTime.setKadouTimeSiteiKbn(C_KadouTimeSiteiKbn.ZENJITURIYOU_KA);
                        }
                    }

                    baseDomManager.update(kadouTimeGroup);
                }
            }
        }
    }

    @Transactional
    public void deleteTestB0020_01(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {
            kadouTimeGroup.getKadouTimes().removeAll(kadouTimeGroup.getKadouTimes());
            kadouTimeGroup.getTokuteibiKadouTimes().removeAll(kadouTimeGroup.getTokuteibiKadouTimes());

            baseDomManager.update(kadouTimeGroup);
            baseDomManager.delete(kadouTimeGroup);
        }
    }

    @Transactional
    public void createTestB0021_01(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null == kadouTimeGroup ) {
            kadouTimeGroup = new AT_KadouTimeGroup();
            kadouTimeGroup.setKadouTimeGroupCd(ALREADYKADOUTIMEGROUPCD);
            kadouTimeGroup.setKadouTimeGroupNm(ALREADYKADOUTIMEGROUPNM);
            kadouTimeGroup.setHolidayGroupCd(ALREADYKADOUTIMEGROUP_HOLIDAYGROUPCD);
            kadouTimeGroup.setKadouTimeGroupDescription(ALREADYKADOUTIMEGROUPBIKOU);

            baseDomManager.insert(kadouTimeGroup);
        }
    }


    @Transactional
    public void createTestB0021_02(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {

            C_KadouTimeYoubiKbn[] kadouTimeYoubiKbns = {C_KadouTimeYoubiKbn.GETUYOU, C_KadouTimeYoubiKbn.KAYOU, C_KadouTimeYoubiKbn.SUIYOU
                , C_KadouTimeYoubiKbn.MOKUYOU, C_KadouTimeYoubiKbn.KINYOU, C_KadouTimeYoubiKbn.DOYOU, C_KadouTimeYoubiKbn.NITIYOU, C_KadouTimeYoubiKbn.HYOUJYUN};
            C_EigyoubiKbn[] eigyoubiKbns = {C_EigyoubiKbn.EIGYOUBI, C_EigyoubiKbn.HIEIGYOUBI};

            for( C_EigyoubiKbn eigyoubiKbn : eigyoubiKbns ) {
                AT_KadouTime kadouTime = null;
                for ( C_KadouTimeYoubiKbn youbiKbn : kadouTimeYoubiKbns ) {
                    List<AT_KadouTime> kadouTimes = kadouTimeGroup.getKadouTimes();
                    if( kadouTimes.size() < 16) {

                        kadouTime = kadouTimeGroup.createKadouTime();
                        kadouTime.setEigyoubiKbn(eigyoubiKbn);
                        kadouTime.setKadouTimeYoubiKbn(youbiKbn);
                        kadouTime.setKadouTimeSiteiKbn(C_KadouTimeSiteiKbn.HYOUJUN);
                        if( C_KadouTimeYoubiKbn.HYOUJYUN.eq(youbiKbn) ) {
                            kadouTime.setKadouTimeSiteiKbn(C_KadouTimeSiteiKbn.ZENJITURIYOU_KA);
                        }
                    }
                }
            }
            baseDomManager.update(kadouTimeGroup);
        }
    }

    @Transactional
    public void createTestB0021_03(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {


            AT_TokuteibiKadouTime tokuteibiKadouTime = kadouTimeGroup.getTokuteibiKadouTime(ALREADYSYORIYMD);
            if ( null == tokuteibiKadouTime ) {
                tokuteibiKadouTime = kadouTimeGroup.createTokuteibiKadouTime();
                tokuteibiKadouTime.setKadouTimeSiteiYmd(ALREADYSYORIYMD);
                tokuteibiKadouTime.setKadouTimeSiteiKbn(ALREADYSITEIKBN);

                baseDomManager.update(kadouTimeGroup);
            }
        }
    }

    @Transactional
    public void deleteTestB0021_01(){

        baseDomManager.clear();
        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {
            kadouTimeGroup.getKadouTimes().removeAll(kadouTimeGroup.getKadouTimes());
            kadouTimeGroup.getTokuteibiKadouTimes().removeAll(kadouTimeGroup.getTokuteibiKadouTimes());

            baseDomManager.update(kadouTimeGroup);
            baseDomManager.delete(kadouTimeGroup);
        }
    }

    @Transactional
    public void createTestB0022_01(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null == kadouTimeGroup ) {
            kadouTimeGroup = new AT_KadouTimeGroup();
            kadouTimeGroup.setKadouTimeGroupCd(ALREADYKADOUTIMEGROUPCD);
            kadouTimeGroup.setKadouTimeGroupNm(ALREADYKADOUTIMEGROUPNM);
            kadouTimeGroup.setHolidayGroupCd(ALREADYKADOUTIMEGROUP_HOLIDAYGROUPCD);
            kadouTimeGroup.setKadouTimeGroupDescription(ALREADYKADOUTIMEGROUPBIKOU);

            baseDomManager.insert(kadouTimeGroup);
        }
    }


    @Transactional
    public void createTestB0022_02(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {

            C_KadouTimeYoubiKbn[] kadouTimeYoubiKbns = {C_KadouTimeYoubiKbn.GETUYOU, C_KadouTimeYoubiKbn.KAYOU, C_KadouTimeYoubiKbn.SUIYOU
                , C_KadouTimeYoubiKbn.MOKUYOU, C_KadouTimeYoubiKbn.KINYOU, C_KadouTimeYoubiKbn.DOYOU, C_KadouTimeYoubiKbn.NITIYOU, C_KadouTimeYoubiKbn.HYOUJYUN};
            C_EigyoubiKbn[] eigyoubiKbns = {C_EigyoubiKbn.EIGYOUBI, C_EigyoubiKbn.HIEIGYOUBI};

            for( C_EigyoubiKbn eigyoubiKbn : eigyoubiKbns ) {
                AT_KadouTime kadouTime = null;
                for ( C_KadouTimeYoubiKbn youbiKbn : kadouTimeYoubiKbns ) {
                    List<AT_KadouTime> kadouTimes = kadouTimeGroup.getKadouTimes();
                    if( kadouTimes.size() < 16) {

                        kadouTime = kadouTimeGroup.createKadouTime();
                        kadouTime.setEigyoubiKbn(eigyoubiKbn);
                        kadouTime.setKadouTimeYoubiKbn(youbiKbn);
                        kadouTime.setKadouTimeSiteiKbn(C_KadouTimeSiteiKbn.HYOUJUN);
                        if( C_KadouTimeYoubiKbn.HYOUJYUN.eq(youbiKbn) ) {
                            kadouTime.setKadouTimeSiteiKbn(C_KadouTimeSiteiKbn.ZENJITURIYOU_KA);
                        }
                    }
                }
            }
            baseDomManager.update(kadouTimeGroup);
        }
    }

    @Transactional
    public void createTestB0022_03(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {


            AT_TokuteibiKadouTime tokuteibiKadouTime = kadouTimeGroup.getTokuteibiKadouTime(ALREADYSYORIYMD);
            if ( null == tokuteibiKadouTime ) {
                tokuteibiKadouTime = kadouTimeGroup.createTokuteibiKadouTime();
                tokuteibiKadouTime.setKadouTimeSiteiYmd(ALREADYSYORIYMD);
                tokuteibiKadouTime.setKadouTimeSiteiKbn(ALREADYSITEIKBN);

                baseDomManager.update(kadouTimeGroup);
            }
        }
    }

    @Transactional
    public void deleteTestB0022_01(){

        baseDomManager.clear();
        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {
            kadouTimeGroup.getKadouTimes().removeAll(kadouTimeGroup.getKadouTimes());
            kadouTimeGroup.getTokuteibiKadouTimes().removeAll(kadouTimeGroup.getTokuteibiKadouTimes());

            baseDomManager.update(kadouTimeGroup);
            baseDomManager.delete(kadouTimeGroup);
        }
    }

    @Transactional
    public void createTestB0023_01(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null == kadouTimeGroup ) {
            kadouTimeGroup = new AT_KadouTimeGroup();
            kadouTimeGroup.setKadouTimeGroupCd(ALREADYKADOUTIMEGROUPCD);
            kadouTimeGroup.setKadouTimeGroupNm(ALREADYKADOUTIMEGROUPNM);
            kadouTimeGroup.setHolidayGroupCd(ALREADYKADOUTIMEGROUP_HOLIDAYGROUPCD);
            kadouTimeGroup.setKadouTimeGroupDescription(ALREADYKADOUTIMEGROUPBIKOU);

            baseDomManager.insert(kadouTimeGroup);
        }
    }


    @Transactional
    public void createTestB0023_02(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {

            C_KadouTimeYoubiKbn[] kadouTimeYoubiKbns = {C_KadouTimeYoubiKbn.GETUYOU, C_KadouTimeYoubiKbn.KAYOU, C_KadouTimeYoubiKbn.SUIYOU
                , C_KadouTimeYoubiKbn.MOKUYOU, C_KadouTimeYoubiKbn.KINYOU, C_KadouTimeYoubiKbn.DOYOU, C_KadouTimeYoubiKbn.NITIYOU, C_KadouTimeYoubiKbn.HYOUJYUN};
            C_EigyoubiKbn[] eigyoubiKbns = {C_EigyoubiKbn.EIGYOUBI, C_EigyoubiKbn.HIEIGYOUBI};

            for( C_EigyoubiKbn eigyoubiKbn : eigyoubiKbns ) {
                AT_KadouTime kadouTime = null;
                for ( C_KadouTimeYoubiKbn youbiKbn : kadouTimeYoubiKbns ) {
                    List<AT_KadouTime> kadouTimes = kadouTimeGroup.getKadouTimes();
                    if( kadouTimes.size() < 16) {

                        kadouTime = kadouTimeGroup.createKadouTime();
                        kadouTime.setEigyoubiKbn(eigyoubiKbn);
                        kadouTime.setKadouTimeYoubiKbn(youbiKbn);
                        kadouTime.setKadouTimeSiteiKbn(C_KadouTimeSiteiKbn.HYOUJUN);
                        if( C_KadouTimeYoubiKbn.HYOUJYUN.eq(youbiKbn) ) {
                            kadouTime.setKadouTimeSiteiKbn(C_KadouTimeSiteiKbn.ZENJITURIYOU_KA);
                        }
                    }
                }
            }
            baseDomManager.update(kadouTimeGroup);
        }
    }

    @Transactional
    public void createTestB0023_03(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);

        AT_TokuteibiKadouTime tokuteibiKadouTime = kadouTimeGroup.getTokuteibiKadouTime(ALREADYSYORIYMD);
        if ( null == tokuteibiKadouTime ) {
            tokuteibiKadouTime = kadouTimeGroup.createTokuteibiKadouTime();
            tokuteibiKadouTime.setKadouTimeSiteiYmd(ALREADYSYORIYMD);
            tokuteibiKadouTime.setKadouTimeSiteiKbn(ALREADYSITEIKBN);

            baseDomManager.update(kadouTimeGroup);
        }
    }

    @Transactional
    public void deleteTestB0023_01(){

        baseDomManager.clear();
        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {
            kadouTimeGroup.getKadouTimes().removeAll(kadouTimeGroup.getKadouTimes());
            kadouTimeGroup.getTokuteibiKadouTimes().removeAll(kadouTimeGroup.getTokuteibiKadouTimes());

            baseDomManager.update(kadouTimeGroup);
            baseDomManager.delete(kadouTimeGroup);
        }
    }

    @Transactional
    public void createTestL0001_01(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null == kadouTimeGroup ) {
            kadouTimeGroup = new AT_KadouTimeGroup();
            kadouTimeGroup.setKadouTimeGroupCd(ALREADYKADOUTIMEGROUPCD);
            kadouTimeGroup.setKadouTimeGroupNm(ALREADYKADOUTIMEGROUPNM);
            kadouTimeGroup.setHolidayGroupCd(ALREADYKADOUTIMEGROUP_HOLIDAYGROUPCD);
            kadouTimeGroup.setKadouTimeGroupDescription(ALREADYKADOUTIMEGROUPBIKOU);

            baseDomManager.insert(kadouTimeGroup);
        }
    }


    @Transactional
    public void createTestL0001_02(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {

            C_KadouTimeYoubiKbn[] kadouTimeYoubiKbns = {C_KadouTimeYoubiKbn.GETUYOU, C_KadouTimeYoubiKbn.KAYOU, C_KadouTimeYoubiKbn.SUIYOU
                , C_KadouTimeYoubiKbn.MOKUYOU, C_KadouTimeYoubiKbn.KINYOU, C_KadouTimeYoubiKbn.DOYOU, C_KadouTimeYoubiKbn.NITIYOU, C_KadouTimeYoubiKbn.HYOUJYUN};
            C_EigyoubiKbn[] eigyoubiKbns = {C_EigyoubiKbn.EIGYOUBI, C_EigyoubiKbn.HIEIGYOUBI};

            for( C_EigyoubiKbn eigyoubiKbn : eigyoubiKbns ) {
                AT_KadouTime kadouTime = null;
                for ( C_KadouTimeYoubiKbn youbiKbn : kadouTimeYoubiKbns ) {
                    List<AT_KadouTime> kadouTimes = kadouTimeGroup.getKadouTimes();
                    if( kadouTimes.size() < 16) {

                        kadouTime = kadouTimeGroup.createKadouTime();
                        kadouTime.setEigyoubiKbn(eigyoubiKbn);
                        kadouTime.setKadouTimeYoubiKbn(youbiKbn);
                        kadouTime.setKadouTimeSiteiKbn(C_KadouTimeSiteiKbn.HYOUJUN);
                        if( C_KadouTimeYoubiKbn.HYOUJYUN.eq(youbiKbn) ) {
                            kadouTime.setKadouTimeSiteiKbn(C_KadouTimeSiteiKbn.ZENJITURIYOU_KA);
                        }
                    }
                }
            }
            baseDomManager.update(kadouTimeGroup);
        }
    }

    @Transactional
    public void deleteTestL0001_01(){

        baseDomManager.clear();
        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {
            kadouTimeGroup.getKadouTimes().removeAll(kadouTimeGroup.getKadouTimes());
            kadouTimeGroup.getTokuteibiKadouTimes().removeAll(kadouTimeGroup.getTokuteibiKadouTimes());

            baseDomManager.update(kadouTimeGroup);
            baseDomManager.delete(kadouTimeGroup);
        }
    }

    @Transactional
    public void createTestL0002_01(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null == kadouTimeGroup ) {
            kadouTimeGroup = new AT_KadouTimeGroup();
            kadouTimeGroup.setKadouTimeGroupCd(ALREADYKADOUTIMEGROUPCD);
            kadouTimeGroup.setKadouTimeGroupNm(ALREADYKADOUTIMEGROUPNM);
            kadouTimeGroup.setHolidayGroupCd(ALREADYKADOUTIMEGROUP_HOLIDAYGROUPCD);
            kadouTimeGroup.setKadouTimeGroupDescription(ALREADYKADOUTIMEGROUPBIKOU);

            baseDomManager.insert(kadouTimeGroup);
        }
    }


    @Transactional
    public void createTestL0002_02(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {

            C_KadouTimeYoubiKbn[] kadouTimeYoubiKbns = {C_KadouTimeYoubiKbn.GETUYOU, C_KadouTimeYoubiKbn.KAYOU, C_KadouTimeYoubiKbn.SUIYOU
                , C_KadouTimeYoubiKbn.MOKUYOU, C_KadouTimeYoubiKbn.KINYOU, C_KadouTimeYoubiKbn.DOYOU, C_KadouTimeYoubiKbn.NITIYOU, C_KadouTimeYoubiKbn.HYOUJYUN};
            C_EigyoubiKbn[] eigyoubiKbns = {C_EigyoubiKbn.EIGYOUBI, C_EigyoubiKbn.HIEIGYOUBI};

            for( C_EigyoubiKbn eigyoubiKbn : eigyoubiKbns ) {
                AT_KadouTime kadouTime = null;
                for ( C_KadouTimeYoubiKbn youbiKbn : kadouTimeYoubiKbns ) {
                    List<AT_KadouTime> kadouTimes = kadouTimeGroup.getKadouTimes();
                    if( kadouTimes.size() < 16) {

                        kadouTime = kadouTimeGroup.createKadouTime();
                        kadouTime.setEigyoubiKbn(eigyoubiKbn);
                        kadouTime.setKadouTimeYoubiKbn(youbiKbn);
                        kadouTime.setKadouTimeSiteiKbn(C_KadouTimeSiteiKbn.HYOUJUN);
                        if( C_KadouTimeYoubiKbn.HYOUJYUN.eq(youbiKbn) ) {
                            kadouTime.setKadouTimeSiteiKbn(C_KadouTimeSiteiKbn.ZENJITURIYOU_KA);
                        }
                    }
                }
            }
            baseDomManager.update(kadouTimeGroup);
        }
    }

    @Transactional
    public void deleteTestL0002_01(){

        baseDomManager.clear();
        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {
            kadouTimeGroup.getKadouTimes().removeAll(kadouTimeGroup.getKadouTimes());
            kadouTimeGroup.getTokuteibiKadouTimes().removeAll(kadouTimeGroup.getTokuteibiKadouTimes());

            baseDomManager.update(kadouTimeGroup);
            baseDomManager.delete(kadouTimeGroup);
        }
    }

    @Transactional
    public void createTestL0003_01(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null == kadouTimeGroup ) {
            kadouTimeGroup = new AT_KadouTimeGroup();
            kadouTimeGroup.setKadouTimeGroupCd(ALREADYKADOUTIMEGROUPCD);
            kadouTimeGroup.setKadouTimeGroupNm(ALREADYKADOUTIMEGROUPNM);
            kadouTimeGroup.setHolidayGroupCd(ALREADYKADOUTIMEGROUP_HOLIDAYGROUPCD);
            kadouTimeGroup.setKadouTimeGroupDescription(ALREADYKADOUTIMEGROUPBIKOU);

            baseDomManager.insert(kadouTimeGroup);
        }
    }


    @Transactional
    public void createTestL0003_02(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {

            C_KadouTimeYoubiKbn[] kadouTimeYoubiKbns = {C_KadouTimeYoubiKbn.GETUYOU, C_KadouTimeYoubiKbn.KAYOU, C_KadouTimeYoubiKbn.SUIYOU
                , C_KadouTimeYoubiKbn.MOKUYOU, C_KadouTimeYoubiKbn.KINYOU, C_KadouTimeYoubiKbn.DOYOU, C_KadouTimeYoubiKbn.NITIYOU, C_KadouTimeYoubiKbn.HYOUJYUN};
            C_EigyoubiKbn[] eigyoubiKbns = {C_EigyoubiKbn.EIGYOUBI, C_EigyoubiKbn.HIEIGYOUBI};

            for( C_EigyoubiKbn eigyoubiKbn : eigyoubiKbns ) {
                AT_KadouTime kadouTime = null;
                for ( C_KadouTimeYoubiKbn youbiKbn : kadouTimeYoubiKbns ) {
                    List<AT_KadouTime> kadouTimes = kadouTimeGroup.getKadouTimes();
                    if( kadouTimes.size() < 16) {

                        kadouTime = kadouTimeGroup.createKadouTime();
                        kadouTime.setEigyoubiKbn(eigyoubiKbn);
                        kadouTime.setKadouTimeYoubiKbn(youbiKbn);
                        kadouTime.setKadouTimeSiteiKbn(C_KadouTimeSiteiKbn.HYOUJUN);
                        if( C_KadouTimeYoubiKbn.HYOUJYUN.eq(youbiKbn) ) {
                            kadouTime.setKadouTimeSiteiKbn(C_KadouTimeSiteiKbn.ZENJITURIYOU_KA);
                        }
                    }
                }
            }
            baseDomManager.update(kadouTimeGroup);
        }
    }

    @Transactional
    public void deleteTestL0003_01(){

        baseDomManager.clear();
        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {
            kadouTimeGroup.getKadouTimes().removeAll(kadouTimeGroup.getKadouTimes());
            kadouTimeGroup.getTokuteibiKadouTimes().removeAll(kadouTimeGroup.getTokuteibiKadouTimes());

            baseDomManager.update(kadouTimeGroup);
            baseDomManager.delete(kadouTimeGroup);
        }
    }

    @Transactional
    public void createTestL0004_01(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null == kadouTimeGroup ) {
            kadouTimeGroup = new AT_KadouTimeGroup();
            kadouTimeGroup.setKadouTimeGroupCd(ALREADYKADOUTIMEGROUPCD);
            kadouTimeGroup.setKadouTimeGroupNm(ALREADYKADOUTIMEGROUPNM);
            kadouTimeGroup.setHolidayGroupCd(ALREADYKADOUTIMEGROUP_HOLIDAYGROUPCD);
            kadouTimeGroup.setKadouTimeGroupDescription(ALREADYKADOUTIMEGROUPBIKOU);

            baseDomManager.insert(kadouTimeGroup);
        }
    }


    @Transactional
    public void createTestL0004_02(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {

            C_KadouTimeYoubiKbn[] kadouTimeYoubiKbns = {C_KadouTimeYoubiKbn.GETUYOU, C_KadouTimeYoubiKbn.KAYOU, C_KadouTimeYoubiKbn.SUIYOU
                , C_KadouTimeYoubiKbn.MOKUYOU, C_KadouTimeYoubiKbn.KINYOU, C_KadouTimeYoubiKbn.DOYOU, C_KadouTimeYoubiKbn.NITIYOU, C_KadouTimeYoubiKbn.HYOUJYUN};
            C_EigyoubiKbn[] eigyoubiKbns = {C_EigyoubiKbn.EIGYOUBI, C_EigyoubiKbn.HIEIGYOUBI};

            for( C_EigyoubiKbn eigyoubiKbn : eigyoubiKbns ) {
                AT_KadouTime kadouTime = null;
                for ( C_KadouTimeYoubiKbn youbiKbn : kadouTimeYoubiKbns ) {
                    List<AT_KadouTime> kadouTimes = kadouTimeGroup.getKadouTimes();
                    if( kadouTimes.size() < 16) {

                        kadouTime = kadouTimeGroup.createKadouTime();
                        kadouTime.setEigyoubiKbn(eigyoubiKbn);
                        kadouTime.setKadouTimeYoubiKbn(youbiKbn);
                        kadouTime.setKadouTimeSiteiKbn(C_KadouTimeSiteiKbn.HYOUJUN);
                        if( C_KadouTimeYoubiKbn.HYOUJYUN.eq(youbiKbn) ) {
                            kadouTime.setKadouTimeSiteiKbn(C_KadouTimeSiteiKbn.ZENJITURIYOU_KA);
                        }
                    }
                }
            }
            baseDomManager.update(kadouTimeGroup);
        }
    }

    @Transactional
    public void deleteTestL0004_01(){

        baseDomManager.clear();
        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {
            kadouTimeGroup.getKadouTimes().removeAll(kadouTimeGroup.getKadouTimes());
            kadouTimeGroup.getTokuteibiKadouTimes().removeAll(kadouTimeGroup.getTokuteibiKadouTimes());

            baseDomManager.update(kadouTimeGroup);
            baseDomManager.delete(kadouTimeGroup);
        }
    }

    @Transactional
    public void createTestL0005_01(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null == kadouTimeGroup ) {
            kadouTimeGroup = new AT_KadouTimeGroup();
            kadouTimeGroup.setKadouTimeGroupCd(ALREADYKADOUTIMEGROUPCD);
            kadouTimeGroup.setKadouTimeGroupNm(ALREADYKADOUTIMEGROUPNM);
            kadouTimeGroup.setHolidayGroupCd(ALREADYKADOUTIMEGROUP_HOLIDAYGROUPCD);
            kadouTimeGroup.setKadouTimeGroupDescription(ALREADYKADOUTIMEGROUPBIKOU);

            baseDomManager.insert(kadouTimeGroup);
        }
    }


    @Transactional
    public void createTestL0005_02(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {

            C_KadouTimeYoubiKbn[] kadouTimeYoubiKbns = {C_KadouTimeYoubiKbn.GETUYOU, C_KadouTimeYoubiKbn.KAYOU, C_KadouTimeYoubiKbn.SUIYOU
                , C_KadouTimeYoubiKbn.MOKUYOU, C_KadouTimeYoubiKbn.KINYOU, C_KadouTimeYoubiKbn.DOYOU, C_KadouTimeYoubiKbn.NITIYOU, C_KadouTimeYoubiKbn.HYOUJYUN};
            C_EigyoubiKbn[] eigyoubiKbns = {C_EigyoubiKbn.EIGYOUBI, C_EigyoubiKbn.HIEIGYOUBI};

            for( C_EigyoubiKbn eigyoubiKbn : eigyoubiKbns ) {
                AT_KadouTime kadouTime = null;
                for ( C_KadouTimeYoubiKbn youbiKbn : kadouTimeYoubiKbns ) {
                    List<AT_KadouTime> kadouTimes = kadouTimeGroup.getKadouTimes();
                    if( kadouTimes.size() < 16) {

                        kadouTime = kadouTimeGroup.createKadouTime();
                        kadouTime.setEigyoubiKbn(eigyoubiKbn);
                        kadouTime.setKadouTimeYoubiKbn(youbiKbn);
                        kadouTime.setKadouTimeSiteiKbn(C_KadouTimeSiteiKbn.HYOUJUN);
                        if( C_KadouTimeYoubiKbn.HYOUJYUN.eq(youbiKbn) ) {
                            kadouTime.setKadouTimeSiteiKbn(C_KadouTimeSiteiKbn.ZENJITURIYOU_KA);
                        }
                    }
                }
            }
            baseDomManager.update(kadouTimeGroup);
        }
    }

    @Transactional
    public void deleteTestL0005_01(){

        baseDomManager.clear();
        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {
            kadouTimeGroup.getKadouTimes().removeAll(kadouTimeGroup.getKadouTimes());
            kadouTimeGroup.getTokuteibiKadouTimes().removeAll(kadouTimeGroup.getTokuteibiKadouTimes());

            baseDomManager.update(kadouTimeGroup);
            baseDomManager.delete(kadouTimeGroup);
        }
    }

    @Transactional
    public void createTestL0006_01(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null == kadouTimeGroup ) {
            kadouTimeGroup = new AT_KadouTimeGroup();
            kadouTimeGroup.setKadouTimeGroupCd(ALREADYKADOUTIMEGROUPCD);
            kadouTimeGroup.setKadouTimeGroupNm(ALREADYKADOUTIMEGROUPNM);
            kadouTimeGroup.setHolidayGroupCd(ALREADYKADOUTIMEGROUP_HOLIDAYGROUPCD);
            kadouTimeGroup.setKadouTimeGroupDescription(ALREADYKADOUTIMEGROUPBIKOU);

            baseDomManager.insert(kadouTimeGroup);
        }
    }


    @Transactional
    public void createTestL0006_02(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {

            C_KadouTimeYoubiKbn[] kadouTimeYoubiKbns = {C_KadouTimeYoubiKbn.GETUYOU, C_KadouTimeYoubiKbn.KAYOU, C_KadouTimeYoubiKbn.SUIYOU
                , C_KadouTimeYoubiKbn.MOKUYOU, C_KadouTimeYoubiKbn.KINYOU, C_KadouTimeYoubiKbn.DOYOU, C_KadouTimeYoubiKbn.NITIYOU, C_KadouTimeYoubiKbn.HYOUJYUN};
            C_EigyoubiKbn[] eigyoubiKbns = {C_EigyoubiKbn.EIGYOUBI, C_EigyoubiKbn.HIEIGYOUBI};

            for( C_EigyoubiKbn eigyoubiKbn : eigyoubiKbns ) {
                AT_KadouTime kadouTime = null;
                for ( C_KadouTimeYoubiKbn youbiKbn : kadouTimeYoubiKbns ) {
                    List<AT_KadouTime> kadouTimes = kadouTimeGroup.getKadouTimes();
                    if( kadouTimes.size() < 16) {

                        kadouTime = kadouTimeGroup.createKadouTime();
                        kadouTime.setEigyoubiKbn(eigyoubiKbn);
                        kadouTime.setKadouTimeYoubiKbn(youbiKbn);
                        kadouTime.setKadouTimeSiteiKbn(C_KadouTimeSiteiKbn.HYOUJUN);
                        if( C_KadouTimeYoubiKbn.HYOUJYUN.eq(youbiKbn) ) {
                            kadouTime.setKadouTimeSiteiKbn(C_KadouTimeSiteiKbn.ZENJITURIYOU_KA);
                        }
                    }
                }
            }
            baseDomManager.update(kadouTimeGroup);
        }
    }

    @Transactional
    public void createTestL0006_03(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);

        AT_TokuteibiKadouTime tokuteibiKadouTime = kadouTimeGroup.getTokuteibiKadouTime(ALREADYSYORIYMD);
        if ( null == tokuteibiKadouTime ) {
            tokuteibiKadouTime = kadouTimeGroup.createTokuteibiKadouTime();
            tokuteibiKadouTime.setKadouTimeSiteiYmd(ALREADYSYORIYMD);
            tokuteibiKadouTime.setKadouTimeSiteiKbn(ALREADYSITEIKBN);

            baseDomManager.update(kadouTimeGroup);
        }
    }

    @Transactional
    public void deleteTestL0006_01(){

        baseDomManager.clear();
        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {
            kadouTimeGroup.getKadouTimes().removeAll(kadouTimeGroup.getKadouTimes());
            kadouTimeGroup.getTokuteibiKadouTimes().removeAll(kadouTimeGroup.getTokuteibiKadouTimes());

            baseDomManager.update(kadouTimeGroup);
            baseDomManager.delete(kadouTimeGroup);
        }
    }

    @Transactional
    public void createTestL0007_01(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null == kadouTimeGroup ) {
            kadouTimeGroup = new AT_KadouTimeGroup();
            kadouTimeGroup.setKadouTimeGroupCd(ALREADYKADOUTIMEGROUPCD);
            kadouTimeGroup.setKadouTimeGroupNm(ALREADYKADOUTIMEGROUPNM);
            kadouTimeGroup.setHolidayGroupCd(ALREADYKADOUTIMEGROUP_HOLIDAYGROUPCD);
            kadouTimeGroup.setKadouTimeGroupDescription(ALREADYKADOUTIMEGROUPBIKOU);

            baseDomManager.insert(kadouTimeGroup);
        }
    }


    @Transactional
    public void createTestL0007_02(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {

            C_KadouTimeYoubiKbn[] kadouTimeYoubiKbns = {C_KadouTimeYoubiKbn.GETUYOU, C_KadouTimeYoubiKbn.KAYOU, C_KadouTimeYoubiKbn.SUIYOU
                , C_KadouTimeYoubiKbn.MOKUYOU, C_KadouTimeYoubiKbn.KINYOU, C_KadouTimeYoubiKbn.DOYOU, C_KadouTimeYoubiKbn.NITIYOU, C_KadouTimeYoubiKbn.HYOUJYUN};
            C_EigyoubiKbn[] eigyoubiKbns = {C_EigyoubiKbn.EIGYOUBI, C_EigyoubiKbn.HIEIGYOUBI};

            for( C_EigyoubiKbn eigyoubiKbn : eigyoubiKbns ) {
                AT_KadouTime kadouTime = null;
                for ( C_KadouTimeYoubiKbn youbiKbn : kadouTimeYoubiKbns ) {
                    List<AT_KadouTime> kadouTimes = kadouTimeGroup.getKadouTimes();
                    if( kadouTimes.size() < 16) {

                        kadouTime = kadouTimeGroup.createKadouTime();
                        kadouTime.setEigyoubiKbn(eigyoubiKbn);
                        kadouTime.setKadouTimeYoubiKbn(youbiKbn);
                        kadouTime.setKadouTimeSiteiKbn(C_KadouTimeSiteiKbn.HYOUJUN);
                        if( C_KadouTimeYoubiKbn.HYOUJYUN.eq(youbiKbn) ) {
                            kadouTime.setKadouTimeSiteiKbn(C_KadouTimeSiteiKbn.ZENJITURIYOU_KA);
                        }
                    }
                }
            }
            baseDomManager.update(kadouTimeGroup);
        }
    }

    @Transactional
    public void createTestL0007_03(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);

        AT_TokuteibiKadouTime tokuteibiKadouTime = kadouTimeGroup.getTokuteibiKadouTime(ALREADYSYORIYMD);
        if ( null == tokuteibiKadouTime ) {
            tokuteibiKadouTime = kadouTimeGroup.createTokuteibiKadouTime();
            tokuteibiKadouTime.setKadouTimeSiteiYmd(ALREADYSYORIYMD);
            tokuteibiKadouTime.setKadouTimeSiteiKbn(ALREADYSITEIKBN);

            baseDomManager.update(kadouTimeGroup);
        }
    }

    @Transactional
    public void deleteTestL0007_01(){

        baseDomManager.clear();
        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {
            kadouTimeGroup.getKadouTimes().removeAll(kadouTimeGroup.getKadouTimes());
            kadouTimeGroup.getTokuteibiKadouTimes().removeAll(kadouTimeGroup.getTokuteibiKadouTimes());

            baseDomManager.update(kadouTimeGroup);
            baseDomManager.delete(kadouTimeGroup);
        }
    }

    @Transactional
    public void createTestL0008_01(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null == kadouTimeGroup ) {
            kadouTimeGroup = new AT_KadouTimeGroup();
            kadouTimeGroup.setKadouTimeGroupCd(ALREADYKADOUTIMEGROUPCD);
            kadouTimeGroup.setKadouTimeGroupNm(ALREADYKADOUTIMEGROUPNM);
            kadouTimeGroup.setHolidayGroupCd(ALREADYKADOUTIMEGROUP_HOLIDAYGROUPCD);
            kadouTimeGroup.setKadouTimeGroupDescription(ALREADYKADOUTIMEGROUPBIKOU);

            baseDomManager.insert(kadouTimeGroup);
        }
    }


    @Transactional
    public void createTestL0008_02(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {

            C_KadouTimeYoubiKbn[] kadouTimeYoubiKbns = {C_KadouTimeYoubiKbn.GETUYOU, C_KadouTimeYoubiKbn.KAYOU, C_KadouTimeYoubiKbn.SUIYOU
                , C_KadouTimeYoubiKbn.MOKUYOU, C_KadouTimeYoubiKbn.KINYOU, C_KadouTimeYoubiKbn.DOYOU, C_KadouTimeYoubiKbn.NITIYOU, C_KadouTimeYoubiKbn.HYOUJYUN};
            C_EigyoubiKbn[] eigyoubiKbns = {C_EigyoubiKbn.EIGYOUBI, C_EigyoubiKbn.HIEIGYOUBI};

            for( C_EigyoubiKbn eigyoubiKbn : eigyoubiKbns ) {
                AT_KadouTime kadouTime = null;
                for ( C_KadouTimeYoubiKbn youbiKbn : kadouTimeYoubiKbns ) {
                    List<AT_KadouTime> kadouTimes = kadouTimeGroup.getKadouTimes();
                    if( kadouTimes.size() < 16) {

                        kadouTime = kadouTimeGroup.createKadouTime();
                        kadouTime.setEigyoubiKbn(eigyoubiKbn);
                        kadouTime.setKadouTimeYoubiKbn(youbiKbn);
                        kadouTime.setKadouTimeSiteiKbn(C_KadouTimeSiteiKbn.HYOUJUN);
                        if( C_KadouTimeYoubiKbn.HYOUJYUN.eq(youbiKbn) ) {
                            kadouTime.setKadouTimeSiteiKbn(C_KadouTimeSiteiKbn.ZENJITURIYOU_KA);
                        }
                    }
                }
            }
            baseDomManager.update(kadouTimeGroup);
        }
    }

    @Transactional
    public void createTestL0008_03(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);

        AT_TokuteibiKadouTime tokuteibiKadouTime = kadouTimeGroup.getTokuteibiKadouTime(ALREADYSYORIYMD);
        if ( null == tokuteibiKadouTime ) {
            tokuteibiKadouTime = kadouTimeGroup.createTokuteibiKadouTime();
            tokuteibiKadouTime.setKadouTimeSiteiYmd(ALREADYSYORIYMD);
            tokuteibiKadouTime.setKadouTimeSiteiKbn(ALREADYSITEIKBN);

            baseDomManager.update(kadouTimeGroup);
        }
    }

    @Transactional
    public void deleteTestL0008_01(){

        baseDomManager.clear();
        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {
            kadouTimeGroup.getKadouTimes().removeAll(kadouTimeGroup.getKadouTimes());
            kadouTimeGroup.getTokuteibiKadouTimes().removeAll(kadouTimeGroup.getTokuteibiKadouTimes());

            baseDomManager.update(kadouTimeGroup);
            baseDomManager.delete(kadouTimeGroup);
        }
    }

    @Transactional
    public void createTestL0009_01(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null == kadouTimeGroup ) {
            kadouTimeGroup = new AT_KadouTimeGroup();
            kadouTimeGroup.setKadouTimeGroupCd(ALREADYKADOUTIMEGROUPCD);
            kadouTimeGroup.setKadouTimeGroupNm(ALREADYKADOUTIMEGROUPNM);
            kadouTimeGroup.setHolidayGroupCd(ALREADYKADOUTIMEGROUP_HOLIDAYGROUPCD);
            kadouTimeGroup.setKadouTimeGroupDescription(ALREADYKADOUTIMEGROUPBIKOU);

            baseDomManager.insert(kadouTimeGroup);
        }
    }


    @Transactional
    public void createTestL0009_02(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {

            C_KadouTimeYoubiKbn[] kadouTimeYoubiKbns = {C_KadouTimeYoubiKbn.GETUYOU, C_KadouTimeYoubiKbn.KAYOU, C_KadouTimeYoubiKbn.SUIYOU
                , C_KadouTimeYoubiKbn.MOKUYOU, C_KadouTimeYoubiKbn.KINYOU, C_KadouTimeYoubiKbn.DOYOU, C_KadouTimeYoubiKbn.NITIYOU, C_KadouTimeYoubiKbn.HYOUJYUN};
            C_EigyoubiKbn[] eigyoubiKbns = {C_EigyoubiKbn.EIGYOUBI, C_EigyoubiKbn.HIEIGYOUBI};

            for( C_EigyoubiKbn eigyoubiKbn : eigyoubiKbns ) {
                AT_KadouTime kadouTime = null;
                for ( C_KadouTimeYoubiKbn youbiKbn : kadouTimeYoubiKbns ) {
                    List<AT_KadouTime> kadouTimes = kadouTimeGroup.getKadouTimes();
                    if( kadouTimes.size() < 16) {

                        kadouTime = kadouTimeGroup.createKadouTime();
                        kadouTime.setEigyoubiKbn(eigyoubiKbn);
                        kadouTime.setKadouTimeYoubiKbn(youbiKbn);
                        kadouTime.setKadouTimeSiteiKbn(C_KadouTimeSiteiKbn.HYOUJUN);
                        if( C_KadouTimeYoubiKbn.HYOUJYUN.eq(youbiKbn) ) {
                            kadouTime.setKadouTimeSiteiKbn(C_KadouTimeSiteiKbn.ZENJITURIYOU_KA);
                        }
                    }
                }
            }
            baseDomManager.update(kadouTimeGroup);
        }
    }

    @Transactional
    public void createTestL0009_03(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);

        AT_TokuteibiKadouTime tokuteibiKadouTime = kadouTimeGroup.getTokuteibiKadouTime(ALREADYSYORIYMD);
        if ( null == tokuteibiKadouTime ) {
            tokuteibiKadouTime = kadouTimeGroup.createTokuteibiKadouTime();
            tokuteibiKadouTime.setKadouTimeSiteiYmd(ALREADYSYORIYMD);
            tokuteibiKadouTime.setKadouTimeSiteiKbn(ALREADYSITEIKBN);

            baseDomManager.update(kadouTimeGroup);
        }
    }

    @Transactional
    public void deleteTestL0009_01(){

        baseDomManager.clear();
        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {
            kadouTimeGroup.getKadouTimes().removeAll(kadouTimeGroup.getKadouTimes());
            kadouTimeGroup.getTokuteibiKadouTimes().removeAll(kadouTimeGroup.getTokuteibiKadouTimes());

            baseDomManager.update(kadouTimeGroup);
            baseDomManager.delete(kadouTimeGroup);
        }
    }

    @Transactional
    public void createTestL0010_01(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null == kadouTimeGroup ) {
            kadouTimeGroup = new AT_KadouTimeGroup();
            kadouTimeGroup.setKadouTimeGroupCd(ALREADYKADOUTIMEGROUPCD);
            kadouTimeGroup.setKadouTimeGroupNm(ALREADYKADOUTIMEGROUPNM);
            kadouTimeGroup.setHolidayGroupCd(ALREADYKADOUTIMEGROUP_HOLIDAYGROUPCD);
            kadouTimeGroup.setKadouTimeGroupDescription(ALREADYKADOUTIMEGROUPBIKOU);

            baseDomManager.insert(kadouTimeGroup);
        }
    }


    @Transactional
    public void createTestL0010_02(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {

            C_KadouTimeYoubiKbn[] kadouTimeYoubiKbns = {C_KadouTimeYoubiKbn.GETUYOU, C_KadouTimeYoubiKbn.KAYOU, C_KadouTimeYoubiKbn.SUIYOU
                , C_KadouTimeYoubiKbn.MOKUYOU, C_KadouTimeYoubiKbn.KINYOU, C_KadouTimeYoubiKbn.DOYOU, C_KadouTimeYoubiKbn.NITIYOU, C_KadouTimeYoubiKbn.HYOUJYUN};
            C_EigyoubiKbn[] eigyoubiKbns = {C_EigyoubiKbn.EIGYOUBI, C_EigyoubiKbn.HIEIGYOUBI};

            for( C_EigyoubiKbn eigyoubiKbn : eigyoubiKbns ) {
                AT_KadouTime kadouTime = null;
                for ( C_KadouTimeYoubiKbn youbiKbn : kadouTimeYoubiKbns ) {
                    List<AT_KadouTime> kadouTimes = kadouTimeGroup.getKadouTimes();
                    if( kadouTimes.size() < 16) {

                        kadouTime = kadouTimeGroup.createKadouTime();
                        kadouTime.setEigyoubiKbn(eigyoubiKbn);
                        kadouTime.setKadouTimeYoubiKbn(youbiKbn);
                        kadouTime.setKadouTimeSiteiKbn(C_KadouTimeSiteiKbn.HYOUJUN);
                        if( C_KadouTimeYoubiKbn.HYOUJYUN.eq(youbiKbn) ) {
                            kadouTime.setKadouTimeSiteiKbn(C_KadouTimeSiteiKbn.ZENJITURIYOU_KA);
                        }
                    }
                }
            }
            baseDomManager.update(kadouTimeGroup);
        }
    }

    @Transactional
    public void createTestL0010_03(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);

        AT_TokuteibiKadouTime tokuteibiKadouTime = kadouTimeGroup.getTokuteibiKadouTime(ALREADYSYORIYMD);
        if ( null == tokuteibiKadouTime ) {
            tokuteibiKadouTime = kadouTimeGroup.createTokuteibiKadouTime();
            tokuteibiKadouTime.setKadouTimeSiteiYmd(ALREADYSYORIYMD);
            tokuteibiKadouTime.setKadouTimeSiteiKbn(ALREADYSITEIKBN);

            baseDomManager.update(kadouTimeGroup);
        }
    }

    @Transactional
    public void deleteTestL0010_01(){

        baseDomManager.clear();
        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {
            kadouTimeGroup.getKadouTimes().removeAll(kadouTimeGroup.getKadouTimes());
            kadouTimeGroup.getTokuteibiKadouTimes().removeAll(kadouTimeGroup.getTokuteibiKadouTimes());

            baseDomManager.update(kadouTimeGroup);
            baseDomManager.delete(kadouTimeGroup);
        }
    }

    @Transactional
    public void createTestL0011_01(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null == kadouTimeGroup ) {
            kadouTimeGroup = new AT_KadouTimeGroup();
            kadouTimeGroup.setKadouTimeGroupCd(ALREADYKADOUTIMEGROUPCD);
            kadouTimeGroup.setKadouTimeGroupNm(ALREADYKADOUTIMEGROUPNM);
            kadouTimeGroup.setHolidayGroupCd(ALREADYKADOUTIMEGROUP_HOLIDAYGROUPCD);
            kadouTimeGroup.setKadouTimeGroupDescription(ALREADYKADOUTIMEGROUPBIKOU);

            baseDomManager.insert(kadouTimeGroup);
        }
    }


    @Transactional
    public void createTestL0011_02(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {

            C_KadouTimeYoubiKbn[] kadouTimeYoubiKbns = {C_KadouTimeYoubiKbn.GETUYOU, C_KadouTimeYoubiKbn.KAYOU, C_KadouTimeYoubiKbn.SUIYOU
                , C_KadouTimeYoubiKbn.MOKUYOU, C_KadouTimeYoubiKbn.KINYOU, C_KadouTimeYoubiKbn.DOYOU, C_KadouTimeYoubiKbn.NITIYOU, C_KadouTimeYoubiKbn.HYOUJYUN};
            C_EigyoubiKbn[] eigyoubiKbns = {C_EigyoubiKbn.EIGYOUBI, C_EigyoubiKbn.HIEIGYOUBI};

            for( C_EigyoubiKbn eigyoubiKbn : eigyoubiKbns ) {
                AT_KadouTime kadouTime = null;
                for ( C_KadouTimeYoubiKbn youbiKbn : kadouTimeYoubiKbns ) {
                    List<AT_KadouTime> kadouTimes = kadouTimeGroup.getKadouTimes();
                    if( kadouTimes.size() < 16) {

                        kadouTime = kadouTimeGroup.createKadouTime();
                        kadouTime.setEigyoubiKbn(eigyoubiKbn);
                        kadouTime.setKadouTimeYoubiKbn(youbiKbn);
                        kadouTime.setKadouTimeSiteiKbn(C_KadouTimeSiteiKbn.HYOUJUN);
                        if( C_KadouTimeYoubiKbn.HYOUJYUN.eq(youbiKbn) ) {
                            kadouTime.setKadouTimeSiteiKbn(C_KadouTimeSiteiKbn.ZENJITURIYOU_KA);
                        }
                    }
                }
            }
            baseDomManager.update(kadouTimeGroup);
        }
    }

    @Transactional
    public void createTestL0011_03(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);

        AT_TokuteibiKadouTime tokuteibiKadouTime = kadouTimeGroup.getTokuteibiKadouTime(ALREADYSYORIYMD);
        if ( null == tokuteibiKadouTime ) {
            tokuteibiKadouTime = kadouTimeGroup.createTokuteibiKadouTime();
            tokuteibiKadouTime.setKadouTimeSiteiYmd(ALREADYSYORIYMD);
            tokuteibiKadouTime.setKadouTimeSiteiKbn(ALREADYSITEIKBN);

            baseDomManager.update(kadouTimeGroup);
        }
    }

    @Transactional
    public void deleteTestL0011_01(){

        baseDomManager.clear();
        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {
            kadouTimeGroup.getKadouTimes().removeAll(kadouTimeGroup.getKadouTimes());
            kadouTimeGroup.getTokuteibiKadouTimes().removeAll(kadouTimeGroup.getTokuteibiKadouTimes());

            baseDomManager.update(kadouTimeGroup);
            baseDomManager.delete(kadouTimeGroup);
        }
    }

    @Transactional
    public void createTestL0012_01(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null == kadouTimeGroup ) {
            kadouTimeGroup = new AT_KadouTimeGroup();
            kadouTimeGroup.setKadouTimeGroupCd(ALREADYKADOUTIMEGROUPCD);
            kadouTimeGroup.setKadouTimeGroupNm(ALREADYKADOUTIMEGROUPNM);
            kadouTimeGroup.setHolidayGroupCd(ALREADYKADOUTIMEGROUP_HOLIDAYGROUPCD);
            kadouTimeGroup.setKadouTimeGroupDescription(ALREADYKADOUTIMEGROUPBIKOU);

            baseDomManager.insert(kadouTimeGroup);
        }
    }


    @Transactional
    public void createTestL0012_02(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {

            C_KadouTimeYoubiKbn[] kadouTimeYoubiKbns = {C_KadouTimeYoubiKbn.GETUYOU, C_KadouTimeYoubiKbn.KAYOU, C_KadouTimeYoubiKbn.SUIYOU
                , C_KadouTimeYoubiKbn.MOKUYOU, C_KadouTimeYoubiKbn.KINYOU, C_KadouTimeYoubiKbn.DOYOU, C_KadouTimeYoubiKbn.NITIYOU, C_KadouTimeYoubiKbn.HYOUJYUN};
            C_EigyoubiKbn[] eigyoubiKbns = {C_EigyoubiKbn.EIGYOUBI, C_EigyoubiKbn.HIEIGYOUBI};

            for( C_EigyoubiKbn eigyoubiKbn : eigyoubiKbns ) {
                AT_KadouTime kadouTime = null;
                for ( C_KadouTimeYoubiKbn youbiKbn : kadouTimeYoubiKbns ) {
                    List<AT_KadouTime> kadouTimes = kadouTimeGroup.getKadouTimes();
                    if( kadouTimes.size() < 16) {

                        kadouTime = kadouTimeGroup.createKadouTime();
                        kadouTime.setEigyoubiKbn(eigyoubiKbn);
                        kadouTime.setKadouTimeYoubiKbn(youbiKbn);
                        kadouTime.setKadouTimeSiteiKbn(C_KadouTimeSiteiKbn.HYOUJUN);
                        if( C_KadouTimeYoubiKbn.HYOUJYUN.eq(youbiKbn) ) {
                            kadouTime.setKadouTimeSiteiKbn(C_KadouTimeSiteiKbn.ZENJITURIYOU_KA);
                        }
                    }
                }
            }
            baseDomManager.update(kadouTimeGroup);
        }
    }

    @Transactional
    public void createTestL0012_03(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);

        AT_TokuteibiKadouTime tokuteibiKadouTime = kadouTimeGroup.getTokuteibiKadouTime(ALREADYSYORIYMD);
        if ( null == tokuteibiKadouTime ) {
            tokuteibiKadouTime = kadouTimeGroup.createTokuteibiKadouTime();
            tokuteibiKadouTime.setKadouTimeSiteiYmd(ALREADYSYORIYMD);
            tokuteibiKadouTime.setKadouTimeSiteiKbn(ALREADYSITEIKBN);

            baseDomManager.update(kadouTimeGroup);
        }
    }

    @Transactional
    public void deleteTestL0012_01(){

        baseDomManager.clear();
        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {
            kadouTimeGroup.getKadouTimes().removeAll(kadouTimeGroup.getKadouTimes());
            kadouTimeGroup.getTokuteibiKadouTimes().removeAll(kadouTimeGroup.getTokuteibiKadouTimes());

            baseDomManager.update(kadouTimeGroup);
            baseDomManager.delete(kadouTimeGroup);
        }
    }

    @Transactional
    public void createTestL0013_01(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null == kadouTimeGroup ) {
            kadouTimeGroup = new AT_KadouTimeGroup();
            kadouTimeGroup.setKadouTimeGroupCd(ALREADYKADOUTIMEGROUPCD);
            kadouTimeGroup.setKadouTimeGroupNm(ALREADYKADOUTIMEGROUPNM);
            kadouTimeGroup.setHolidayGroupCd(ALREADYKADOUTIMEGROUP_HOLIDAYGROUPCD);
            kadouTimeGroup.setKadouTimeGroupDescription(ALREADYKADOUTIMEGROUPBIKOU);

            baseDomManager.insert(kadouTimeGroup);
        }
    }


    @Transactional
    public void createTestL0013_02(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {

            C_KadouTimeYoubiKbn[] kadouTimeYoubiKbns = {C_KadouTimeYoubiKbn.GETUYOU, C_KadouTimeYoubiKbn.KAYOU, C_KadouTimeYoubiKbn.SUIYOU
                , C_KadouTimeYoubiKbn.MOKUYOU, C_KadouTimeYoubiKbn.KINYOU, C_KadouTimeYoubiKbn.DOYOU, C_KadouTimeYoubiKbn.NITIYOU, C_KadouTimeYoubiKbn.HYOUJYUN};
            C_EigyoubiKbn[] eigyoubiKbns = {C_EigyoubiKbn.EIGYOUBI, C_EigyoubiKbn.HIEIGYOUBI};

            for( C_EigyoubiKbn eigyoubiKbn : eigyoubiKbns ) {
                AT_KadouTime kadouTime = null;
                for ( C_KadouTimeYoubiKbn youbiKbn : kadouTimeYoubiKbns ) {
                    List<AT_KadouTime> kadouTimes = kadouTimeGroup.getKadouTimes();
                    if( kadouTimes.size() < 16) {

                        kadouTime = kadouTimeGroup.createKadouTime();
                        kadouTime.setEigyoubiKbn(eigyoubiKbn);
                        kadouTime.setKadouTimeYoubiKbn(youbiKbn);
                        kadouTime.setKadouTimeSiteiKbn(C_KadouTimeSiteiKbn.HYOUJUN);
                        if( C_KadouTimeYoubiKbn.HYOUJYUN.eq(youbiKbn) ) {
                            kadouTime.setKadouTimeSiteiKbn(C_KadouTimeSiteiKbn.ZENJITURIYOU_KA);
                        }
                    }
                }
            }
            baseDomManager.update(kadouTimeGroup);
        }
    }

    @Transactional
    public void createTestL0013_03(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);

        AT_TokuteibiKadouTime tokuteibiKadouTime = kadouTimeGroup.getTokuteibiKadouTime(ALREADYSYORIYMD);
        if ( null == tokuteibiKadouTime ) {
            tokuteibiKadouTime = kadouTimeGroup.createTokuteibiKadouTime();
            tokuteibiKadouTime.setKadouTimeSiteiYmd(ALREADYSYORIYMD);
            tokuteibiKadouTime.setKadouTimeSiteiKbn(ALREADYSITEIKBN);

            baseDomManager.update(kadouTimeGroup);
        }
    }

    @Transactional
    public void deleteTestL0013_01(){

        baseDomManager.clear();
        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {
            kadouTimeGroup.getKadouTimes().removeAll(kadouTimeGroup.getKadouTimes());
            kadouTimeGroup.getTokuteibiKadouTimes().removeAll(kadouTimeGroup.getTokuteibiKadouTimes());

            baseDomManager.update(kadouTimeGroup);
            baseDomManager.delete(kadouTimeGroup);
        }
    }

    @Transactional
    public void createTestL0014_01(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null == kadouTimeGroup ) {
            kadouTimeGroup = new AT_KadouTimeGroup();
            kadouTimeGroup.setKadouTimeGroupCd(ALREADYKADOUTIMEGROUPCD);
            kadouTimeGroup.setKadouTimeGroupNm(ALREADYKADOUTIMEGROUPNM);
            kadouTimeGroup.setHolidayGroupCd(ALREADYKADOUTIMEGROUP_HOLIDAYGROUPCD);
            kadouTimeGroup.setKadouTimeGroupDescription(ALREADYKADOUTIMEGROUPBIKOU);

            baseDomManager.insert(kadouTimeGroup);
        }
    }


    @Transactional
    public void createTestL0014_02(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {

            C_KadouTimeYoubiKbn[] kadouTimeYoubiKbns = {C_KadouTimeYoubiKbn.GETUYOU, C_KadouTimeYoubiKbn.KAYOU, C_KadouTimeYoubiKbn.SUIYOU
                , C_KadouTimeYoubiKbn.MOKUYOU, C_KadouTimeYoubiKbn.KINYOU, C_KadouTimeYoubiKbn.DOYOU, C_KadouTimeYoubiKbn.NITIYOU, C_KadouTimeYoubiKbn.HYOUJYUN};
            C_EigyoubiKbn[] eigyoubiKbns = {C_EigyoubiKbn.EIGYOUBI, C_EigyoubiKbn.HIEIGYOUBI};

            for( C_EigyoubiKbn eigyoubiKbn : eigyoubiKbns ) {
                AT_KadouTime kadouTime = null;
                for ( C_KadouTimeYoubiKbn youbiKbn : kadouTimeYoubiKbns ) {
                    List<AT_KadouTime> kadouTimes = kadouTimeGroup.getKadouTimes();
                    if( kadouTimes.size() < 16) {

                        kadouTime = kadouTimeGroup.createKadouTime();
                        kadouTime.setEigyoubiKbn(eigyoubiKbn);
                        kadouTime.setKadouTimeYoubiKbn(youbiKbn);
                        kadouTime.setKadouTimeSiteiKbn(C_KadouTimeSiteiKbn.HYOUJUN);
                        if( C_KadouTimeYoubiKbn.HYOUJYUN.eq(youbiKbn) ) {
                            kadouTime.setKadouTimeSiteiKbn(C_KadouTimeSiteiKbn.ZENJITURIYOU_KA);
                        }
                    }
                }
            }
            baseDomManager.update(kadouTimeGroup);
        }
    }

    @Transactional
    public void createTestL0014_03(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);

        AT_TokuteibiKadouTime tokuteibiKadouTime = kadouTimeGroup.getTokuteibiKadouTime(ALREADYSYORIYMD);
        if ( null == tokuteibiKadouTime ) {
            tokuteibiKadouTime = kadouTimeGroup.createTokuteibiKadouTime();
            tokuteibiKadouTime.setKadouTimeSiteiYmd(ALREADYSYORIYMD);
            tokuteibiKadouTime.setKadouTimeSiteiKbn(ALREADYSITEIKBN);

            baseDomManager.update(kadouTimeGroup);
        }
    }

    @Transactional
    public void deleteTestL0014_01(){

        baseDomManager.clear();
        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {
            kadouTimeGroup.getKadouTimes().removeAll(kadouTimeGroup.getKadouTimes());
            kadouTimeGroup.getTokuteibiKadouTimes().removeAll(kadouTimeGroup.getTokuteibiKadouTimes());

            baseDomManager.update(kadouTimeGroup);
            baseDomManager.delete(kadouTimeGroup);
        }
    }

    @Transactional
    public void createTestL0015_01(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null == kadouTimeGroup ) {
            kadouTimeGroup = new AT_KadouTimeGroup();
            kadouTimeGroup.setKadouTimeGroupCd(ALREADYKADOUTIMEGROUPCD);
            kadouTimeGroup.setKadouTimeGroupNm(ALREADYKADOUTIMEGROUPNM);
            kadouTimeGroup.setHolidayGroupCd(ALREADYKADOUTIMEGROUP_HOLIDAYGROUPCD);
            kadouTimeGroup.setKadouTimeGroupDescription(ALREADYKADOUTIMEGROUPBIKOU);

            baseDomManager.insert(kadouTimeGroup);
        }
    }


    @Transactional
    public void createTestL0015_02(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {

            C_KadouTimeYoubiKbn[] kadouTimeYoubiKbns = {C_KadouTimeYoubiKbn.GETUYOU, C_KadouTimeYoubiKbn.KAYOU, C_KadouTimeYoubiKbn.SUIYOU
                , C_KadouTimeYoubiKbn.MOKUYOU, C_KadouTimeYoubiKbn.KINYOU, C_KadouTimeYoubiKbn.DOYOU, C_KadouTimeYoubiKbn.NITIYOU, C_KadouTimeYoubiKbn.HYOUJYUN};
            C_EigyoubiKbn[] eigyoubiKbns = {C_EigyoubiKbn.EIGYOUBI, C_EigyoubiKbn.HIEIGYOUBI};

            for( C_EigyoubiKbn eigyoubiKbn : eigyoubiKbns ) {
                AT_KadouTime kadouTime = null;
                for ( C_KadouTimeYoubiKbn youbiKbn : kadouTimeYoubiKbns ) {
                    List<AT_KadouTime> kadouTimes = kadouTimeGroup.getKadouTimes();
                    if( kadouTimes.size() < 16) {

                        kadouTime = kadouTimeGroup.createKadouTime();
                        kadouTime.setEigyoubiKbn(eigyoubiKbn);
                        kadouTime.setKadouTimeYoubiKbn(youbiKbn);
                        kadouTime.setKadouTimeSiteiKbn(C_KadouTimeSiteiKbn.HYOUJUN);
                        if( C_KadouTimeYoubiKbn.HYOUJYUN.eq(youbiKbn) ) {
                            kadouTime.setKadouTimeSiteiKbn(C_KadouTimeSiteiKbn.ZENJITURIYOU_KA);
                        }
                    }
                }
            }
            baseDomManager.update(kadouTimeGroup);
        }
    }

    @Transactional
    public void deleteTestL0015_01(){

        baseDomManager.clear();
        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {
            kadouTimeGroup.getKadouTimes().removeAll(kadouTimeGroup.getKadouTimes());
            kadouTimeGroup.getTokuteibiKadouTimes().removeAll(kadouTimeGroup.getTokuteibiKadouTimes());

            baseDomManager.update(kadouTimeGroup);
            baseDomManager.delete(kadouTimeGroup);
        }
    }

    @Transactional
    public void createTestL0016_01(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null == kadouTimeGroup ) {
            kadouTimeGroup = new AT_KadouTimeGroup();
            kadouTimeGroup.setKadouTimeGroupCd(ALREADYKADOUTIMEGROUPCD);
            kadouTimeGroup.setKadouTimeGroupNm(ALREADYKADOUTIMEGROUPNM);
            kadouTimeGroup.setHolidayGroupCd(ALREADYKADOUTIMEGROUP_HOLIDAYGROUPCD);
            kadouTimeGroup.setKadouTimeGroupDescription(ALREADYKADOUTIMEGROUPBIKOU);

            baseDomManager.insert(kadouTimeGroup);
        }
    }


    @Transactional
    public void createTestL0016_02(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {

            C_KadouTimeYoubiKbn[] kadouTimeYoubiKbns = {C_KadouTimeYoubiKbn.GETUYOU, C_KadouTimeYoubiKbn.KAYOU, C_KadouTimeYoubiKbn.SUIYOU
                , C_KadouTimeYoubiKbn.MOKUYOU, C_KadouTimeYoubiKbn.KINYOU, C_KadouTimeYoubiKbn.DOYOU, C_KadouTimeYoubiKbn.NITIYOU, C_KadouTimeYoubiKbn.HYOUJYUN};
            C_EigyoubiKbn[] eigyoubiKbns = {C_EigyoubiKbn.EIGYOUBI, C_EigyoubiKbn.HIEIGYOUBI};

            for( C_EigyoubiKbn eigyoubiKbn : eigyoubiKbns ) {
                AT_KadouTime kadouTime = null;
                for ( C_KadouTimeYoubiKbn youbiKbn : kadouTimeYoubiKbns ) {
                    List<AT_KadouTime> kadouTimes = kadouTimeGroup.getKadouTimes();
                    if( kadouTimes.size() < 16) {

                        kadouTime = kadouTimeGroup.createKadouTime();
                        kadouTime.setEigyoubiKbn(eigyoubiKbn);
                        kadouTime.setKadouTimeYoubiKbn(youbiKbn);
                        kadouTime.setKadouTimeSiteiKbn(C_KadouTimeSiteiKbn.HYOUJUN);
                        if( C_KadouTimeYoubiKbn.HYOUJYUN.eq(youbiKbn) ) {
                            kadouTime.setKadouTimeSiteiKbn(C_KadouTimeSiteiKbn.ZENJITURIYOU_KA);
                        }
                    }
                }
            }
            baseDomManager.update(kadouTimeGroup);
        }
    }

    @Transactional
    public void createTestL0016_03(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);

        AT_TokuteibiKadouTime tokuteibiKadouTime = kadouTimeGroup.getTokuteibiKadouTime(ALREADYSYORIYMD);
        if ( null == tokuteibiKadouTime ) {
            tokuteibiKadouTime = kadouTimeGroup.createTokuteibiKadouTime();
            tokuteibiKadouTime.setKadouTimeSiteiYmd(ALREADYSYORIYMD);
            tokuteibiKadouTime.setKadouTimeSiteiKbn(ALREADYSITEIKBN);

            baseDomManager.update(kadouTimeGroup);
        }
    }

    @Transactional
    public void deleteTestL0016_01(){

        baseDomManager.clear();
        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {
            kadouTimeGroup.getKadouTimes().removeAll(kadouTimeGroup.getKadouTimes());
            kadouTimeGroup.getTokuteibiKadouTimes().removeAll(kadouTimeGroup.getTokuteibiKadouTimes());

            baseDomManager.update(kadouTimeGroup);
            baseDomManager.delete(kadouTimeGroup);
        }
    }

    @Transactional
    public void createTestL0017_01(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null == kadouTimeGroup ) {
            kadouTimeGroup = new AT_KadouTimeGroup();
            kadouTimeGroup.setKadouTimeGroupCd(ALREADYKADOUTIMEGROUPCD);
            kadouTimeGroup.setKadouTimeGroupNm(ALREADYKADOUTIMEGROUPNM);
            kadouTimeGroup.setHolidayGroupCd(ALREADYKADOUTIMEGROUP_HOLIDAYGROUPCD);
            kadouTimeGroup.setKadouTimeGroupDescription(ALREADYKADOUTIMEGROUPBIKOU);

            baseDomManager.insert(kadouTimeGroup);
        }
    }


    @Transactional
    public void createTestL0017_02(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {

            C_KadouTimeYoubiKbn[] kadouTimeYoubiKbns = {C_KadouTimeYoubiKbn.GETUYOU, C_KadouTimeYoubiKbn.KAYOU, C_KadouTimeYoubiKbn.SUIYOU
                , C_KadouTimeYoubiKbn.MOKUYOU, C_KadouTimeYoubiKbn.KINYOU, C_KadouTimeYoubiKbn.DOYOU, C_KadouTimeYoubiKbn.NITIYOU, C_KadouTimeYoubiKbn.HYOUJYUN};
            C_EigyoubiKbn[] eigyoubiKbns = {C_EigyoubiKbn.EIGYOUBI, C_EigyoubiKbn.HIEIGYOUBI};

            for( C_EigyoubiKbn eigyoubiKbn : eigyoubiKbns ) {
                AT_KadouTime kadouTime = null;
                for ( C_KadouTimeYoubiKbn youbiKbn : kadouTimeYoubiKbns ) {
                    List<AT_KadouTime> kadouTimes = kadouTimeGroup.getKadouTimes();
                    if( kadouTimes.size() < 16) {

                        kadouTime = kadouTimeGroup.createKadouTime();
                        kadouTime.setEigyoubiKbn(eigyoubiKbn);
                        kadouTime.setKadouTimeYoubiKbn(youbiKbn);
                        kadouTime.setKadouTimeSiteiKbn(C_KadouTimeSiteiKbn.HYOUJUN);
                        if( C_KadouTimeYoubiKbn.HYOUJYUN.eq(youbiKbn) ) {
                            kadouTime.setKadouTimeSiteiKbn(C_KadouTimeSiteiKbn.ZENJITURIYOU_KA);
                        }
                    }
                }
            }
            baseDomManager.update(kadouTimeGroup);
        }
    }

    @Transactional
    public void createTestL0017_03(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);

        AT_TokuteibiKadouTime tokuteibiKadouTime = kadouTimeGroup.getTokuteibiKadouTime(ALREADYSYORIYMD);
        if ( null == tokuteibiKadouTime ) {
            tokuteibiKadouTime = kadouTimeGroup.createTokuteibiKadouTime();
            tokuteibiKadouTime.setKadouTimeSiteiYmd(ALREADYSYORIYMD);
            tokuteibiKadouTime.setKadouTimeSiteiKbn(ALREADYSITEIKBN);

            baseDomManager.update(kadouTimeGroup);
        }
    }

    @Transactional
    public void deleteTestL0017_01(){

        baseDomManager.clear();
        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {
            kadouTimeGroup.getKadouTimes().removeAll(kadouTimeGroup.getKadouTimes());
            kadouTimeGroup.getTokuteibiKadouTimes().removeAll(kadouTimeGroup.getTokuteibiKadouTimes());

            baseDomManager.update(kadouTimeGroup);
            baseDomManager.delete(kadouTimeGroup);
        }
    }

    @Transactional
    public void createTestL0018_01(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null == kadouTimeGroup ) {
            kadouTimeGroup = new AT_KadouTimeGroup();
            kadouTimeGroup.setKadouTimeGroupCd(ALREADYKADOUTIMEGROUPCD);
            kadouTimeGroup.setKadouTimeGroupNm(ALREADYKADOUTIMEGROUPNM);
            kadouTimeGroup.setHolidayGroupCd(ALREADYKADOUTIMEGROUP_HOLIDAYGROUPCD);
            kadouTimeGroup.setKadouTimeGroupDescription(ALREADYKADOUTIMEGROUPBIKOU);

            baseDomManager.insert(kadouTimeGroup);
        }
    }


    @Transactional
    public void createTestL0018_02(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {

            C_KadouTimeYoubiKbn[] kadouTimeYoubiKbns = {C_KadouTimeYoubiKbn.GETUYOU, C_KadouTimeYoubiKbn.KAYOU, C_KadouTimeYoubiKbn.SUIYOU
                , C_KadouTimeYoubiKbn.MOKUYOU, C_KadouTimeYoubiKbn.KINYOU, C_KadouTimeYoubiKbn.DOYOU, C_KadouTimeYoubiKbn.NITIYOU, C_KadouTimeYoubiKbn.HYOUJYUN};
            C_EigyoubiKbn[] eigyoubiKbns = {C_EigyoubiKbn.EIGYOUBI, C_EigyoubiKbn.HIEIGYOUBI};

            for( C_EigyoubiKbn eigyoubiKbn : eigyoubiKbns ) {
                AT_KadouTime kadouTime = null;
                for ( C_KadouTimeYoubiKbn youbiKbn : kadouTimeYoubiKbns ) {
                    List<AT_KadouTime> kadouTimes = kadouTimeGroup.getKadouTimes();
                    if( kadouTimes.size() < 16) {

                        kadouTime = kadouTimeGroup.createKadouTime();
                        kadouTime.setEigyoubiKbn(eigyoubiKbn);
                        kadouTime.setKadouTimeYoubiKbn(youbiKbn);
                        kadouTime.setKadouTimeSiteiKbn(C_KadouTimeSiteiKbn.HYOUJUN);
                        if( C_KadouTimeYoubiKbn.HYOUJYUN.eq(youbiKbn) ) {
                            kadouTime.setKadouTimeSiteiKbn(C_KadouTimeSiteiKbn.ZENJITURIYOU_KA);
                        }
                    }
                }
            }
            baseDomManager.update(kadouTimeGroup);
        }
    }

    @Transactional
    public void createTestL0018_03(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);

        AT_TokuteibiKadouTime tokuteibiKadouTime = kadouTimeGroup.getTokuteibiKadouTime(ALREADYSYORIYMD);
        if ( null == tokuteibiKadouTime ) {
            tokuteibiKadouTime = kadouTimeGroup.createTokuteibiKadouTime();
            tokuteibiKadouTime.setKadouTimeSiteiYmd(ALREADYSYORIYMD);
            tokuteibiKadouTime.setKadouTimeSiteiKbn(ALREADYSITEIKBN);

            baseDomManager.update(kadouTimeGroup);
        }
    }

    @Transactional
    public void deleteTestL0018_01(){

        baseDomManager.clear();
        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {
            kadouTimeGroup.getKadouTimes().removeAll(kadouTimeGroup.getKadouTimes());
            kadouTimeGroup.getTokuteibiKadouTimes().removeAll(kadouTimeGroup.getTokuteibiKadouTimes());

            baseDomManager.update(kadouTimeGroup);
            baseDomManager.delete(kadouTimeGroup);
        }
    }

    @Transactional
    public void createTestL0019_01(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null == kadouTimeGroup ) {
            kadouTimeGroup = new AT_KadouTimeGroup();
            kadouTimeGroup.setKadouTimeGroupCd(ALREADYKADOUTIMEGROUPCD);
            kadouTimeGroup.setKadouTimeGroupNm(ALREADYKADOUTIMEGROUPNM);
            kadouTimeGroup.setHolidayGroupCd(ALREADYKADOUTIMEGROUP_HOLIDAYGROUPCD);
            kadouTimeGroup.setKadouTimeGroupDescription(ALREADYKADOUTIMEGROUPBIKOU);

            baseDomManager.insert(kadouTimeGroup);
        }
    }


    @Transactional
    public void createTestL0019_02(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {

            C_KadouTimeYoubiKbn[] kadouTimeYoubiKbns = {C_KadouTimeYoubiKbn.GETUYOU, C_KadouTimeYoubiKbn.KAYOU, C_KadouTimeYoubiKbn.SUIYOU
                , C_KadouTimeYoubiKbn.MOKUYOU, C_KadouTimeYoubiKbn.KINYOU, C_KadouTimeYoubiKbn.DOYOU, C_KadouTimeYoubiKbn.NITIYOU, C_KadouTimeYoubiKbn.HYOUJYUN};
            C_EigyoubiKbn[] eigyoubiKbns = {C_EigyoubiKbn.EIGYOUBI, C_EigyoubiKbn.HIEIGYOUBI};

            for( C_EigyoubiKbn eigyoubiKbn : eigyoubiKbns ) {
                AT_KadouTime kadouTime = null;
                for ( C_KadouTimeYoubiKbn youbiKbn : kadouTimeYoubiKbns ) {
                    List<AT_KadouTime> kadouTimes = kadouTimeGroup.getKadouTimes();
                    if( kadouTimes.size() < 16) {

                        kadouTime = kadouTimeGroup.createKadouTime();
                        kadouTime.setEigyoubiKbn(eigyoubiKbn);
                        kadouTime.setKadouTimeYoubiKbn(youbiKbn);
                        kadouTime.setKadouTimeSiteiKbn(C_KadouTimeSiteiKbn.HYOUJUN);
                        if( C_KadouTimeYoubiKbn.HYOUJYUN.eq(youbiKbn) ) {
                            kadouTime.setKadouTimeSiteiKbn(C_KadouTimeSiteiKbn.ZENJITURIYOU_KA);
                        }
                    }
                }
            }
            baseDomManager.update(kadouTimeGroup);
        }
    }

    @Transactional
    public void createTestL0019_03(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);

        AT_TokuteibiKadouTime tokuteibiKadouTime = kadouTimeGroup.getTokuteibiKadouTime(ALREADYSYORIYMD);
        if ( null == tokuteibiKadouTime ) {
            tokuteibiKadouTime = kadouTimeGroup.createTokuteibiKadouTime();
            tokuteibiKadouTime.setKadouTimeSiteiYmd(ALREADYSYORIYMD);
            tokuteibiKadouTime.setKadouTimeSiteiKbn(ALREADYSITEIKBN);

            baseDomManager.update(kadouTimeGroup);
        }
    }

    @Transactional
    public void deleteTestL0019_01(){

        baseDomManager.clear();
        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {
            kadouTimeGroup.getKadouTimes().removeAll(kadouTimeGroup.getKadouTimes());
            kadouTimeGroup.getTokuteibiKadouTimes().removeAll(kadouTimeGroup.getTokuteibiKadouTimes());

            baseDomManager.update(kadouTimeGroup);
            baseDomManager.delete(kadouTimeGroup);
        }
    }

    @Transactional
    public void createTestL0020_01(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null == kadouTimeGroup ) {
            kadouTimeGroup = new AT_KadouTimeGroup();
            kadouTimeGroup.setKadouTimeGroupCd(ALREADYKADOUTIMEGROUPCD);
            kadouTimeGroup.setKadouTimeGroupNm(ALREADYKADOUTIMEGROUPNM);
            kadouTimeGroup.setHolidayGroupCd(ALREADYKADOUTIMEGROUP_HOLIDAYGROUPCD);
            kadouTimeGroup.setKadouTimeGroupDescription(ALREADYKADOUTIMEGROUPBIKOU);

            baseDomManager.insert(kadouTimeGroup);
        }
    }


    @Transactional
    public void createTestL0020_02(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {

            C_KadouTimeYoubiKbn[] kadouTimeYoubiKbns = {C_KadouTimeYoubiKbn.GETUYOU, C_KadouTimeYoubiKbn.KAYOU, C_KadouTimeYoubiKbn.SUIYOU
                , C_KadouTimeYoubiKbn.MOKUYOU, C_KadouTimeYoubiKbn.KINYOU, C_KadouTimeYoubiKbn.DOYOU, C_KadouTimeYoubiKbn.NITIYOU, C_KadouTimeYoubiKbn.HYOUJYUN};
            C_EigyoubiKbn[] eigyoubiKbns = {C_EigyoubiKbn.EIGYOUBI, C_EigyoubiKbn.HIEIGYOUBI};

            for( C_EigyoubiKbn eigyoubiKbn : eigyoubiKbns ) {
                AT_KadouTime kadouTime = null;
                for ( C_KadouTimeYoubiKbn youbiKbn : kadouTimeYoubiKbns ) {
                    List<AT_KadouTime> kadouTimes = kadouTimeGroup.getKadouTimes();
                    if( kadouTimes.size() < 16) {

                        kadouTime = kadouTimeGroup.createKadouTime();
                        kadouTime.setEigyoubiKbn(eigyoubiKbn);
                        kadouTime.setKadouTimeYoubiKbn(youbiKbn);
                        kadouTime.setKadouTimeSiteiKbn(C_KadouTimeSiteiKbn.HYOUJUN);
                        if( C_KadouTimeYoubiKbn.HYOUJYUN.eq(youbiKbn) ) {
                            kadouTime.setKadouTimeSiteiKbn(C_KadouTimeSiteiKbn.ZENJITURIYOU_KA);
                        }
                    }
                }
            }
            baseDomManager.update(kadouTimeGroup);
        }
    }

    @Transactional
    public void createTestL0020_03(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);

        AT_TokuteibiKadouTime tokuteibiKadouTime = kadouTimeGroup.getTokuteibiKadouTime(ALREADYSYORIYMD);
        if ( null == tokuteibiKadouTime ) {
            tokuteibiKadouTime = kadouTimeGroup.createTokuteibiKadouTime();
            tokuteibiKadouTime.setKadouTimeSiteiYmd(ALREADYSYORIYMD);
            tokuteibiKadouTime.setKadouTimeSiteiKbn(ALREADYSITEIKBN);

            baseDomManager.update(kadouTimeGroup);
        }
    }

    @Transactional
    public void deleteTestL0020_01(){

        baseDomManager.clear();
        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {
            kadouTimeGroup.getKadouTimes().removeAll(kadouTimeGroup.getKadouTimes());
            kadouTimeGroup.getTokuteibiKadouTimes().removeAll(kadouTimeGroup.getTokuteibiKadouTimes());

            baseDomManager.update(kadouTimeGroup);
            baseDomManager.delete(kadouTimeGroup);
        }
    }

    @Transactional
    public void createTestL0021_01(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null == kadouTimeGroup ) {
            kadouTimeGroup = new AT_KadouTimeGroup();
            kadouTimeGroup.setKadouTimeGroupCd(ALREADYKADOUTIMEGROUPCD);
            kadouTimeGroup.setKadouTimeGroupNm(ALREADYKADOUTIMEGROUPNM);
            kadouTimeGroup.setHolidayGroupCd(ALREADYKADOUTIMEGROUP_HOLIDAYGROUPCD);
            kadouTimeGroup.setKadouTimeGroupDescription(ALREADYKADOUTIMEGROUPBIKOU);

            baseDomManager.insert(kadouTimeGroup);
        }
    }


    @Transactional
    public void createTestL0021_02(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {

            C_KadouTimeYoubiKbn[] kadouTimeYoubiKbns = {C_KadouTimeYoubiKbn.GETUYOU, C_KadouTimeYoubiKbn.KAYOU, C_KadouTimeYoubiKbn.SUIYOU
                , C_KadouTimeYoubiKbn.MOKUYOU, C_KadouTimeYoubiKbn.KINYOU, C_KadouTimeYoubiKbn.DOYOU, C_KadouTimeYoubiKbn.NITIYOU, C_KadouTimeYoubiKbn.HYOUJYUN};
            C_EigyoubiKbn[] eigyoubiKbns = {C_EigyoubiKbn.EIGYOUBI, C_EigyoubiKbn.HIEIGYOUBI};

            for( C_EigyoubiKbn eigyoubiKbn : eigyoubiKbns ) {
                AT_KadouTime kadouTime = null;
                for ( C_KadouTimeYoubiKbn youbiKbn : kadouTimeYoubiKbns ) {
                    List<AT_KadouTime> kadouTimes = kadouTimeGroup.getKadouTimes();
                    if( kadouTimes.size() < 16) {

                        kadouTime = kadouTimeGroup.createKadouTime();
                        kadouTime.setEigyoubiKbn(eigyoubiKbn);
                        kadouTime.setKadouTimeYoubiKbn(youbiKbn);
                        kadouTime.setKadouTimeSiteiKbn(C_KadouTimeSiteiKbn.HYOUJUN);
                        if( C_KadouTimeYoubiKbn.HYOUJYUN.eq(youbiKbn) ) {
                            kadouTime.setKadouTimeSiteiKbn(C_KadouTimeSiteiKbn.ZENJITURIYOU_KA);
                        }
                    }
                }
            }
            baseDomManager.update(kadouTimeGroup);
        }
    }

    @Transactional
    public void createTestL0021_03(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);

        AT_TokuteibiKadouTime tokuteibiKadouTime = kadouTimeGroup.getTokuteibiKadouTime(ALREADYSYORIYMD);
        if ( null == tokuteibiKadouTime ) {
            tokuteibiKadouTime = kadouTimeGroup.createTokuteibiKadouTime();
            tokuteibiKadouTime.setKadouTimeSiteiYmd(ALREADYSYORIYMD);
            tokuteibiKadouTime.setKadouTimeSiteiKbn(ALREADYSITEIKBN);

            baseDomManager.update(kadouTimeGroup);
        }
    }

    @Transactional
    public void deleteTestL0021_01(){

        baseDomManager.clear();
        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {
            kadouTimeGroup.getKadouTimes().removeAll(kadouTimeGroup.getKadouTimes());
            kadouTimeGroup.getTokuteibiKadouTimes().removeAll(kadouTimeGroup.getTokuteibiKadouTimes());

            baseDomManager.update(kadouTimeGroup);
            baseDomManager.delete(kadouTimeGroup);
        }
    }

    @Transactional
    public void createTestL0022_01(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null == kadouTimeGroup ) {
            kadouTimeGroup = new AT_KadouTimeGroup();
            kadouTimeGroup.setKadouTimeGroupCd(ALREADYKADOUTIMEGROUPCD);
            kadouTimeGroup.setKadouTimeGroupNm(ALREADYKADOUTIMEGROUPNM);
            kadouTimeGroup.setHolidayGroupCd(ALREADYKADOUTIMEGROUP_HOLIDAYGROUPCD);
            kadouTimeGroup.setKadouTimeGroupDescription(ALREADYKADOUTIMEGROUPBIKOU);

            baseDomManager.insert(kadouTimeGroup);
        }
    }


    @Transactional
    public void createTestL0022_02(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {

            C_KadouTimeYoubiKbn[] kadouTimeYoubiKbns = {C_KadouTimeYoubiKbn.GETUYOU, C_KadouTimeYoubiKbn.KAYOU, C_KadouTimeYoubiKbn.SUIYOU
                , C_KadouTimeYoubiKbn.MOKUYOU, C_KadouTimeYoubiKbn.KINYOU, C_KadouTimeYoubiKbn.DOYOU, C_KadouTimeYoubiKbn.NITIYOU, C_KadouTimeYoubiKbn.HYOUJYUN};
            C_EigyoubiKbn[] eigyoubiKbns = {C_EigyoubiKbn.EIGYOUBI, C_EigyoubiKbn.HIEIGYOUBI};

            for( C_EigyoubiKbn eigyoubiKbn : eigyoubiKbns ) {
                AT_KadouTime kadouTime = null;
                for ( C_KadouTimeYoubiKbn youbiKbn : kadouTimeYoubiKbns ) {
                    List<AT_KadouTime> kadouTimes = kadouTimeGroup.getKadouTimes();
                    if( kadouTimes.size() < 16) {

                        kadouTime = kadouTimeGroup.createKadouTime();
                        kadouTime.setEigyoubiKbn(eigyoubiKbn);
                        kadouTime.setKadouTimeYoubiKbn(youbiKbn);
                        kadouTime.setKadouTimeSiteiKbn(C_KadouTimeSiteiKbn.HYOUJUN);
                        if( C_KadouTimeYoubiKbn.HYOUJYUN.eq(youbiKbn) ) {
                            kadouTime.setKadouTimeSiteiKbn(C_KadouTimeSiteiKbn.ZENJITURIYOU_KA);
                        }
                    }
                }
            }
            baseDomManager.update(kadouTimeGroup);
        }
    }

    @Transactional
    public void createTestL0022_03(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);

        AT_TokuteibiKadouTime tokuteibiKadouTime = kadouTimeGroup.getTokuteibiKadouTime(ALREADYSYORIYMD);
        if ( null == tokuteibiKadouTime ) {
            tokuteibiKadouTime = kadouTimeGroup.createTokuteibiKadouTime();
            tokuteibiKadouTime.setKadouTimeSiteiYmd(ALREADYSYORIYMD);
            tokuteibiKadouTime.setKadouTimeSiteiKbn(ALREADYSITEIKBN);

            baseDomManager.update(kadouTimeGroup);
        }
    }

    @Transactional
    public void deleteTestL0022_01(){

        baseDomManager.clear();
        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {
            kadouTimeGroup.getKadouTimes().removeAll(kadouTimeGroup.getKadouTimes());
            kadouTimeGroup.getTokuteibiKadouTimes().removeAll(kadouTimeGroup.getTokuteibiKadouTimes());

            baseDomManager.update(kadouTimeGroup);
            baseDomManager.delete(kadouTimeGroup);
        }
    }

    @Transactional
    public void createTestL0023_01(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null == kadouTimeGroup ) {
            kadouTimeGroup = new AT_KadouTimeGroup();
            kadouTimeGroup.setKadouTimeGroupCd(ALREADYKADOUTIMEGROUPCD);
            kadouTimeGroup.setKadouTimeGroupNm(ALREADYKADOUTIMEGROUPNM);
            kadouTimeGroup.setHolidayGroupCd(ALREADYKADOUTIMEGROUP_HOLIDAYGROUPCD);
            kadouTimeGroup.setKadouTimeGroupDescription(ALREADYKADOUTIMEGROUPBIKOU);

            baseDomManager.insert(kadouTimeGroup);
        }
    }


    @Transactional
    public void createTestL0023_02(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {

            C_KadouTimeYoubiKbn[] kadouTimeYoubiKbns = {C_KadouTimeYoubiKbn.GETUYOU, C_KadouTimeYoubiKbn.KAYOU, C_KadouTimeYoubiKbn.SUIYOU
                , C_KadouTimeYoubiKbn.MOKUYOU, C_KadouTimeYoubiKbn.KINYOU, C_KadouTimeYoubiKbn.DOYOU, C_KadouTimeYoubiKbn.NITIYOU, C_KadouTimeYoubiKbn.HYOUJYUN};
            C_EigyoubiKbn[] eigyoubiKbns = {C_EigyoubiKbn.EIGYOUBI, C_EigyoubiKbn.HIEIGYOUBI};

            for( C_EigyoubiKbn eigyoubiKbn : eigyoubiKbns ) {
                AT_KadouTime kadouTime = null;
                for ( C_KadouTimeYoubiKbn youbiKbn : kadouTimeYoubiKbns ) {
                    List<AT_KadouTime> kadouTimes = kadouTimeGroup.getKadouTimes();
                    if( kadouTimes.size() < 16) {

                        kadouTime = kadouTimeGroup.createKadouTime();
                        kadouTime.setEigyoubiKbn(eigyoubiKbn);
                        kadouTime.setKadouTimeYoubiKbn(youbiKbn);
                        kadouTime.setKadouTimeSiteiKbn(C_KadouTimeSiteiKbn.HYOUJUN);
                        if( C_KadouTimeYoubiKbn.HYOUJYUN.eq(youbiKbn) ) {
                            kadouTime.setKadouTimeSiteiKbn(C_KadouTimeSiteiKbn.ZENJITURIYOU_KA);
                        }
                    }
                }
            }
            baseDomManager.update(kadouTimeGroup);
        }
    }

    @Transactional
    public void createTestL0023_03(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);

        AT_TokuteibiKadouTime tokuteibiKadouTime = kadouTimeGroup.getTokuteibiKadouTime(ALREADYSYORIYMD);
        if ( null == tokuteibiKadouTime ) {
            tokuteibiKadouTime = kadouTimeGroup.createTokuteibiKadouTime();
            tokuteibiKadouTime.setKadouTimeSiteiYmd(ALREADYSYORIYMD);
            tokuteibiKadouTime.setKadouTimeSiteiKbn(ALREADYSITEIKBN);

            baseDomManager.update(kadouTimeGroup);
        }
    }

    @Transactional
    public void deleteTestL0023_01(){

        baseDomManager.clear();
        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {
            kadouTimeGroup.getKadouTimes().removeAll(kadouTimeGroup.getKadouTimes());
            kadouTimeGroup.getTokuteibiKadouTimes().removeAll(kadouTimeGroup.getTokuteibiKadouTimes());

            baseDomManager.update(kadouTimeGroup);
            baseDomManager.delete(kadouTimeGroup);
        }
    }

    @Transactional
    public void createTestL0024_01(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null == kadouTimeGroup ) {
            kadouTimeGroup = new AT_KadouTimeGroup();
            kadouTimeGroup.setKadouTimeGroupCd(ALREADYKADOUTIMEGROUPCD);
            kadouTimeGroup.setKadouTimeGroupNm(ALREADYKADOUTIMEGROUPNM);
            kadouTimeGroup.setHolidayGroupCd(ALREADYKADOUTIMEGROUP_HOLIDAYGROUPCD);
            kadouTimeGroup.setKadouTimeGroupDescription(ALREADYKADOUTIMEGROUPBIKOU);

            baseDomManager.insert(kadouTimeGroup);
        }
    }


    @Transactional
    public void createTestL0024_02(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {

            C_KadouTimeYoubiKbn[] kadouTimeYoubiKbns = {C_KadouTimeYoubiKbn.GETUYOU, C_KadouTimeYoubiKbn.KAYOU, C_KadouTimeYoubiKbn.SUIYOU
                , C_KadouTimeYoubiKbn.MOKUYOU, C_KadouTimeYoubiKbn.KINYOU, C_KadouTimeYoubiKbn.DOYOU, C_KadouTimeYoubiKbn.NITIYOU, C_KadouTimeYoubiKbn.HYOUJYUN};
            C_EigyoubiKbn[] eigyoubiKbns = {C_EigyoubiKbn.EIGYOUBI, C_EigyoubiKbn.HIEIGYOUBI};

            for( C_EigyoubiKbn eigyoubiKbn : eigyoubiKbns ) {
                AT_KadouTime kadouTime = null;
                for ( C_KadouTimeYoubiKbn youbiKbn : kadouTimeYoubiKbns ) {
                    List<AT_KadouTime> kadouTimes = kadouTimeGroup.getKadouTimes();
                    if( kadouTimes.size() < 16) {

                        kadouTime = kadouTimeGroup.createKadouTime();
                        kadouTime.setEigyoubiKbn(eigyoubiKbn);
                        kadouTime.setKadouTimeYoubiKbn(youbiKbn);
                        kadouTime.setKadouTimeSiteiKbn(C_KadouTimeSiteiKbn.HYOUJUN);
                        if( C_KadouTimeYoubiKbn.HYOUJYUN.eq(youbiKbn) ) {
                            kadouTime.setKadouTimeSiteiKbn(C_KadouTimeSiteiKbn.ZENJITURIYOU_KA);
                        }
                    }
                }
            }
            baseDomManager.update(kadouTimeGroup);
        }
    }

    @Transactional
    public void createTestL0024_03(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);

        AT_TokuteibiKadouTime tokuteibiKadouTime = kadouTimeGroup.getTokuteibiKadouTime(ALREADYSYORIYMD);
        if ( null == tokuteibiKadouTime ) {
            tokuteibiKadouTime = kadouTimeGroup.createTokuteibiKadouTime();
            tokuteibiKadouTime.setKadouTimeSiteiYmd(ALREADYSYORIYMD);
            tokuteibiKadouTime.setKadouTimeSiteiKbn(ALREADYSITEIKBN);

            baseDomManager.update(kadouTimeGroup);
        }
    }

    @Transactional
    public void deleteTestL0024_01(){

        baseDomManager.clear();
        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {
            kadouTimeGroup.getKadouTimes().removeAll(kadouTimeGroup.getKadouTimes());
            kadouTimeGroup.getTokuteibiKadouTimes().removeAll(kadouTimeGroup.getTokuteibiKadouTimes());

            baseDomManager.update(kadouTimeGroup);
            baseDomManager.delete(kadouTimeGroup);
        }
    }

    @Transactional
    public void createTestL0025_01(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null == kadouTimeGroup ) {
            kadouTimeGroup = new AT_KadouTimeGroup();
            kadouTimeGroup.setKadouTimeGroupCd(ALREADYKADOUTIMEGROUPCD);
            kadouTimeGroup.setKadouTimeGroupNm(ALREADYKADOUTIMEGROUPNM);
            kadouTimeGroup.setHolidayGroupCd(ALREADYKADOUTIMEGROUP_HOLIDAYGROUPCD);
            kadouTimeGroup.setKadouTimeGroupDescription(ALREADYKADOUTIMEGROUPBIKOU);

            baseDomManager.insert(kadouTimeGroup);
        }
    }


    @Transactional
    public void createTestL0025_02(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {

            C_KadouTimeYoubiKbn[] kadouTimeYoubiKbns = {C_KadouTimeYoubiKbn.GETUYOU, C_KadouTimeYoubiKbn.KAYOU, C_KadouTimeYoubiKbn.SUIYOU
                , C_KadouTimeYoubiKbn.MOKUYOU, C_KadouTimeYoubiKbn.KINYOU, C_KadouTimeYoubiKbn.DOYOU, C_KadouTimeYoubiKbn.NITIYOU, C_KadouTimeYoubiKbn.HYOUJYUN};
            C_EigyoubiKbn[] eigyoubiKbns = {C_EigyoubiKbn.EIGYOUBI, C_EigyoubiKbn.HIEIGYOUBI};

            for( C_EigyoubiKbn eigyoubiKbn : eigyoubiKbns ) {
                AT_KadouTime kadouTime = null;
                for ( C_KadouTimeYoubiKbn youbiKbn : kadouTimeYoubiKbns ) {
                    List<AT_KadouTime> kadouTimes = kadouTimeGroup.getKadouTimes();
                    if( kadouTimes.size() < 16) {

                        kadouTime = kadouTimeGroup.createKadouTime();
                        kadouTime.setEigyoubiKbn(eigyoubiKbn);
                        kadouTime.setKadouTimeYoubiKbn(youbiKbn);
                        kadouTime.setKadouTimeSiteiKbn(C_KadouTimeSiteiKbn.HYOUJUN);
                        if( C_KadouTimeYoubiKbn.HYOUJYUN.eq(youbiKbn) ) {
                            kadouTime.setKadouTimeSiteiKbn(C_KadouTimeSiteiKbn.ZENJITURIYOU_KA);
                        }
                    }
                }
            }
            baseDomManager.update(kadouTimeGroup);
        }
    }

    @Transactional
    public void createTestL0025_03(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);

        AT_TokuteibiKadouTime tokuteibiKadouTime = kadouTimeGroup.getTokuteibiKadouTime(ALREADYSYORIYMD);
        if ( null == tokuteibiKadouTime ) {
            tokuteibiKadouTime = kadouTimeGroup.createTokuteibiKadouTime();
            tokuteibiKadouTime.setKadouTimeSiteiYmd(ALREADYSYORIYMD);
            tokuteibiKadouTime.setKadouTimeSiteiKbn(ALREADYSITEIKBN);

            baseDomManager.update(kadouTimeGroup);
        }
    }

    @Transactional
    public void deleteTestL0025_01(){

        baseDomManager.clear();
        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {
            kadouTimeGroup.getKadouTimes().removeAll(kadouTimeGroup.getKadouTimes());
            kadouTimeGroup.getTokuteibiKadouTimes().removeAll(kadouTimeGroup.getTokuteibiKadouTimes());

            baseDomManager.update(kadouTimeGroup);
            baseDomManager.delete(kadouTimeGroup);
        }
    }

    @Transactional
    public void createTestL0026_01(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null == kadouTimeGroup ) {
            kadouTimeGroup = new AT_KadouTimeGroup();
            kadouTimeGroup.setKadouTimeGroupCd(ALREADYKADOUTIMEGROUPCD);
            kadouTimeGroup.setKadouTimeGroupNm(ALREADYKADOUTIMEGROUPNM);
            kadouTimeGroup.setHolidayGroupCd(ALREADYKADOUTIMEGROUP_HOLIDAYGROUPCD);
            kadouTimeGroup.setKadouTimeGroupDescription(ALREADYKADOUTIMEGROUPBIKOU);

            baseDomManager.insert(kadouTimeGroup);
        }
    }


    @Transactional
    public void createTestL0026_02(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {

            C_KadouTimeYoubiKbn[] kadouTimeYoubiKbns = {C_KadouTimeYoubiKbn.GETUYOU, C_KadouTimeYoubiKbn.KAYOU, C_KadouTimeYoubiKbn.SUIYOU
                , C_KadouTimeYoubiKbn.MOKUYOU, C_KadouTimeYoubiKbn.KINYOU, C_KadouTimeYoubiKbn.DOYOU, C_KadouTimeYoubiKbn.NITIYOU, C_KadouTimeYoubiKbn.HYOUJYUN};
            C_EigyoubiKbn[] eigyoubiKbns = {C_EigyoubiKbn.EIGYOUBI, C_EigyoubiKbn.HIEIGYOUBI};

            for( C_EigyoubiKbn eigyoubiKbn : eigyoubiKbns ) {
                AT_KadouTime kadouTime = null;
                for ( C_KadouTimeYoubiKbn youbiKbn : kadouTimeYoubiKbns ) {
                    List<AT_KadouTime> kadouTimes = kadouTimeGroup.getKadouTimes();
                    if( kadouTimes.size() < 16) {

                        kadouTime = kadouTimeGroup.createKadouTime();
                        kadouTime.setEigyoubiKbn(eigyoubiKbn);
                        kadouTime.setKadouTimeYoubiKbn(youbiKbn);
                        kadouTime.setKadouTimeSiteiKbn(C_KadouTimeSiteiKbn.HYOUJUN);
                        if( C_KadouTimeYoubiKbn.HYOUJYUN.eq(youbiKbn) ) {
                            kadouTime.setKadouTimeSiteiKbn(C_KadouTimeSiteiKbn.ZENJITURIYOU_KA);
                        }
                    }
                }
            }
            baseDomManager.update(kadouTimeGroup);
        }
    }

    @Transactional
    public void deleteTestL0026_01(){

        baseDomManager.clear();
        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {
            kadouTimeGroup.getKadouTimes().removeAll(kadouTimeGroup.getKadouTimes());
            kadouTimeGroup.getTokuteibiKadouTimes().removeAll(kadouTimeGroup.getTokuteibiKadouTimes());

            baseDomManager.update(kadouTimeGroup);
            baseDomManager.delete(kadouTimeGroup);
        }
    }

    @Transactional
    public void createTestL0027_01(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null == kadouTimeGroup ) {
            kadouTimeGroup = new AT_KadouTimeGroup();
            kadouTimeGroup.setKadouTimeGroupCd(ALREADYKADOUTIMEGROUPCD);
            kadouTimeGroup.setKadouTimeGroupNm(ALREADYKADOUTIMEGROUPNM);
            kadouTimeGroup.setHolidayGroupCd(ALREADYKADOUTIMEGROUP_HOLIDAYGROUPCD);
            kadouTimeGroup.setKadouTimeGroupDescription(ALREADYKADOUTIMEGROUPBIKOU);

            baseDomManager.insert(kadouTimeGroup);
        }
    }


    @Transactional
    public void createTestL0027_02(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {

            C_KadouTimeYoubiKbn[] kadouTimeYoubiKbns = {C_KadouTimeYoubiKbn.GETUYOU, C_KadouTimeYoubiKbn.KAYOU, C_KadouTimeYoubiKbn.SUIYOU
                , C_KadouTimeYoubiKbn.MOKUYOU, C_KadouTimeYoubiKbn.KINYOU, C_KadouTimeYoubiKbn.DOYOU, C_KadouTimeYoubiKbn.NITIYOU, C_KadouTimeYoubiKbn.HYOUJYUN};
            C_EigyoubiKbn[] eigyoubiKbns = {C_EigyoubiKbn.EIGYOUBI, C_EigyoubiKbn.HIEIGYOUBI};

            for( C_EigyoubiKbn eigyoubiKbn : eigyoubiKbns ) {
                AT_KadouTime kadouTime = null;
                for ( C_KadouTimeYoubiKbn youbiKbn : kadouTimeYoubiKbns ) {
                    List<AT_KadouTime> kadouTimes = kadouTimeGroup.getKadouTimes();
                    if( kadouTimes.size() < 16) {

                        kadouTime = kadouTimeGroup.createKadouTime();
                        kadouTime.setEigyoubiKbn(eigyoubiKbn);
                        kadouTime.setKadouTimeYoubiKbn(youbiKbn);
                        kadouTime.setKadouTimeSiteiKbn(C_KadouTimeSiteiKbn.HYOUJUN);
                        if( C_KadouTimeYoubiKbn.HYOUJYUN.eq(youbiKbn) ) {
                            kadouTime.setKadouTimeSiteiKbn(C_KadouTimeSiteiKbn.ZENJITURIYOU_KA);
                        }
                    }
                }
            }
            baseDomManager.update(kadouTimeGroup);
        }
    }

    @Transactional
    public void createTestL0027_03(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);

        AT_TokuteibiKadouTime tokuteibiKadouTime = kadouTimeGroup.getTokuteibiKadouTime(ALREADYSYORIYMD);
        if ( null == tokuteibiKadouTime ) {
            tokuteibiKadouTime = kadouTimeGroup.createTokuteibiKadouTime();
            tokuteibiKadouTime.setKadouTimeSiteiYmd(ALREADYSYORIYMD);
            tokuteibiKadouTime.setKadouTimeSiteiKbn(ALREADYSITEIKBN);

            baseDomManager.update(kadouTimeGroup);
        }
    }

    @Transactional
    public void deleteTestL0027_01(){

        baseDomManager.clear();
        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {
            kadouTimeGroup.getKadouTimes().removeAll(kadouTimeGroup.getKadouTimes());
            kadouTimeGroup.getTokuteibiKadouTimes().removeAll(kadouTimeGroup.getTokuteibiKadouTimes());

            baseDomManager.update(kadouTimeGroup);
            baseDomManager.delete(kadouTimeGroup);
        }
    }

    @Transactional
    public void createTestL0028_01(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null == kadouTimeGroup ) {
            kadouTimeGroup = new AT_KadouTimeGroup();
            kadouTimeGroup.setKadouTimeGroupCd(ALREADYKADOUTIMEGROUPCD);
            kadouTimeGroup.setKadouTimeGroupNm(ALREADYKADOUTIMEGROUPNM);
            kadouTimeGroup.setHolidayGroupCd(ALREADYKADOUTIMEGROUP_HOLIDAYGROUPCD);
            kadouTimeGroup.setKadouTimeGroupDescription(ALREADYKADOUTIMEGROUPBIKOU);

            baseDomManager.insert(kadouTimeGroup);
        }
    }


    @Transactional
    public void createTestL0028_02(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {

            C_KadouTimeYoubiKbn[] kadouTimeYoubiKbns = {C_KadouTimeYoubiKbn.GETUYOU, C_KadouTimeYoubiKbn.KAYOU, C_KadouTimeYoubiKbn.SUIYOU
                , C_KadouTimeYoubiKbn.MOKUYOU, C_KadouTimeYoubiKbn.KINYOU, C_KadouTimeYoubiKbn.DOYOU, C_KadouTimeYoubiKbn.NITIYOU, C_KadouTimeYoubiKbn.HYOUJYUN};
            C_EigyoubiKbn[] eigyoubiKbns = {C_EigyoubiKbn.EIGYOUBI, C_EigyoubiKbn.HIEIGYOUBI};

            for( C_EigyoubiKbn eigyoubiKbn : eigyoubiKbns ) {
                AT_KadouTime kadouTime = null;
                for ( C_KadouTimeYoubiKbn youbiKbn : kadouTimeYoubiKbns ) {
                    List<AT_KadouTime> kadouTimes = kadouTimeGroup.getKadouTimes();
                    if( kadouTimes.size() < 16) {

                        kadouTime = kadouTimeGroup.createKadouTime();
                        kadouTime.setEigyoubiKbn(eigyoubiKbn);
                        kadouTime.setKadouTimeYoubiKbn(youbiKbn);
                        kadouTime.setKadouTimeSiteiKbn(C_KadouTimeSiteiKbn.HYOUJUN);
                        if( C_KadouTimeYoubiKbn.HYOUJYUN.eq(youbiKbn) ) {
                            kadouTime.setKadouTimeSiteiKbn(C_KadouTimeSiteiKbn.ZENJITURIYOU_KA);
                        }
                    }
                }
            }
            baseDomManager.update(kadouTimeGroup);
        }
    }

    @Transactional
    public void createTestL0028_03(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);

        AT_TokuteibiKadouTime tokuteibiKadouTime = kadouTimeGroup.getTokuteibiKadouTime(ALREADYSYORIYMD);
        if ( null == tokuteibiKadouTime ) {
            tokuteibiKadouTime = kadouTimeGroup.createTokuteibiKadouTime();
            tokuteibiKadouTime.setKadouTimeSiteiYmd(ALREADYSYORIYMD);
            tokuteibiKadouTime.setKadouTimeSiteiKbn(ALREADYSITEIKBN);

            baseDomManager.update(kadouTimeGroup);
        }
    }

    @Transactional
    public void deleteTestL0028_01(){

        baseDomManager.clear();
        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {
            kadouTimeGroup.getKadouTimes().removeAll(kadouTimeGroup.getKadouTimes());
            kadouTimeGroup.getTokuteibiKadouTimes().removeAll(kadouTimeGroup.getTokuteibiKadouTimes());

            baseDomManager.update(kadouTimeGroup);
            baseDomManager.delete(kadouTimeGroup);
        }
    }

    @Transactional
    public void createTestL0029_01(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null == kadouTimeGroup ) {
            kadouTimeGroup = new AT_KadouTimeGroup();
            kadouTimeGroup.setKadouTimeGroupCd(ALREADYKADOUTIMEGROUPCD);
            kadouTimeGroup.setKadouTimeGroupNm(ALREADYKADOUTIMEGROUPNM);
            kadouTimeGroup.setHolidayGroupCd(ALREADYKADOUTIMEGROUP_HOLIDAYGROUPCD);
            kadouTimeGroup.setKadouTimeGroupDescription(ALREADYKADOUTIMEGROUPBIKOU);

            baseDomManager.insert(kadouTimeGroup);
        }
    }


    @Transactional
    public void createTestL0029_02(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {

            C_KadouTimeYoubiKbn[] kadouTimeYoubiKbns = {C_KadouTimeYoubiKbn.GETUYOU, C_KadouTimeYoubiKbn.KAYOU, C_KadouTimeYoubiKbn.SUIYOU
                , C_KadouTimeYoubiKbn.MOKUYOU, C_KadouTimeYoubiKbn.KINYOU, C_KadouTimeYoubiKbn.DOYOU, C_KadouTimeYoubiKbn.NITIYOU, C_KadouTimeYoubiKbn.HYOUJYUN};
            C_EigyoubiKbn[] eigyoubiKbns = {C_EigyoubiKbn.EIGYOUBI, C_EigyoubiKbn.HIEIGYOUBI};

            for( C_EigyoubiKbn eigyoubiKbn : eigyoubiKbns ) {
                AT_KadouTime kadouTime = null;
                for ( C_KadouTimeYoubiKbn youbiKbn : kadouTimeYoubiKbns ) {
                    List<AT_KadouTime> kadouTimes = kadouTimeGroup.getKadouTimes();
                    if( kadouTimes.size() < 16) {

                        kadouTime = kadouTimeGroup.createKadouTime();
                        kadouTime.setEigyoubiKbn(eigyoubiKbn);
                        kadouTime.setKadouTimeYoubiKbn(youbiKbn);
                        kadouTime.setKadouTimeSiteiKbn(C_KadouTimeSiteiKbn.HYOUJUN);
                        if( C_KadouTimeYoubiKbn.HYOUJYUN.eq(youbiKbn) ) {
                            kadouTime.setKadouTimeSiteiKbn(C_KadouTimeSiteiKbn.ZENJITURIYOU_KA);
                        }
                    }
                }
            }
            baseDomManager.update(kadouTimeGroup);
        }
    }

    @Transactional
    public void createTestL0029_03(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);

        AT_TokuteibiKadouTime tokuteibiKadouTime = kadouTimeGroup.getTokuteibiKadouTime(ALREADYSYORIYMD);
        if ( null == tokuteibiKadouTime ) {
            tokuteibiKadouTime = kadouTimeGroup.createTokuteibiKadouTime();
            tokuteibiKadouTime.setKadouTimeSiteiYmd(ALREADYSYORIYMD);
            tokuteibiKadouTime.setKadouTimeSiteiKbn(ALREADYSITEIKBN);

            baseDomManager.update(kadouTimeGroup);
        }
    }

    @Transactional
    public void deleteTestL0029_01(){

        baseDomManager.clear();
        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {
            kadouTimeGroup.getKadouTimes().removeAll(kadouTimeGroup.getKadouTimes());
            kadouTimeGroup.getTokuteibiKadouTimes().removeAll(kadouTimeGroup.getTokuteibiKadouTimes());

            baseDomManager.update(kadouTimeGroup);
            baseDomManager.delete(kadouTimeGroup);
        }
    }

    @Transactional
    public void createTestL0030_01(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null == kadouTimeGroup ) {
            kadouTimeGroup = new AT_KadouTimeGroup();
            kadouTimeGroup.setKadouTimeGroupCd(ALREADYKADOUTIMEGROUPCD);
            kadouTimeGroup.setKadouTimeGroupNm(ALREADYKADOUTIMEGROUPNM);
            kadouTimeGroup.setHolidayGroupCd(ALREADYKADOUTIMEGROUP_HOLIDAYGROUPCD);
            kadouTimeGroup.setKadouTimeGroupDescription(ALREADYKADOUTIMEGROUPBIKOU);

            baseDomManager.insert(kadouTimeGroup);
        }
    }


    @Transactional
    public void createTestL0030_02(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {

            C_KadouTimeYoubiKbn[] kadouTimeYoubiKbns = {C_KadouTimeYoubiKbn.GETUYOU, C_KadouTimeYoubiKbn.KAYOU, C_KadouTimeYoubiKbn.SUIYOU
                , C_KadouTimeYoubiKbn.MOKUYOU, C_KadouTimeYoubiKbn.KINYOU, C_KadouTimeYoubiKbn.DOYOU, C_KadouTimeYoubiKbn.NITIYOU, C_KadouTimeYoubiKbn.HYOUJYUN};
            C_EigyoubiKbn[] eigyoubiKbns = {C_EigyoubiKbn.EIGYOUBI, C_EigyoubiKbn.HIEIGYOUBI};

            for( C_EigyoubiKbn eigyoubiKbn : eigyoubiKbns ) {
                AT_KadouTime kadouTime = null;
                for ( C_KadouTimeYoubiKbn youbiKbn : kadouTimeYoubiKbns ) {
                    List<AT_KadouTime> kadouTimes = kadouTimeGroup.getKadouTimes();
                    if( kadouTimes.size() < 16) {

                        kadouTime = kadouTimeGroup.createKadouTime();
                        kadouTime.setEigyoubiKbn(eigyoubiKbn);
                        kadouTime.setKadouTimeYoubiKbn(youbiKbn);
                        kadouTime.setKadouTimeSiteiKbn(C_KadouTimeSiteiKbn.HYOUJUN);
                        if( C_KadouTimeYoubiKbn.HYOUJYUN.eq(youbiKbn) ) {
                            kadouTime.setKadouTimeSiteiKbn(C_KadouTimeSiteiKbn.ZENJITURIYOU_KA);
                        }
                    }
                }
            }
            baseDomManager.update(kadouTimeGroup);
        }
    }

    @Transactional
    public void createTestL0030_03(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);

        AT_TokuteibiKadouTime tokuteibiKadouTime = kadouTimeGroup.getTokuteibiKadouTime(ALREADYSYORIYMD);
        if ( null == tokuteibiKadouTime ) {
            tokuteibiKadouTime = kadouTimeGroup.createTokuteibiKadouTime();
            tokuteibiKadouTime.setKadouTimeSiteiYmd(ALREADYSYORIYMD);
            tokuteibiKadouTime.setKadouTimeSiteiKbn(ALREADYSITEIKBN);

            baseDomManager.update(kadouTimeGroup);
        }
    }

    @Transactional
    public void deleteTestL0030_01(){

        baseDomManager.clear();
        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {
            kadouTimeGroup.getKadouTimes().removeAll(kadouTimeGroup.getKadouTimes());
            kadouTimeGroup.getTokuteibiKadouTimes().removeAll(kadouTimeGroup.getTokuteibiKadouTimes());

            baseDomManager.update(kadouTimeGroup);
            baseDomManager.delete(kadouTimeGroup);
        }
    }

    @Transactional
    public void createTestL0031_01(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null == kadouTimeGroup ) {
            kadouTimeGroup = new AT_KadouTimeGroup();
            kadouTimeGroup.setKadouTimeGroupCd(ALREADYKADOUTIMEGROUPCD);
            kadouTimeGroup.setKadouTimeGroupNm(ALREADYKADOUTIMEGROUPNM);
            kadouTimeGroup.setHolidayGroupCd(ALREADYKADOUTIMEGROUP_HOLIDAYGROUPCD);
            kadouTimeGroup.setKadouTimeGroupDescription(ALREADYKADOUTIMEGROUPBIKOU);

            baseDomManager.insert(kadouTimeGroup);
        }
    }


    @Transactional
    public void createTestL0031_02(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {

            C_KadouTimeYoubiKbn[] kadouTimeYoubiKbns = {C_KadouTimeYoubiKbn.GETUYOU, C_KadouTimeYoubiKbn.KAYOU, C_KadouTimeYoubiKbn.SUIYOU
                , C_KadouTimeYoubiKbn.MOKUYOU, C_KadouTimeYoubiKbn.KINYOU, C_KadouTimeYoubiKbn.DOYOU, C_KadouTimeYoubiKbn.NITIYOU, C_KadouTimeYoubiKbn.HYOUJYUN};
            C_EigyoubiKbn[] eigyoubiKbns = {C_EigyoubiKbn.EIGYOUBI, C_EigyoubiKbn.HIEIGYOUBI};

            for( C_EigyoubiKbn eigyoubiKbn : eigyoubiKbns ) {
                AT_KadouTime kadouTime = null;
                for ( C_KadouTimeYoubiKbn youbiKbn : kadouTimeYoubiKbns ) {
                    List<AT_KadouTime> kadouTimes = kadouTimeGroup.getKadouTimes();
                    if( kadouTimes.size() < 16) {

                        kadouTime = kadouTimeGroup.createKadouTime();
                        kadouTime.setEigyoubiKbn(eigyoubiKbn);
                        kadouTime.setKadouTimeYoubiKbn(youbiKbn);
                        kadouTime.setKadouTimeSiteiKbn(C_KadouTimeSiteiKbn.HYOUJUN);
                        if( C_KadouTimeYoubiKbn.HYOUJYUN.eq(youbiKbn) ) {
                            kadouTime.setKadouTimeSiteiKbn(C_KadouTimeSiteiKbn.ZENJITURIYOU_KA);
                        }
                    }
                }
            }
            baseDomManager.update(kadouTimeGroup);
        }
    }

    @Transactional
    public void createTestL0031_03(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);

        AT_TokuteibiKadouTime tokuteibiKadouTime = kadouTimeGroup.getTokuteibiKadouTime(ALREADYSYORIYMD);
        if ( null == tokuteibiKadouTime ) {
            tokuteibiKadouTime = kadouTimeGroup.createTokuteibiKadouTime();
            tokuteibiKadouTime.setKadouTimeSiteiYmd(ALREADYSYORIYMD);
            tokuteibiKadouTime.setKadouTimeSiteiKbn(ALREADYSITEIKBN);

            baseDomManager.update(kadouTimeGroup);
        }
    }

    @Transactional
    public void deleteTestL0031_01(){

        baseDomManager.clear();
        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {
            kadouTimeGroup.getKadouTimes().removeAll(kadouTimeGroup.getKadouTimes());
            kadouTimeGroup.getTokuteibiKadouTimes().removeAll(kadouTimeGroup.getTokuteibiKadouTimes());

            baseDomManager.update(kadouTimeGroup);
            baseDomManager.delete(kadouTimeGroup);
        }
    }

    @Transactional
    public void createTestL0032_01(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null == kadouTimeGroup ) {
            kadouTimeGroup = new AT_KadouTimeGroup();
            kadouTimeGroup.setKadouTimeGroupCd(ALREADYKADOUTIMEGROUPCD);
            kadouTimeGroup.setKadouTimeGroupNm(ALREADYKADOUTIMEGROUPNM);
            kadouTimeGroup.setHolidayGroupCd(ALREADYKADOUTIMEGROUP_HOLIDAYGROUPCD);
            kadouTimeGroup.setKadouTimeGroupDescription(ALREADYKADOUTIMEGROUPBIKOU);

            baseDomManager.insert(kadouTimeGroup);
        }
    }


    @Transactional
    public void createTestL0032_02(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {

            C_KadouTimeYoubiKbn[] kadouTimeYoubiKbns = {C_KadouTimeYoubiKbn.GETUYOU, C_KadouTimeYoubiKbn.KAYOU, C_KadouTimeYoubiKbn.SUIYOU
                , C_KadouTimeYoubiKbn.MOKUYOU, C_KadouTimeYoubiKbn.KINYOU, C_KadouTimeYoubiKbn.DOYOU, C_KadouTimeYoubiKbn.NITIYOU, C_KadouTimeYoubiKbn.HYOUJYUN};
            C_EigyoubiKbn[] eigyoubiKbns = {C_EigyoubiKbn.EIGYOUBI, C_EigyoubiKbn.HIEIGYOUBI};

            for( C_EigyoubiKbn eigyoubiKbn : eigyoubiKbns ) {
                AT_KadouTime kadouTime = null;
                for ( C_KadouTimeYoubiKbn youbiKbn : kadouTimeYoubiKbns ) {
                    List<AT_KadouTime> kadouTimes = kadouTimeGroup.getKadouTimes();
                    if( kadouTimes.size() < 16) {

                        kadouTime = kadouTimeGroup.createKadouTime();
                        kadouTime.setEigyoubiKbn(eigyoubiKbn);
                        kadouTime.setKadouTimeYoubiKbn(youbiKbn);
                        kadouTime.setKadouTimeSiteiKbn(C_KadouTimeSiteiKbn.HYOUJUN);
                        if( C_KadouTimeYoubiKbn.HYOUJYUN.eq(youbiKbn) ) {
                            kadouTime.setKadouTimeSiteiKbn(C_KadouTimeSiteiKbn.ZENJITURIYOU_KA);
                        }
                    }
                }
            }
            baseDomManager.update(kadouTimeGroup);
        }
    }

    @Transactional
    public void createTestL0032_03(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);

        AT_TokuteibiKadouTime tokuteibiKadouTime = kadouTimeGroup.getTokuteibiKadouTime(ALREADYSYORIYMD);
        if ( null == tokuteibiKadouTime ) {
            tokuteibiKadouTime = kadouTimeGroup.createTokuteibiKadouTime();
            tokuteibiKadouTime.setKadouTimeSiteiYmd(ALREADYSYORIYMD);
            tokuteibiKadouTime.setKadouTimeSiteiKbn(ALREADYSITEIKBN);

            baseDomManager.update(kadouTimeGroup);
        }
    }

    @Transactional
    public void deleteTestL0032_01(){

        baseDomManager.clear();
        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {
            kadouTimeGroup.getKadouTimes().removeAll(kadouTimeGroup.getKadouTimes());
            kadouTimeGroup.getTokuteibiKadouTimes().removeAll(kadouTimeGroup.getTokuteibiKadouTimes());

            baseDomManager.update(kadouTimeGroup);
            baseDomManager.delete(kadouTimeGroup);
        }
    }

    @Transactional
    public void createTestL0033_01(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null == kadouTimeGroup ) {
            kadouTimeGroup = new AT_KadouTimeGroup();
            kadouTimeGroup.setKadouTimeGroupCd(ALREADYKADOUTIMEGROUPCD);
            kadouTimeGroup.setKadouTimeGroupNm(ALREADYKADOUTIMEGROUPNM);
            kadouTimeGroup.setHolidayGroupCd(ALREADYKADOUTIMEGROUP_HOLIDAYGROUPCD);
            kadouTimeGroup.setKadouTimeGroupDescription(ALREADYKADOUTIMEGROUPBIKOU);

            baseDomManager.insert(kadouTimeGroup);
        }
    }


    @Transactional
    public void createTestL0033_02(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {

            C_KadouTimeYoubiKbn[] kadouTimeYoubiKbns = {C_KadouTimeYoubiKbn.GETUYOU, C_KadouTimeYoubiKbn.KAYOU, C_KadouTimeYoubiKbn.SUIYOU
                , C_KadouTimeYoubiKbn.MOKUYOU, C_KadouTimeYoubiKbn.KINYOU, C_KadouTimeYoubiKbn.DOYOU, C_KadouTimeYoubiKbn.NITIYOU, C_KadouTimeYoubiKbn.HYOUJYUN};
            C_EigyoubiKbn[] eigyoubiKbns = {C_EigyoubiKbn.EIGYOUBI, C_EigyoubiKbn.HIEIGYOUBI};

            for( C_EigyoubiKbn eigyoubiKbn : eigyoubiKbns ) {
                AT_KadouTime kadouTime = null;
                for ( C_KadouTimeYoubiKbn youbiKbn : kadouTimeYoubiKbns ) {
                    List<AT_KadouTime> kadouTimes = kadouTimeGroup.getKadouTimes();
                    if( kadouTimes.size() < 16) {

                        kadouTime = kadouTimeGroup.createKadouTime();
                        kadouTime.setEigyoubiKbn(eigyoubiKbn);
                        kadouTime.setKadouTimeYoubiKbn(youbiKbn);
                        kadouTime.setKadouTimeSiteiKbn(C_KadouTimeSiteiKbn.HYOUJUN);
                        if( C_KadouTimeYoubiKbn.HYOUJYUN.eq(youbiKbn) ) {
                            kadouTime.setKadouTimeSiteiKbn(C_KadouTimeSiteiKbn.ZENJITURIYOU_KA);
                        }
                    }
                }
            }
            baseDomManager.update(kadouTimeGroup);
        }
    }

    @Transactional
    public void createTestL0033_03(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);

        AT_TokuteibiKadouTime tokuteibiKadouTime = kadouTimeGroup.getTokuteibiKadouTime(ALREADYSYORIYMD);
        if ( null == tokuteibiKadouTime ) {
            tokuteibiKadouTime = kadouTimeGroup.createTokuteibiKadouTime();
            tokuteibiKadouTime.setKadouTimeSiteiYmd(ALREADYSYORIYMD);
            tokuteibiKadouTime.setKadouTimeSiteiKbn(ALREADYSITEIKBN);

            baseDomManager.update(kadouTimeGroup);
        }
    }

    @Transactional
    public void deleteTestL0033_01(){

        baseDomManager.clear();
        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {
            kadouTimeGroup.getKadouTimes().removeAll(kadouTimeGroup.getKadouTimes());
            kadouTimeGroup.getTokuteibiKadouTimes().removeAll(kadouTimeGroup.getTokuteibiKadouTimes());

            baseDomManager.update(kadouTimeGroup);
            baseDomManager.delete(kadouTimeGroup);
        }
    }

    @Transactional
    public void createTestL0034_01(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null == kadouTimeGroup ) {
            kadouTimeGroup = new AT_KadouTimeGroup();
            kadouTimeGroup.setKadouTimeGroupCd(ALREADYKADOUTIMEGROUPCD);
            kadouTimeGroup.setKadouTimeGroupNm(ALREADYKADOUTIMEGROUPNM);
            kadouTimeGroup.setHolidayGroupCd(ALREADYKADOUTIMEGROUP_HOLIDAYGROUPCD);
            kadouTimeGroup.setKadouTimeGroupDescription(ALREADYKADOUTIMEGROUPBIKOU);

            baseDomManager.insert(kadouTimeGroup);
        }
    }


    @Transactional
    public void createTestL0034_02(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {

            C_KadouTimeYoubiKbn[] kadouTimeYoubiKbns = {C_KadouTimeYoubiKbn.GETUYOU, C_KadouTimeYoubiKbn.KAYOU, C_KadouTimeYoubiKbn.SUIYOU
                , C_KadouTimeYoubiKbn.MOKUYOU, C_KadouTimeYoubiKbn.KINYOU, C_KadouTimeYoubiKbn.DOYOU, C_KadouTimeYoubiKbn.NITIYOU, C_KadouTimeYoubiKbn.HYOUJYUN};
            C_EigyoubiKbn[] eigyoubiKbns = {C_EigyoubiKbn.EIGYOUBI, C_EigyoubiKbn.HIEIGYOUBI};

            for( C_EigyoubiKbn eigyoubiKbn : eigyoubiKbns ) {
                AT_KadouTime kadouTime = null;
                for ( C_KadouTimeYoubiKbn youbiKbn : kadouTimeYoubiKbns ) {
                    List<AT_KadouTime> kadouTimes = kadouTimeGroup.getKadouTimes();
                    if( kadouTimes.size() < 16) {

                        kadouTime = kadouTimeGroup.createKadouTime();
                        kadouTime.setEigyoubiKbn(eigyoubiKbn);
                        kadouTime.setKadouTimeYoubiKbn(youbiKbn);
                        kadouTime.setKadouTimeSiteiKbn(C_KadouTimeSiteiKbn.HYOUJUN);
                        if( C_KadouTimeYoubiKbn.HYOUJYUN.eq(youbiKbn) ) {
                            kadouTime.setKadouTimeSiteiKbn(C_KadouTimeSiteiKbn.ZENJITURIYOU_KA);
                        }
                    }
                }
            }
            baseDomManager.update(kadouTimeGroup);
        }
    }

    @Transactional
    public void createTestL0034_03(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);

        AT_TokuteibiKadouTime tokuteibiKadouTime = kadouTimeGroup.getTokuteibiKadouTime(ALREADYSYORIYMD);
        if ( null == tokuteibiKadouTime ) {
            tokuteibiKadouTime = kadouTimeGroup.createTokuteibiKadouTime();
            tokuteibiKadouTime.setKadouTimeSiteiYmd(ALREADYSYORIYMD);
            tokuteibiKadouTime.setKadouTimeSiteiKbn(ALREADYSITEIKBN);

            baseDomManager.update(kadouTimeGroup);
        }
    }

    @Transactional
    public void deleteTestL0034_01(){

        baseDomManager.clear();
        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {
            kadouTimeGroup.getKadouTimes().removeAll(kadouTimeGroup.getKadouTimes());
            kadouTimeGroup.getTokuteibiKadouTimes().removeAll(kadouTimeGroup.getTokuteibiKadouTimes());

            baseDomManager.update(kadouTimeGroup);
            baseDomManager.delete(kadouTimeGroup);
        }
    }

    @Transactional
    public void createTestL0035_01(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null == kadouTimeGroup ) {
            kadouTimeGroup = new AT_KadouTimeGroup();
            kadouTimeGroup.setKadouTimeGroupCd(ALREADYKADOUTIMEGROUPCD);
            kadouTimeGroup.setKadouTimeGroupNm(ALREADYKADOUTIMEGROUPNM);
            kadouTimeGroup.setHolidayGroupCd(ALREADYKADOUTIMEGROUP_HOLIDAYGROUPCD);
            kadouTimeGroup.setKadouTimeGroupDescription(ALREADYKADOUTIMEGROUPBIKOU);

            baseDomManager.insert(kadouTimeGroup);
        }
    }


    @Transactional
    public void createTestL0035_02(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {

            C_KadouTimeYoubiKbn[] kadouTimeYoubiKbns = {C_KadouTimeYoubiKbn.GETUYOU, C_KadouTimeYoubiKbn.KAYOU, C_KadouTimeYoubiKbn.SUIYOU
                , C_KadouTimeYoubiKbn.MOKUYOU, C_KadouTimeYoubiKbn.KINYOU, C_KadouTimeYoubiKbn.DOYOU, C_KadouTimeYoubiKbn.NITIYOU, C_KadouTimeYoubiKbn.HYOUJYUN};
            C_EigyoubiKbn[] eigyoubiKbns = {C_EigyoubiKbn.EIGYOUBI, C_EigyoubiKbn.HIEIGYOUBI};

            for( C_EigyoubiKbn eigyoubiKbn : eigyoubiKbns ) {
                AT_KadouTime kadouTime = null;
                for ( C_KadouTimeYoubiKbn youbiKbn : kadouTimeYoubiKbns ) {
                    List<AT_KadouTime> kadouTimes = kadouTimeGroup.getKadouTimes();
                    if( kadouTimes.size() < 16) {

                        kadouTime = kadouTimeGroup.createKadouTime();
                        kadouTime.setEigyoubiKbn(eigyoubiKbn);
                        kadouTime.setKadouTimeYoubiKbn(youbiKbn);
                        kadouTime.setKadouTimeSiteiKbn(C_KadouTimeSiteiKbn.HYOUJUN);
                        if( C_KadouTimeYoubiKbn.HYOUJYUN.eq(youbiKbn) ) {
                            kadouTime.setKadouTimeSiteiKbn(C_KadouTimeSiteiKbn.ZENJITURIYOU_KA);
                        }
                    }
                }
            }
            baseDomManager.update(kadouTimeGroup);
        }
    }

    @Transactional
    public void createTestL0035_03(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);

        AT_TokuteibiKadouTime tokuteibiKadouTime = kadouTimeGroup.getTokuteibiKadouTime(ALREADYSYORIYMD);
        if ( null == tokuteibiKadouTime ) {
            tokuteibiKadouTime = kadouTimeGroup.createTokuteibiKadouTime();
            tokuteibiKadouTime.setKadouTimeSiteiYmd(ALREADYSYORIYMD);
            tokuteibiKadouTime.setKadouTimeSiteiKbn(ALREADYSITEIKBN);

            baseDomManager.update(kadouTimeGroup);
        }
    }

    @Transactional
    public void deleteTestL0035_01(){

        baseDomManager.clear();
        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {
            kadouTimeGroup.getKadouTimes().removeAll(kadouTimeGroup.getKadouTimes());
            kadouTimeGroup.getTokuteibiKadouTimes().removeAll(kadouTimeGroup.getTokuteibiKadouTimes());

            baseDomManager.update(kadouTimeGroup);
            baseDomManager.delete(kadouTimeGroup);
        }
    }

    @Transactional
    public void createTestL0036_01(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null == kadouTimeGroup ) {
            kadouTimeGroup = new AT_KadouTimeGroup();
            kadouTimeGroup.setKadouTimeGroupCd(ALREADYKADOUTIMEGROUPCD);
            kadouTimeGroup.setKadouTimeGroupNm(ALREADYKADOUTIMEGROUPNM);
            kadouTimeGroup.setHolidayGroupCd(ALREADYKADOUTIMEGROUP_HOLIDAYGROUPCD);
            kadouTimeGroup.setKadouTimeGroupDescription(ALREADYKADOUTIMEGROUPBIKOU);

            baseDomManager.insert(kadouTimeGroup);
        }
    }


    @Transactional
    public void createTestL0036_02(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {

            C_KadouTimeYoubiKbn[] kadouTimeYoubiKbns = {C_KadouTimeYoubiKbn.GETUYOU, C_KadouTimeYoubiKbn.KAYOU, C_KadouTimeYoubiKbn.SUIYOU
                , C_KadouTimeYoubiKbn.MOKUYOU, C_KadouTimeYoubiKbn.KINYOU, C_KadouTimeYoubiKbn.DOYOU, C_KadouTimeYoubiKbn.NITIYOU, C_KadouTimeYoubiKbn.HYOUJYUN};
            C_EigyoubiKbn[] eigyoubiKbns = {C_EigyoubiKbn.EIGYOUBI, C_EigyoubiKbn.HIEIGYOUBI};

            for( C_EigyoubiKbn eigyoubiKbn : eigyoubiKbns ) {
                AT_KadouTime kadouTime = null;
                for ( C_KadouTimeYoubiKbn youbiKbn : kadouTimeYoubiKbns ) {
                    List<AT_KadouTime> kadouTimes = kadouTimeGroup.getKadouTimes();
                    if( kadouTimes.size() < 16) {

                        kadouTime = kadouTimeGroup.createKadouTime();
                        kadouTime.setEigyoubiKbn(eigyoubiKbn);
                        kadouTime.setKadouTimeYoubiKbn(youbiKbn);
                        kadouTime.setKadouTimeSiteiKbn(C_KadouTimeSiteiKbn.HYOUJUN);
                        if( C_KadouTimeYoubiKbn.HYOUJYUN.eq(youbiKbn) ) {
                            kadouTime.setKadouTimeSiteiKbn(C_KadouTimeSiteiKbn.ZENJITURIYOU_KA);
                        }
                    }
                }
            }
            baseDomManager.update(kadouTimeGroup);
        }
    }

    @Transactional
    public void createTestL0036_03(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);

        AT_TokuteibiKadouTime tokuteibiKadouTime = kadouTimeGroup.getTokuteibiKadouTime(ALREADYSYORIYMD);
        if ( null == tokuteibiKadouTime ) {
            tokuteibiKadouTime = kadouTimeGroup.createTokuteibiKadouTime();
            tokuteibiKadouTime.setKadouTimeSiteiYmd(ALREADYSYORIYMD);
            tokuteibiKadouTime.setKadouTimeSiteiKbn(ALREADYSITEIKBN);

            baseDomManager.update(kadouTimeGroup);
        }
    }

    @Transactional
    public void deleteTestL0036_01(){

        baseDomManager.clear();
        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {
            kadouTimeGroup.getKadouTimes().removeAll(kadouTimeGroup.getKadouTimes());
            kadouTimeGroup.getTokuteibiKadouTimes().removeAll(kadouTimeGroup.getTokuteibiKadouTimes());

            baseDomManager.update(kadouTimeGroup);
            baseDomManager.delete(kadouTimeGroup);
        }
    }

    @Transactional
    public void createTestL0037_01(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null == kadouTimeGroup ) {
            kadouTimeGroup = new AT_KadouTimeGroup();
            kadouTimeGroup.setKadouTimeGroupCd(ALREADYKADOUTIMEGROUPCD);
            kadouTimeGroup.setKadouTimeGroupNm(ALREADYKADOUTIMEGROUPNM);
            kadouTimeGroup.setHolidayGroupCd(ALREADYKADOUTIMEGROUP_HOLIDAYGROUPCD);
            kadouTimeGroup.setKadouTimeGroupDescription(ALREADYKADOUTIMEGROUPBIKOU);

            baseDomManager.insert(kadouTimeGroup);
        }
    }


    @Transactional
    public void createTestL0037_02(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {

            C_KadouTimeYoubiKbn[] kadouTimeYoubiKbns = {C_KadouTimeYoubiKbn.GETUYOU, C_KadouTimeYoubiKbn.KAYOU, C_KadouTimeYoubiKbn.SUIYOU
                , C_KadouTimeYoubiKbn.MOKUYOU, C_KadouTimeYoubiKbn.KINYOU, C_KadouTimeYoubiKbn.DOYOU, C_KadouTimeYoubiKbn.NITIYOU, C_KadouTimeYoubiKbn.HYOUJYUN};
            C_EigyoubiKbn[] eigyoubiKbns = {C_EigyoubiKbn.EIGYOUBI, C_EigyoubiKbn.HIEIGYOUBI};

            for( C_EigyoubiKbn eigyoubiKbn : eigyoubiKbns ) {
                AT_KadouTime kadouTime = null;
                for ( C_KadouTimeYoubiKbn youbiKbn : kadouTimeYoubiKbns ) {
                    List<AT_KadouTime> kadouTimes = kadouTimeGroup.getKadouTimes();
                    if( kadouTimes.size() < 16) {

                        kadouTime = kadouTimeGroup.createKadouTime();
                        kadouTime.setEigyoubiKbn(eigyoubiKbn);
                        kadouTime.setKadouTimeYoubiKbn(youbiKbn);
                        kadouTime.setKadouTimeSiteiKbn(C_KadouTimeSiteiKbn.HYOUJUN);
                        if( C_KadouTimeYoubiKbn.HYOUJYUN.eq(youbiKbn) ) {
                            kadouTime.setKadouTimeSiteiKbn(C_KadouTimeSiteiKbn.ZENJITURIYOU_KA);
                        }
                    }
                }
            }
            baseDomManager.update(kadouTimeGroup);
        }
    }

    @Transactional
    public void deleteTestL0037_01(){

        baseDomManager.clear();
        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {
            kadouTimeGroup.getKadouTimes().removeAll(kadouTimeGroup.getKadouTimes());
            kadouTimeGroup.getTokuteibiKadouTimes().removeAll(kadouTimeGroup.getTokuteibiKadouTimes());

            baseDomManager.update(kadouTimeGroup);
            baseDomManager.delete(kadouTimeGroup);
        }
    }

    @Transactional
    public void createTestL0038_01(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null == kadouTimeGroup ) {
            kadouTimeGroup = new AT_KadouTimeGroup();
            kadouTimeGroup.setKadouTimeGroupCd(ALREADYKADOUTIMEGROUPCD);
            kadouTimeGroup.setKadouTimeGroupNm(ALREADYKADOUTIMEGROUPNM);
            kadouTimeGroup.setHolidayGroupCd(ALREADYKADOUTIMEGROUP_HOLIDAYGROUPCD);
            kadouTimeGroup.setKadouTimeGroupDescription(ALREADYKADOUTIMEGROUPBIKOU);

            baseDomManager.insert(kadouTimeGroup);
        }
    }


    @Transactional
    public void createTestL0038_02(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {

            C_KadouTimeYoubiKbn[] kadouTimeYoubiKbns = {C_KadouTimeYoubiKbn.GETUYOU, C_KadouTimeYoubiKbn.KAYOU, C_KadouTimeYoubiKbn.SUIYOU
                , C_KadouTimeYoubiKbn.MOKUYOU, C_KadouTimeYoubiKbn.KINYOU, C_KadouTimeYoubiKbn.DOYOU, C_KadouTimeYoubiKbn.NITIYOU, C_KadouTimeYoubiKbn.HYOUJYUN};
            C_EigyoubiKbn[] eigyoubiKbns = {C_EigyoubiKbn.EIGYOUBI, C_EigyoubiKbn.HIEIGYOUBI};

            for( C_EigyoubiKbn eigyoubiKbn : eigyoubiKbns ) {
                AT_KadouTime kadouTime = null;
                for ( C_KadouTimeYoubiKbn youbiKbn : kadouTimeYoubiKbns ) {
                    List<AT_KadouTime> kadouTimes = kadouTimeGroup.getKadouTimes();
                    if( kadouTimes.size() < 16) {

                        kadouTime = kadouTimeGroup.createKadouTime();
                        kadouTime.setEigyoubiKbn(eigyoubiKbn);
                        kadouTime.setKadouTimeYoubiKbn(youbiKbn);
                        kadouTime.setKadouTimeSiteiKbn(C_KadouTimeSiteiKbn.HYOUJUN);
                        if( C_KadouTimeYoubiKbn.HYOUJYUN.eq(youbiKbn) ) {
                            kadouTime.setKadouTimeSiteiKbn(C_KadouTimeSiteiKbn.ZENJITURIYOU_KA);
                        }
                    }
                }
            }
            baseDomManager.update(kadouTimeGroup);
        }
    }

    @Transactional
    public void createTestL0038_03(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);

        AT_TokuteibiKadouTime tokuteibiKadouTime = kadouTimeGroup.getTokuteibiKadouTime(ALREADYSYORIYMD);
        if ( null == tokuteibiKadouTime ) {
            tokuteibiKadouTime = kadouTimeGroup.createTokuteibiKadouTime();
            tokuteibiKadouTime.setKadouTimeSiteiYmd(ALREADYSYORIYMD);
            tokuteibiKadouTime.setKadouTimeSiteiKbn(ALREADYSITEIKBN);

            baseDomManager.update(kadouTimeGroup);
        }
    }

    @Transactional
    public void deleteTestL0038_01(){

        baseDomManager.clear();
        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {
            kadouTimeGroup.getKadouTimes().removeAll(kadouTimeGroup.getKadouTimes());
            kadouTimeGroup.getTokuteibiKadouTimes().removeAll(kadouTimeGroup.getTokuteibiKadouTimes());

            baseDomManager.update(kadouTimeGroup);
            baseDomManager.delete(kadouTimeGroup);
        }
    }

    public String getSeirekiWareki(){

        SeirekiWarekiKbn kbn = BizDateConfig.getInstance().getSeirekiWarekiKbn();

        String sSeirekiWareki = "";
        sSeirekiWareki = ReportBizDateFormatUtil.toFormatedYmd(BizDate.getSysDate());
        switch (kbn) {
            case SEIREKI:
                sSeirekiWareki = sSeirekiWareki.replace("/", "");
                break;
            case WAREKI_INPUT:
                sSeirekiWareki = sSeirekiWareki.replace("/", "");
                break;
            case WAREKI_KANJI:
            case WAREKI_SYMBOL:
                sSeirekiWareki = sSeirekiWareki.replace("/", "");
                break;
            default:
                throw new RuntimeException("西暦和暦区分が不正です。 設定値 = " + kbn);
        }

        return sSeirekiWareki;
    }
}
