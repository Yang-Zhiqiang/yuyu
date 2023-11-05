package yuyu.app.base.system.kadoutimetouroku;

import static yuyu.app.base.system.kadoutimetouroku.SeleniumKadouTimeTourokuConstants.*;

import javax.inject.Inject;
import javax.transaction.Transactional;

import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.classification.C_EigyoubiKbn;
import yuyu.def.classification.C_KadouTimeSiteiKbn;
import yuyu.def.classification.C_KadouTimeYoubiKbn;
import yuyu.def.db.entity.AT_KadouTime;
import yuyu.def.db.entity.AT_KadouTimeGroup;

public class SeleniumKadouTimeTourokuDB {

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

            baseDomManager.update(kadouTimeGroup);
            baseDomManager.delete(kadouTimeGroup);
        }
    }

    @Transactional
    public void createTestB0004_01(){

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
    public void createTestB0004_02(){

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
                }
            }
            baseDomManager.update(kadouTimeGroup);
        }
    }

    @Transactional
    public void deleteTestB0004_01(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {
            kadouTimeGroup.getKadouTimes().removeAll(kadouTimeGroup.getKadouTimes());

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
                }
            }
            baseDomManager.update(kadouTimeGroup);
        }
    }

    @Transactional
    public void deleteTestB0006_01(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {
            kadouTimeGroup.getKadouTimes().removeAll(kadouTimeGroup.getKadouTimes());

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
                }
            }
            baseDomManager.update(kadouTimeGroup);
        }
    }

    @Transactional
    public void deleteTestB0007_01(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {
            kadouTimeGroup.getKadouTimes().removeAll(kadouTimeGroup.getKadouTimes());

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
                }
            }
            baseDomManager.update(kadouTimeGroup);
        }
    }

    @Transactional
    public void deleteTestB0008_01(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {
            kadouTimeGroup.getKadouTimes().removeAll(kadouTimeGroup.getKadouTimes());

            baseDomManager.update(kadouTimeGroup);
            baseDomManager.delete(kadouTimeGroup);
        }
    }

    @Transactional
    public void createTestB0009_01(){

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
    public void createTestB0009_02(){

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
                }
            }
            baseDomManager.update(kadouTimeGroup);
        }
    }

    @Transactional
    public void deleteTestB0009_01(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {
            kadouTimeGroup.getKadouTimes().removeAll(kadouTimeGroup.getKadouTimes());

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
                }
            }
            baseDomManager.update(kadouTimeGroup);
        }
    }

    @Transactional
    public void deleteTestB0010_01(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {
            kadouTimeGroup.getKadouTimes().removeAll(kadouTimeGroup.getKadouTimes());

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
                }
            }
            baseDomManager.update(kadouTimeGroup);
        }
    }

    @Transactional
    public void deleteTestB0011_01(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {
            kadouTimeGroup.getKadouTimes().removeAll(kadouTimeGroup.getKadouTimes());

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
                }
            }
            baseDomManager.update(kadouTimeGroup);
        }
    }

    @Transactional
    public void deleteTestB0012_01(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {
            kadouTimeGroup.getKadouTimes().removeAll(kadouTimeGroup.getKadouTimes());

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
                }
            }
            baseDomManager.update(kadouTimeGroup);
        }
    }

    @Transactional
    public void deleteTestB0013_01(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {
            kadouTimeGroup.getKadouTimes().removeAll(kadouTimeGroup.getKadouTimes());

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
                }
            }
            baseDomManager.update(kadouTimeGroup);
        }
    }

    @Transactional
    public void deleteTestB0014_01(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {
            kadouTimeGroup.getKadouTimes().removeAll(kadouTimeGroup.getKadouTimes());

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
                }
            }
            baseDomManager.update(kadouTimeGroup);
        }
    }

    @Transactional
    public void deleteTestB0015_01(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {
            kadouTimeGroup.getKadouTimes().removeAll(kadouTimeGroup.getKadouTimes());

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
                }
            }
            baseDomManager.update(kadouTimeGroup);
        }
    }

    @Transactional
    public void deleteTestB0016_01(){

        baseDomManager.clear();
        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {
            kadouTimeGroup.getKadouTimes().removeAll(kadouTimeGroup.getKadouTimes());

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
                }
            }
            baseDomManager.update(kadouTimeGroup);
        }
    }

    @Transactional
    public void deleteTestB0017_01(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {
            kadouTimeGroup.getKadouTimes().removeAll(kadouTimeGroup.getKadouTimes());

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
                }
            }
            baseDomManager.update(kadouTimeGroup);
        }
    }

    @Transactional
    public void deleteTestB0018_01(){

        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {
            kadouTimeGroup.getKadouTimes().removeAll(kadouTimeGroup.getKadouTimes());

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
                }
            }
            baseDomManager.update(kadouTimeGroup);
        }
    }

    @Transactional
    public void deleteTestB0019_01(){

        baseDomManager.clear();
        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {
            kadouTimeGroup.getKadouTimes().removeAll(kadouTimeGroup.getKadouTimes());

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
                }
            }
            baseDomManager.update(kadouTimeGroup);
        }
    }

    @Transactional
    public void deleteTestB0020_01(){

        baseDomManager.clear();
        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {
            kadouTimeGroup.getKadouTimes().removeAll(kadouTimeGroup.getKadouTimes());

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
                }
            }
            baseDomManager.update(kadouTimeGroup);
        }
    }

    @Transactional
    public void deleteTestB0021_01(){

        baseDomManager.clear();
        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {
            kadouTimeGroup.getKadouTimes().removeAll(kadouTimeGroup.getKadouTimes());

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
                }
            }
            baseDomManager.update(kadouTimeGroup);
        }
    }

    @Transactional
    public void deleteTestL0006_01(){

        baseDomManager.clear();
        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {
            kadouTimeGroup.getKadouTimes().removeAll(kadouTimeGroup.getKadouTimes());

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
                }
            }
            baseDomManager.update(kadouTimeGroup);
        }
    }

    @Transactional
    public void deleteTestL0007_01(){

        baseDomManager.clear();
        AT_KadouTimeGroup kadouTimeGroup = baseDomManager.getKadouTimeGroup(ALREADYKADOUTIMEGROUPCD);
        if ( null != kadouTimeGroup ) {
            kadouTimeGroup.getKadouTimes().removeAll(kadouTimeGroup.getKadouTimes());

            baseDomManager.update(kadouTimeGroup);
            baseDomManager.delete(kadouTimeGroup);
        }
    }
}
