package yuyu.app.base.system.kinouteigitouroku;

import static yuyu.app.base.system.kinouteigitouroku.SeleniumKinouTeigiTourokuConstants.*;

import javax.inject.Inject;
import javax.transaction.Transactional;

import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.db.entity.AM_Role;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.AS_KinouMode;
import yuyu.def.db.entity.AS_KinouModeSiborikomi;
import yuyu.def.db.entity.AT_KinouKengen;

public class SeleniumKinouTeigiTourokuDB {

    @Inject
    private BaseDomManager baseDomManager;

    @Transactional
    public void createTestB0004_01(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null == kinou ) {

            kinou = new AS_Kinou();
            kinou.setKinouId(ALREADYKINOUID);
            kinou.setSubSystemId(ALREADYSUBSYSTEMID);
            kinou.setCategoryId(ALREADYCATEGORYID);
            kinou.setKinouNm(ALREADYKINOUNM);
            kinou.setSortNo(Integer.parseInt(ALREADYSORTNO));
            kinou.setKinouKbn(ALREADYKINOUKBN);
            kinou.setBatchKyouseiSyuuryouFlag(ALREADYBATCHKYOUSEISYUURYOUFLAG);
            kinou.setMenuHyoujiKahi(ALREADYMENUHYOUJIKBN);
            kinou.setBatchLogHyoujiKbn(ALREADYBATCHLOGHYOUJIKBN);
            kinou.setKidouKengenHanteiYouhiKbn(ALREADYKINOUGENKENHANTEIYOUHIKBN);
            kinou.setKinouTeigiTaisyouKbn(ALREADYKINOUTEIGITAISYOUKBN);

            baseDomManager.insert(kinou);
        }
    }

    @Transactional
    public void createTestB0004_02(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null == kinouMode ) {

                kinouMode = kinou.createKinouMode();
                kinouMode.setKinouModeId(ALREADYKINOUMODEID);
                kinouMode.setKinouModeNm(ALREADYKINOUMODENM);
                kinouMode.setSortNo(Integer.parseInt(ALREADYKINOUMODESORTNO));
                kinouMode.setYuukouKbn(ALREADYYUUKOUKBN);
                kinouMode.setKadouTimeGroupCd(ALREADYKADOUTIMEGROUPCD);
                kinouMode.setBatchHeisouKahiKbn(ALREADYBATCHHEISOUKAHIKBN);

                baseDomManager.update(kinou);
            }
        }
    }

    @Transactional
    public void deleteTestB0004_01(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            kinou.getKinouModes().removeAll(kinou.getKinouModes());

            baseDomManager.update(kinou);
            baseDomManager.delete(kinou);
        }
    }

    @Transactional
    public void createTestB0005_01(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null == kinou ) {

            kinou = new AS_Kinou();
            kinou.setKinouId(ALREADYKINOUID);
            kinou.setSubSystemId(ALREADYSUBSYSTEMID);
            kinou.setCategoryId(ALREADYCATEGORYID);
            kinou.setKinouNm(ALREADYKINOUNM);
            kinou.setSortNo(Integer.parseInt(ALREADYSORTNO));
            kinou.setKinouKbn(ALREADYKINOUKBN);
            kinou.setBatchKyouseiSyuuryouFlag(ALREADYBATCHKYOUSEISYUURYOUFLAG);
            kinou.setMenuHyoujiKahi(ALREADYMENUHYOUJIKBN);
            kinou.setBatchLogHyoujiKbn(ALREADYBATCHLOGHYOUJIKBN);
            kinou.setKidouKengenHanteiYouhiKbn(ALREADYKINOUGENKENHANTEIYOUHIKBN);
            kinou.setKinouTeigiTaisyouKbn(ALREADYKINOUTEIGITAISYOUKBN);

            baseDomManager.insert(kinou);
        }
    }

    @Transactional
    public void createTestB0005_02(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null == kinouMode ) {

                kinouMode = kinou.createKinouMode();
                kinouMode.setKinouModeId(ALREADYKINOUMODEID);
                kinouMode.setKinouModeNm(ALREADYKINOUMODENM);
                kinouMode.setSortNo(Integer.parseInt(ALREADYKINOUMODESORTNO));
                kinouMode.setYuukouKbn(ALREADYYUUKOUKBN);
                kinouMode.setKadouTimeGroupCd(ALREADYKADOUTIMEGROUPCD);
                kinouMode.setBatchHeisouKahiKbn(ALREADYBATCHHEISOUKAHIKBN);

                baseDomManager.update(kinou);
            }
        }
    }

    @Transactional
    public void deleteTestB0005_01(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            kinou.getKinouModes().removeAll(kinou.getKinouModes());

            baseDomManager.update(kinou);
            baseDomManager.delete(kinou);
        }
    }

    @Transactional
    public void createTestB0006_01(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null == kinou ) {

            kinou = new AS_Kinou();
            kinou.setKinouId(ALREADYKINOUID);
            kinou.setSubSystemId(ALREADYSUBSYSTEMID);
            kinou.setCategoryId(ALREADYCATEGORYID);
            kinou.setKinouNm(ALREADYKINOUNM);
            kinou.setSortNo(Integer.parseInt(ALREADYSORTNO));
            kinou.setKinouKbn(ALREADYKINOUKBN);
            kinou.setBatchKyouseiSyuuryouFlag(ALREADYBATCHKYOUSEISYUURYOUFLAG);
            kinou.setMenuHyoujiKahi(ALREADYMENUHYOUJIKBN);
            kinou.setBatchLogHyoujiKbn(ALREADYBATCHLOGHYOUJIKBN);
            kinou.setKidouKengenHanteiYouhiKbn(ALREADYKINOUGENKENHANTEIYOUHIKBN);
            kinou.setKinouTeigiTaisyouKbn(ALREADYKINOUTEIGITAISYOUKBN);

            baseDomManager.insert(kinou);
        }
    }

    @Transactional
    public void createTestB0006_02(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null == kinouMode ) {

                kinouMode = kinou.createKinouMode();
                kinouMode.setKinouModeId(ALREADYKINOUMODEID);
                kinouMode.setKinouModeNm(ALREADYKINOUMODENM);
                kinouMode.setSortNo(Integer.parseInt(ALREADYKINOUMODESORTNO));
                kinouMode.setYuukouKbn(ALREADYYUUKOUKBN);
                kinouMode.setKadouTimeGroupCd(ALREADYKADOUTIMEGROUPCD);
                kinouMode.setBatchHeisouKahiKbn(ALREADYBATCHHEISOUKAHIKBN);

                baseDomManager.update(kinou);
            }
        }
    }

    @Transactional
    public void deleteTestB0006_01(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            kinou.getKinouModes().removeAll(kinou.getKinouModes());

            baseDomManager.update(kinou);
            baseDomManager.delete(kinou);
        }
    }

    @Transactional
    public void createTestB0007_01(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null == kinou ) {

            kinou = new AS_Kinou();
            kinou.setKinouId(ALREADYKINOUID);
            kinou.setSubSystemId(ALREADYSUBSYSTEMID);
            kinou.setCategoryId(ALREADYCATEGORYID);
            kinou.setKinouNm(ALREADYKINOUNM);
            kinou.setSortNo(Integer.parseInt(ALREADYSORTNO));
            kinou.setKinouKbn(ALREADYKINOUKBN);
            kinou.setBatchKyouseiSyuuryouFlag(ALREADYBATCHKYOUSEISYUURYOUFLAG);
            kinou.setMenuHyoujiKahi(ALREADYMENUHYOUJIKBN);
            kinou.setBatchLogHyoujiKbn(ALREADYBATCHLOGHYOUJIKBN);
            kinou.setKidouKengenHanteiYouhiKbn(ALREADYKINOUGENKENHANTEIYOUHIKBN);
            kinou.setKinouTeigiTaisyouKbn(ALREADYKINOUTEIGITAISYOUKBN);

            baseDomManager.insert(kinou);
        }
    }

    @Transactional
    public void createTestB0007_02(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null == kinouMode ) {

                kinouMode = kinou.createKinouMode();
                kinouMode.setKinouModeId(ALREADYKINOUMODEID);
                kinouMode.setKinouModeNm(ALREADYKINOUMODENM);
                kinouMode.setSortNo(Integer.parseInt(ALREADYKINOUMODESORTNO));
                kinouMode.setYuukouKbn(ALREADYYUUKOUKBN);
                kinouMode.setKadouTimeGroupCd(ALREADYKADOUTIMEGROUPCD);
                kinouMode.setBatchHeisouKahiKbn(ALREADYBATCHHEISOUKAHIKBN);

                baseDomManager.update(kinou);
            }
        }
    }

    @Transactional
    public void deleteTestB0007_01(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            kinou.getKinouModes().removeAll(kinou.getKinouModes());

            baseDomManager.update(kinou);
            baseDomManager.delete(kinou);
        }
    }

    @Transactional
    public void createTestB0008_01(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null == kinou ) {

            kinou = new AS_Kinou();
            kinou.setKinouId(ALREADYKINOUID);
            kinou.setSubSystemId(ALREADYSUBSYSTEMID);
            kinou.setCategoryId(ALREADYCATEGORYID);
            kinou.setKinouNm(ALREADYKINOUNM);
            kinou.setSortNo(Integer.parseInt(ALREADYSORTNO));
            kinou.setKinouKbn(ALREADYKINOUKBN);
            kinou.setBatchKyouseiSyuuryouFlag(ALREADYBATCHKYOUSEISYUURYOUFLAG);
            kinou.setMenuHyoujiKahi(ALREADYMENUHYOUJIKBN);
            kinou.setBatchLogHyoujiKbn(ALREADYBATCHLOGHYOUJIKBN);
            kinou.setKidouKengenHanteiYouhiKbn(ALREADYKINOUGENKENHANTEIYOUHIKBN);
            kinou.setKinouTeigiTaisyouKbn(ALREADYKINOUTEIGITAISYOUKBN);

            baseDomManager.insert(kinou);
        }
    }

    @Transactional
    public void createTestB0008_02(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null == kinouMode ) {

                kinouMode = kinou.createKinouMode();
                kinouMode.setKinouModeId(ALREADYKINOUMODEID);
                kinouMode.setKinouModeNm(ALREADYKINOUMODENM);
                kinouMode.setSortNo(Integer.parseInt(ALREADYKINOUMODESORTNO));
                kinouMode.setYuukouKbn(ALREADYYUUKOUKBN);
                kinouMode.setKadouTimeGroupCd(ALREADYKADOUTIMEGROUPCD);
                kinouMode.setBatchHeisouKahiKbn(ALREADYBATCHHEISOUKAHIKBN);

                baseDomManager.update(kinou);
            }
        }
    }

    @Transactional
    public void createTestB0008_03(){

        AM_Role role = baseDomManager.getRole(ALREADYROLECD);
        if ( null == role ) {

            role = new AM_Role();
            role.setRoleCd(ALREADYROLECD);
            role.setRoleNm(ALREADYROLENM);
            role.setRoleSetumei(ALREADYROLESETUMEI);
            role.setSysSiyouKbn(ALREADYROLESYSSIYOUKBN);

            baseDomManager.insert(role);
        }
    }

    @Transactional
    public void deleteTestB0008_01(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            kinou.getKinouModes().removeAll(kinou.getKinouModes());

            baseDomManager.update(kinou);
            baseDomManager.delete(kinou);
        }
    }

    @Transactional
    public void deleteTestB0008_02(){

        AM_Role role = baseDomManager.getRole(ALREADYROLECD);
        if ( null != role ) {

            baseDomManager.delete(role);
        }
    }

    @Transactional
    public void createTestB0009_01(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null == kinou ) {

            kinou = new AS_Kinou();
            kinou.setKinouId(ALREADYKINOUID);
            kinou.setSubSystemId(ALREADYSUBSYSTEMID);
            kinou.setCategoryId(ALREADYCATEGORYID);
            kinou.setKinouNm(ALREADYKINOUNM);
            kinou.setSortNo(Integer.parseInt(ALREADYSORTNO));
            kinou.setKinouKbn(ALREADYKINOUKBN);
            kinou.setBatchKyouseiSyuuryouFlag(ALREADYBATCHKYOUSEISYUURYOUFLAG);
            kinou.setMenuHyoujiKahi(ALREADYMENUHYOUJIKBN);
            kinou.setBatchLogHyoujiKbn(ALREADYBATCHLOGHYOUJIKBN);
            kinou.setKidouKengenHanteiYouhiKbn(ALREADYKINOUGENKENHANTEIYOUHIKBN);
            kinou.setKinouTeigiTaisyouKbn(ALREADYKINOUTEIGITAISYOUKBN);

            baseDomManager.insert(kinou);
        }
    }

    @Transactional
    public void createTestB0009_02(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null == kinouMode ) {

                kinouMode = kinou.createKinouMode();
                kinouMode.setKinouModeId(ALREADYKINOUMODEID);
                kinouMode.setKinouModeNm(ALREADYKINOUMODENM);
                kinouMode.setSortNo(Integer.parseInt(ALREADYKINOUMODESORTNO));
                kinouMode.setYuukouKbn(ALREADYYUUKOUKBN);
                kinouMode.setKadouTimeGroupCd(ALREADYKADOUTIMEGROUPCD);
                kinouMode.setBatchHeisouKahiKbn(ALREADYBATCHHEISOUKAHIKBN);

                baseDomManager.update(kinou);
            }
        }
    }

    @Transactional
    public void deleteTestB0009_01(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            kinou.getKinouModes().removeAll(kinou.getKinouModes());

            baseDomManager.update(kinou);
            baseDomManager.delete(kinou);
        }
    }

    @Transactional
    public void createTestB0010_01(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null == kinou ) {

            kinou = new AS_Kinou();
            kinou.setKinouId(ALREADYKINOUID);
            kinou.setSubSystemId(ALREADYSUBSYSTEMID);
            kinou.setCategoryId(ALREADYCATEGORYID);
            kinou.setKinouNm(ALREADYKINOUNM);
            kinou.setSortNo(Integer.parseInt(ALREADYSORTNO));
            kinou.setKinouKbn(ALREADYKINOUKBN);
            kinou.setBatchKyouseiSyuuryouFlag(ALREADYBATCHKYOUSEISYUURYOUFLAG);
            kinou.setMenuHyoujiKahi(ALREADYMENUHYOUJIKBN);
            kinou.setBatchLogHyoujiKbn(ALREADYBATCHLOGHYOUJIKBN);
            kinou.setKidouKengenHanteiYouhiKbn(ALREADYKINOUGENKENHANTEIYOUHIKBN);
            kinou.setKinouTeigiTaisyouKbn(ALREADYKINOUTEIGITAISYOUKBN);

            baseDomManager.insert(kinou);
        }
    }

    @Transactional
    public void createTestB0010_02(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null == kinouMode ) {

                kinouMode = kinou.createKinouMode();
                kinouMode.setKinouModeId(ALREADYKINOUMODEID);
                kinouMode.setKinouModeNm(ALREADYKINOUMODENM);
                kinouMode.setSortNo(Integer.parseInt(ALREADYKINOUMODESORTNO));
                kinouMode.setYuukouKbn(ALREADYYUUKOUKBN);
                kinouMode.setKadouTimeGroupCd(ALREADYKADOUTIMEGROUPCD);
                kinouMode.setBatchHeisouKahiKbn(ALREADYBATCHHEISOUKAHIKBN);

                baseDomManager.update(kinou);
            }
        }
    }

    @Transactional
    public void deleteTestB0010_01(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            kinou.getKinouModes().removeAll(kinou.getKinouModes());

            baseDomManager.update(kinou);
            baseDomManager.delete(kinou);
        }
    }

    @Transactional
    public void createTestB0011_01(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null == kinou ) {

            kinou = new AS_Kinou();
            kinou.setKinouId(ALREADYKINOUID);
            kinou.setSubSystemId(ALREADYSUBSYSTEMID);
            kinou.setCategoryId(ALREADYCATEGORYID);
            kinou.setKinouNm(ALREADYKINOUNM);
            kinou.setSortNo(Integer.parseInt(ALREADYSORTNO));
            kinou.setKinouKbn(ALREADYKINOUKBN);
            kinou.setBatchKyouseiSyuuryouFlag(ALREADYBATCHKYOUSEISYUURYOUFLAG);
            kinou.setMenuHyoujiKahi(ALREADYMENUHYOUJIKBN);
            kinou.setBatchLogHyoujiKbn(ALREADYBATCHLOGHYOUJIKBN);
            kinou.setKidouKengenHanteiYouhiKbn(ALREADYKINOUGENKENHANTEIYOUHIKBN);
            kinou.setKinouTeigiTaisyouKbn(ALREADYKINOUTEIGITAISYOUKBN);

            baseDomManager.insert(kinou);
        }
    }

    @Transactional
    public void createTestB0011_02(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null == kinouMode ) {

                kinouMode = kinou.createKinouMode();
                kinouMode.setKinouModeId(ALREADYKINOUMODEID);
                kinouMode.setKinouModeNm(ALREADYKINOUMODENM);
                kinouMode.setSortNo(Integer.parseInt(ALREADYKINOUMODESORTNO));
                kinouMode.setYuukouKbn(ALREADYYUUKOUKBN);
                kinouMode.setKadouTimeGroupCd(ALREADYKADOUTIMEGROUPCD);
                kinouMode.setBatchHeisouKahiKbn(ALREADYBATCHHEISOUKAHIKBN);

                baseDomManager.update(kinou);
            }
        }
    }

    @Transactional
    public void deleteTestB0011_01(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            kinou.getKinouModes().removeAll(kinou.getKinouModes());

            baseDomManager.update(kinou);
            baseDomManager.delete(kinou);
        }
    }

    @Transactional
    public void createTestB0012_01(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null == kinou ) {

            kinou = new AS_Kinou();
            kinou.setKinouId(ALREADYKINOUID);
            kinou.setSubSystemId(ALREADYSUBSYSTEMID);
            kinou.setCategoryId(ALREADYCATEGORYID);
            kinou.setKinouNm(ALREADYKINOUNM);
            kinou.setSortNo(Integer.parseInt(ALREADYSORTNO));
            kinou.setKinouKbn(ALREADYKINOUKBN);
            kinou.setBatchKyouseiSyuuryouFlag(ALREADYBATCHKYOUSEISYUURYOUFLAG);
            kinou.setMenuHyoujiKahi(ALREADYMENUHYOUJIKBN);
            kinou.setBatchLogHyoujiKbn(ALREADYBATCHLOGHYOUJIKBN);
            kinou.setKidouKengenHanteiYouhiKbn(ALREADYKINOUGENKENHANTEIYOUHIKBN);
            kinou.setKinouTeigiTaisyouKbn(ALREADYKINOUTEIGITAISYOUKBN);

            baseDomManager.insert(kinou);
        }
    }

    @Transactional
    public void createTestB0012_02(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null == kinouMode ) {

                kinouMode = kinou.createKinouMode();
                kinouMode.setKinouModeId(ALREADYKINOUMODEID);
                kinouMode.setKinouModeNm(ALREADYKINOUMODENM);
                kinouMode.setSortNo(Integer.parseInt(ALREADYKINOUMODESORTNO));
                kinouMode.setYuukouKbn(ALREADYYUUKOUKBN);
                kinouMode.setKadouTimeGroupCd(ALREADYKADOUTIMEGROUPCD);
                kinouMode.setBatchHeisouKahiKbn(ALREADYBATCHHEISOUKAHIKBN);

                baseDomManager.update(kinou);
            }
        }
    }

    @Transactional
    public void deleteTestB0012_01(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            kinou.getKinouModes().removeAll(kinou.getKinouModes());

            baseDomManager.update(kinou);
            baseDomManager.delete(kinou);
        }
    }

    @Transactional
    public void createTestB0013_01(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null == kinou ) {

            kinou = new AS_Kinou();
            kinou.setKinouId(ALREADYKINOUID);
            kinou.setSubSystemId(ALREADYSUBSYSTEMID);
            kinou.setCategoryId(ALREADYCATEGORYID);
            kinou.setKinouNm(ALREADYKINOUNM);
            kinou.setSortNo(Integer.parseInt(ALREADYSORTNO));
            kinou.setKinouKbn(ALREADYKINOUKBN);
            kinou.setBatchKyouseiSyuuryouFlag(ALREADYBATCHKYOUSEISYUURYOUFLAG);
            kinou.setMenuHyoujiKahi(ALREADYMENUHYOUJIKBN);
            kinou.setBatchLogHyoujiKbn(ALREADYBATCHLOGHYOUJIKBN);
            kinou.setKidouKengenHanteiYouhiKbn(ALREADYKINOUGENKENHANTEIYOUHIKBN);
            kinou.setKinouTeigiTaisyouKbn(ALREADYKINOUTEIGITAISYOUKBN);

            baseDomManager.insert(kinou);
        }
    }

    @Transactional
    public void createTestB0013_02(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null == kinouMode ) {

                kinouMode = kinou.createKinouMode();
                kinouMode.setKinouModeId(ALREADYKINOUMODEID);
                kinouMode.setKinouModeNm(ALREADYKINOUMODENM);
                kinouMode.setSortNo(Integer.parseInt(ALREADYKINOUMODESORTNO));
                kinouMode.setYuukouKbn(ALREADYYUUKOUKBN);
                kinouMode.setKadouTimeGroupCd(ALREADYKADOUTIMEGROUPCD);
                kinouMode.setBatchHeisouKahiKbn(ALREADYBATCHHEISOUKAHIKBN);

                baseDomManager.update(kinou);
            }
        }
    }

    @Transactional
    public void deleteTestB0013_01(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            kinou.getKinouModes().removeAll(kinou.getKinouModes());

            baseDomManager.update(kinou);
            baseDomManager.delete(kinou);
        }
    }

    @Transactional
    public void createTestB0014_01(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null == kinou ) {

            kinou = new AS_Kinou();
            kinou.setKinouId(ALREADYKINOUID);
            kinou.setSubSystemId(ALREADYSUBSYSTEMID);
            kinou.setCategoryId(ALREADYCATEGORYID);
            kinou.setKinouNm(ALREADYKINOUNM);
            kinou.setSortNo(Integer.parseInt(ALREADYSORTNO));
            kinou.setKinouKbn(ALREADYKINOUKBN);
            kinou.setBatchKyouseiSyuuryouFlag(ALREADYBATCHKYOUSEISYUURYOUFLAG);
            kinou.setMenuHyoujiKahi(ALREADYMENUHYOUJIKBN);
            kinou.setBatchLogHyoujiKbn(ALREADYBATCHLOGHYOUJIKBN);
            kinou.setKidouKengenHanteiYouhiKbn(ALREADYKINOUGENKENHANTEIYOUHIKBN);
            kinou.setKinouTeigiTaisyouKbn(ALREADYKINOUTEIGITAISYOUKBN);

            baseDomManager.insert(kinou);
        }
    }

    @Transactional
    public void createTestB0014_02(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null == kinouMode ) {

                kinouMode = kinou.createKinouMode();
                kinouMode.setKinouModeId(ALREADYKINOUMODEID);
                kinouMode.setKinouModeNm(ALREADYKINOUMODENM);
                kinouMode.setSortNo(Integer.parseInt(ALREADYKINOUMODESORTNO));
                kinouMode.setYuukouKbn(ALREADYYUUKOUKBN);
                kinouMode.setKadouTimeGroupCd(ALREADYKADOUTIMEGROUPCD);
                kinouMode.setBatchHeisouKahiKbn(ALREADYBATCHHEISOUKAHIKBN);

                baseDomManager.update(kinou);
            }
        }
    }

    @Transactional
    public void deleteTestB0014_01(){

        baseDomManager.clear();
        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            kinou.getKinouModes().removeAll(kinou.getKinouModes());

            baseDomManager.update(kinou);
            baseDomManager.delete(kinou);
        }
    }

    @Transactional
    public void createTestB0015_01(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null == kinou ) {

            kinou = new AS_Kinou();
            kinou.setKinouId(ALREADYKINOUID);
            kinou.setSubSystemId(ALREADYSUBSYSTEMID);
            kinou.setCategoryId(ALREADYCATEGORYID);
            kinou.setKinouNm(ALREADYKINOUNM);
            kinou.setSortNo(Integer.parseInt(ALREADYSORTNO));
            kinou.setKinouKbn(ALREADYKINOUKBN);
            kinou.setBatchKyouseiSyuuryouFlag(ALREADYBATCHKYOUSEISYUURYOUFLAG);
            kinou.setMenuHyoujiKahi(ALREADYMENUHYOUJIKBN);
            kinou.setBatchLogHyoujiKbn(ALREADYBATCHLOGHYOUJIKBN);
            kinou.setKidouKengenHanteiYouhiKbn(ALREADYKINOUGENKENHANTEIYOUHIKBN);
            kinou.setKinouTeigiTaisyouKbn(ALREADYKINOUTEIGITAISYOUKBN);

            baseDomManager.insert(kinou);
        }
    }

    @Transactional
    public void createTestB0015_02(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null == kinouMode ) {

                kinouMode = kinou.createKinouMode();
                kinouMode.setKinouModeId(ALREADYKINOUMODEID);
                kinouMode.setKinouModeNm(ALREADYKINOUMODENM);
                kinouMode.setSortNo(Integer.parseInt(ALREADYKINOUMODESORTNO));
                kinouMode.setYuukouKbn(ALREADYYUUKOUKBN);
                kinouMode.setKadouTimeGroupCd(ALREADYKADOUTIMEGROUPCD);
                kinouMode.setBatchHeisouKahiKbn(ALREADYBATCHHEISOUKAHIKBN);

                baseDomManager.update(kinou);
            }
        }
    }

    @Transactional
    public void createTestB0015_03(){

        AM_Role role = baseDomManager.getRole(ALREADYROLECD);
        if ( null == role ) {

            role = new AM_Role();
            role.setRoleCd(ALREADYROLECD);
            role.setRoleNm(ALREADYROLENM);
            role.setRoleSetumei(ALREADYROLESETUMEI);
            role.setSysSiyouKbn(ALREADYROLESYSSIYOUKBN);

            baseDomManager.insert(role);
        }
    }

    @Transactional
    public void deleteTestB0015_01(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            kinou.getKinouModes().removeAll(kinou.getKinouModes());

            baseDomManager.update(kinou);
            baseDomManager.delete(kinou);
        }
    }

    @Transactional
    public void deleteTestB0015_02(){

        AM_Role role = baseDomManager.getRole(ALREADYROLECD);
        if ( null != role ) {

            baseDomManager.delete(role);
        }
    }

    @Transactional
    public void createTestB0016_01(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null == kinou ) {

            kinou = new AS_Kinou();
            kinou.setKinouId(ALREADYKINOUID);
            kinou.setSubSystemId(ALREADYSUBSYSTEMID);
            kinou.setCategoryId(ALREADYCATEGORYID);
            kinou.setKinouNm(ALREADYKINOUNM);
            kinou.setSortNo(Integer.parseInt(ALREADYSORTNO));
            kinou.setKinouKbn(ALREADYKINOUKBN);
            kinou.setBatchKyouseiSyuuryouFlag(ALREADYBATCHKYOUSEISYUURYOUFLAG);
            kinou.setMenuHyoujiKahi(ALREADYMENUHYOUJIKBN);
            kinou.setBatchLogHyoujiKbn(ALREADYBATCHLOGHYOUJIKBN);
            kinou.setKidouKengenHanteiYouhiKbn(ALREADYKINOUGENKENHANTEIYOUHIKBN);
            kinou.setKinouTeigiTaisyouKbn(ALREADYKINOUTEIGITAISYOUKBN);

            baseDomManager.insert(kinou);
        }
    }

    @Transactional
    public void createTestB0016_02(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null == kinouMode ) {

                kinouMode = kinou.createKinouMode();
                kinouMode.setKinouModeId(ALREADYKINOUMODEID);
                kinouMode.setKinouModeNm(ALREADYKINOUMODENM);
                kinouMode.setSortNo(Integer.parseInt(ALREADYKINOUMODESORTNO));
                kinouMode.setYuukouKbn(ALREADYYUUKOUKBN);
                kinouMode.setKadouTimeGroupCd(ALREADYKADOUTIMEGROUPCD);
                kinouMode.setBatchHeisouKahiKbn(ALREADYBATCHHEISOUKAHIKBN);

                baseDomManager.update(kinou);
            }
        }
    }

    @Transactional
    public void deleteTestB0016_01(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            kinou.getKinouModes().removeAll(kinou.getKinouModes());

            baseDomManager.update(kinou);
            baseDomManager.delete(kinou);
        }
    }

    @Transactional
    public void createTestB0017_01(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null == kinou ) {

            kinou = new AS_Kinou();
            kinou.setKinouId(ALREADYKINOUID);
            kinou.setSubSystemId(ALREADYSUBSYSTEMID);
            kinou.setCategoryId(ALREADYCATEGORYID);
            kinou.setKinouNm(ALREADYKINOUNM);
            kinou.setSortNo(Integer.parseInt(ALREADYSORTNO));
            kinou.setKinouKbn(ALREADYKINOUKBN);
            kinou.setBatchKyouseiSyuuryouFlag(ALREADYBATCHKYOUSEISYUURYOUFLAG);
            kinou.setMenuHyoujiKahi(ALREADYMENUHYOUJIKBN);
            kinou.setBatchLogHyoujiKbn(ALREADYBATCHLOGHYOUJIKBN);
            kinou.setKidouKengenHanteiYouhiKbn(ALREADYKINOUGENKENHANTEIYOUHIKBN);
            kinou.setKinouTeigiTaisyouKbn(ALREADYKINOUTEIGITAISYOUKBN);

            baseDomManager.insert(kinou);
        }
    }

    @Transactional
    public void createTestB0017_02(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null == kinouMode ) {

                kinouMode = kinou.createKinouMode();
                kinouMode.setKinouModeId(ALREADYKINOUMODEID);
                kinouMode.setKinouModeNm(ALREADYKINOUMODENM);
                kinouMode.setSortNo(Integer.parseInt(ALREADYKINOUMODESORTNO));
                kinouMode.setYuukouKbn(ALREADYYUUKOUKBN);
                kinouMode.setKadouTimeGroupCd(ALREADYKADOUTIMEGROUPCD);
                kinouMode.setBatchHeisouKahiKbn(ALREADYBATCHHEISOUKAHIKBN);

                baseDomManager.update(kinou);
            }
        }
    }

    @Transactional
    public void deleteTestB0017_01(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            kinou.getKinouModes().removeAll(kinou.getKinouModes());

            baseDomManager.update(kinou);
            baseDomManager.delete(kinou);
        }
    }

    @Transactional
    public void createTestB0018_01(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null == kinou ) {

            kinou = new AS_Kinou();
            kinou.setKinouId(ALREADYKINOUID);
            kinou.setSubSystemId(ALREADYSUBSYSTEMID);
            kinou.setCategoryId(ALREADYCATEGORYID);
            kinou.setKinouNm(ALREADYKINOUNM);
            kinou.setSortNo(Integer.parseInt(ALREADYSORTNO));
            kinou.setKinouKbn(ALREADYKINOUKBN);
            kinou.setBatchKyouseiSyuuryouFlag(ALREADYBATCHKYOUSEISYUURYOUFLAG);
            kinou.setMenuHyoujiKahi(ALREADYMENUHYOUJIKBN);
            kinou.setBatchLogHyoujiKbn(ALREADYBATCHLOGHYOUJIKBN);
            kinou.setKidouKengenHanteiYouhiKbn(ALREADYKINOUGENKENHANTEIYOUHIKBN);
            kinou.setKinouTeigiTaisyouKbn(ALREADYKINOUTEIGITAISYOUKBN);

            baseDomManager.insert(kinou);
        }
    }

    @Transactional
    public void createTestB0018_02(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null == kinouMode ) {

                kinouMode = kinou.createKinouMode();
                kinouMode.setKinouModeId(ALREADYKINOUMODEID);
                kinouMode.setKinouModeNm(ALREADYKINOUMODENM);
                kinouMode.setSortNo(Integer.parseInt(ALREADYKINOUMODESORTNO));
                kinouMode.setYuukouKbn(ALREADYYUUKOUKBN);
                kinouMode.setKadouTimeGroupCd(ALREADYKADOUTIMEGROUPCD);
                kinouMode.setBatchHeisouKahiKbn(ALREADYBATCHHEISOUKAHIKBN);

                baseDomManager.update(kinou);
            }
        }
    }

    @Transactional
    public void deleteTestB0018_01(){

        baseDomManager.clear();
        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            kinou.getKinouModes().removeAll(kinou.getKinouModes());

            baseDomManager.update(kinou);
            baseDomManager.delete(kinou);
        }
    }

    @Transactional
    public void createTestB0019_01(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null == kinou ) {

            kinou = new AS_Kinou();
            kinou.setKinouId(ALREADYKINOUID);
            kinou.setSubSystemId(ALREADYSUBSYSTEMID);
            kinou.setCategoryId(ALREADYCATEGORYID);
            kinou.setKinouNm(ALREADYKINOUNM);
            kinou.setSortNo(Integer.parseInt(ALREADYSORTNO));
            kinou.setKinouKbn(ALREADYKINOUKBN);
            kinou.setBatchKyouseiSyuuryouFlag(ALREADYBATCHKYOUSEISYUURYOUFLAG);
            kinou.setMenuHyoujiKahi(ALREADYMENUHYOUJIKBN);
            kinou.setBatchLogHyoujiKbn(ALREADYBATCHLOGHYOUJIKBN);
            kinou.setKidouKengenHanteiYouhiKbn(ALREADYKINOUGENKENHANTEIYOUHIKBN);
            kinou.setKinouTeigiTaisyouKbn(ALREADYKINOUTEIGITAISYOUKBN);

            baseDomManager.insert(kinou);
        }
    }

    @Transactional
    public void createTestB0019_02(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null == kinouMode ) {

                kinouMode = kinou.createKinouMode();
                kinouMode.setKinouModeId(ALREADYKINOUMODEID);
                kinouMode.setKinouModeNm(ALREADYKINOUMODENM);
                kinouMode.setSortNo(Integer.parseInt(ALREADYKINOUMODESORTNO));
                kinouMode.setYuukouKbn(ALREADYYUUKOUKBN);
                kinouMode.setKadouTimeGroupCd(ALREADYKADOUTIMEGROUPCD);
                kinouMode.setBatchHeisouKahiKbn(ALREADYBATCHHEISOUKAHIKBN);

                baseDomManager.update(kinou);
            }
        }
    }

    @Transactional
    public void deleteTestB0019_01(){

        baseDomManager.clear();
        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            kinou.getKinouModes().removeAll(kinou.getKinouModes());

            baseDomManager.update(kinou);
            baseDomManager.delete(kinou);
        }
    }

    @Transactional
    public void createTestB0020_01(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null == kinou ) {

            kinou = new AS_Kinou();
            kinou.setKinouId(ALREADYKINOUID);
            kinou.setSubSystemId(ALREADYSUBSYSTEMID);
            kinou.setCategoryId(ALREADYCATEGORYID);
            kinou.setKinouNm(ALREADYKINOUNM);
            kinou.setSortNo(Integer.parseInt(ALREADYSORTNO));
            kinou.setKinouKbn(ALREADYKINOUKBN);
            kinou.setBatchKyouseiSyuuryouFlag(ALREADYBATCHKYOUSEISYUURYOUFLAG);
            kinou.setMenuHyoujiKahi(ALREADYMENUHYOUJIKBN);
            kinou.setBatchLogHyoujiKbn(ALREADYBATCHLOGHYOUJIKBN);
            kinou.setKidouKengenHanteiYouhiKbn(ALREADYKINOUGENKENHANTEIYOUHIKBN);
            kinou.setKinouTeigiTaisyouKbn(ALREADYKINOUTEIGITAISYOUKBN);

            baseDomManager.insert(kinou);
        }
    }

    @Transactional
    public void createTestB0020_02(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null == kinouMode ) {

                kinouMode = kinou.createKinouMode();
                kinouMode.setKinouModeId(ALREADYKINOUMODEID);
                kinouMode.setKinouModeNm(ALREADYKINOUMODENM);
                kinouMode.setSortNo(Integer.parseInt(ALREADYKINOUMODESORTNO));
                kinouMode.setYuukouKbn(ALREADYYUUKOUKBN);
                kinouMode.setKadouTimeGroupCd(ALREADYKADOUTIMEGROUPCD);
                kinouMode.setBatchHeisouKahiKbn(ALREADYBATCHHEISOUKAHIKBN);

                baseDomManager.update(kinou);
            }
        }
    }

    @Transactional
    public void deleteTestB0020_01(){

        baseDomManager.clear();
        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            kinou.getKinouModes().removeAll(kinou.getKinouModes());

            baseDomManager.update(kinou);
            baseDomManager.delete(kinou);
        }
    }

    @Transactional
    public void createTestL0001_01(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null == kinou ) {

            kinou = new AS_Kinou();
            kinou.setKinouId(ALREADYKINOUID);
            kinou.setSubSystemId(ALREADYSUBSYSTEMID);
            kinou.setCategoryId(ALREADYCATEGORYID);
            kinou.setKinouNm(ALREADYKINOUNM);
            kinou.setSortNo(Integer.parseInt(ALREADYSORTNO));
            kinou.setKinouKbn(ALREADYKINOUKBN);
            kinou.setBatchKyouseiSyuuryouFlag(ALREADYBATCHKYOUSEISYUURYOUFLAG);
            kinou.setMenuHyoujiKahi(ALREADYMENUHYOUJIKBN);
            kinou.setBatchLogHyoujiKbn(ALREADYBATCHLOGHYOUJIKBN);
            kinou.setKidouKengenHanteiYouhiKbn(ALREADYKINOUGENKENHANTEIYOUHIKBN);
            kinou.setKinouTeigiTaisyouKbn(ALREADYKINOUTEIGITAISYOUKBN);

            baseDomManager.insert(kinou);
        }
    }

    @Transactional
    public void createTestL0001_02(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null == kinouMode ) {

                kinouMode = kinou.createKinouMode();
                kinouMode.setKinouModeId(ALREADYKINOUMODEID);
                kinouMode.setKinouModeNm(ALREADYKINOUMODENM);
                kinouMode.setSortNo(Integer.parseInt(ALREADYKINOUMODESORTNO));
                kinouMode.setYuukouKbn(ALREADYYUUKOUKBN);
                kinouMode.setKadouTimeGroupCd(ALREADYKADOUTIMEGROUPCD);
                kinouMode.setBatchHeisouKahiKbn(ALREADYBATCHHEISOUKAHIKBN);

                baseDomManager.update(kinou);
            }
        }
    }

    @Transactional
    public void createTestL0001_03(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null != kinouMode ) {

                AS_KinouModeSiborikomi kinouModeSiborikomi1 = kinouMode.getKinouModoSiborikomi(ALREADYKINOUMODESIBORIKOMIID1);
                if ( null == kinouModeSiborikomi1 ) {

                    kinouModeSiborikomi1 = kinouMode.createKinouModeSiborikomi();
                    kinouModeSiborikomi1.setSiborikomiId(ALREADYKINOUMODESIBORIKOMIID1);
                    kinouModeSiborikomi1.setSiborikomiNm(ALREADYKINOUMODESIBORIKOMINM1);

                    baseDomManager.update(kinou);
                }

                AS_KinouModeSiborikomi kinouModeSiborikomi2 = kinouMode.getKinouModoSiborikomi(ALREADYKINOUMODESIBORIKOMIID2);
                if ( null == kinouModeSiborikomi2 ) {

                    kinouModeSiborikomi2 = kinouMode.createKinouModeSiborikomi();
                    kinouModeSiborikomi2.setSiborikomiId(ALREADYKINOUMODESIBORIKOMIID2);
                    kinouModeSiborikomi2.setSiborikomiNm(ALREADYKINOUMODESIBORIKOMINM2);

                    baseDomManager.update(kinou);
                }
            }
        }
    }

    @Transactional
    public void deleteTestL0001_01(){

        baseDomManager.clear();
        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null != kinouMode ) {

                kinouMode.getKinouModeSiborikomis().removeAll(kinouMode.getKinouModeSiborikomis());
            }

            kinou.getKinouModes().removeAll(kinou.getKinouModes());

            baseDomManager.update(kinou);
            baseDomManager.delete(kinou);
        }
    }

    @Transactional
    public void createTestL0002_01(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null == kinou ) {

            kinou = new AS_Kinou();
            kinou.setKinouId(ALREADYKINOUID);
            kinou.setSubSystemId(ALREADYSUBSYSTEMID);
            kinou.setCategoryId(ALREADYCATEGORYID);
            kinou.setKinouNm(ALREADYKINOUNM);
            kinou.setSortNo(Integer.parseInt(ALREADYSORTNO));
            kinou.setKinouKbn(ALREADYKINOUKBN);
            kinou.setBatchKyouseiSyuuryouFlag(ALREADYBATCHKYOUSEISYUURYOUFLAG);
            kinou.setMenuHyoujiKahi(ALREADYMENUHYOUJIKBN);
            kinou.setBatchLogHyoujiKbn(ALREADYBATCHLOGHYOUJIKBN);
            kinou.setKidouKengenHanteiYouhiKbn(ALREADYKINOUGENKENHANTEIYOUHIKBN);
            kinou.setKinouTeigiTaisyouKbn(ALREADYKINOUTEIGITAISYOUKBN);

            baseDomManager.insert(kinou);
        }
    }

    @Transactional
    public void createTestL0002_02(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null == kinouMode ) {

                kinouMode = kinou.createKinouMode();
                kinouMode.setKinouModeId(ALREADYKINOUMODEID);
                kinouMode.setKinouModeNm(ALREADYKINOUMODENM);
                kinouMode.setSortNo(Integer.parseInt(ALREADYKINOUMODESORTNO));
                kinouMode.setYuukouKbn(ALREADYYUUKOUKBN);
                kinouMode.setKadouTimeGroupCd(ALREADYKADOUTIMEGROUPCD);
                kinouMode.setBatchHeisouKahiKbn(ALREADYBATCHHEISOUKAHIKBN);

                baseDomManager.update(kinou);
            }
        }
    }

    @Transactional
    public void createTestL0002_03(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null != kinouMode ) {

                AS_KinouModeSiborikomi kinouModeSiborikomi1 = kinouMode.getKinouModoSiborikomi(ALREADYKINOUMODESIBORIKOMIID1);
                if ( null == kinouModeSiborikomi1 ) {

                    kinouModeSiborikomi1 = kinouMode.createKinouModeSiborikomi();
                    kinouModeSiborikomi1.setSiborikomiId(ALREADYKINOUMODESIBORIKOMIID1);
                    kinouModeSiborikomi1.setSiborikomiNm(ALREADYKINOUMODESIBORIKOMINM1);

                    baseDomManager.update(kinou);
                }

                AS_KinouModeSiborikomi kinouModeSiborikomi2 = kinouMode.getKinouModoSiborikomi(ALREADYKINOUMODESIBORIKOMIID2);
                if ( null == kinouModeSiborikomi2 ) {

                    kinouModeSiborikomi2 = kinouMode.createKinouModeSiborikomi();
                    kinouModeSiborikomi2.setSiborikomiId(ALREADYKINOUMODESIBORIKOMIID2);
                    kinouModeSiborikomi2.setSiborikomiNm(ALREADYKINOUMODESIBORIKOMINM2);

                    baseDomManager.update(kinou);
                }
            }
        }
    }

    @Transactional
    public void deleteTestL0002_01(){

        baseDomManager.clear();
        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null != kinouMode ) {

                kinouMode.getKinouModeSiborikomis().removeAll(kinouMode.getKinouModeSiborikomis());
            }

            kinou.getKinouModes().removeAll(kinou.getKinouModes());

            baseDomManager.update(kinou);
            baseDomManager.delete(kinou);
        }
    }

    @Transactional
    public void createTestL0003_01(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null == kinou ) {

            kinou = new AS_Kinou();
            kinou.setKinouId(ALREADYKINOUID);
            kinou.setSubSystemId(ALREADYSUBSYSTEMID);
            kinou.setCategoryId(ALREADYCATEGORYID);
            kinou.setKinouNm(ALREADYKINOUNM);
            kinou.setSortNo(Integer.parseInt(ALREADYSORTNO));
            kinou.setKinouKbn(ALREADYKINOUKBN);
            kinou.setBatchKyouseiSyuuryouFlag(ALREADYBATCHKYOUSEISYUURYOUFLAG);
            kinou.setMenuHyoujiKahi(ALREADYMENUHYOUJIKBN);
            kinou.setBatchLogHyoujiKbn(ALREADYBATCHLOGHYOUJIKBN);
            kinou.setKidouKengenHanteiYouhiKbn(ALREADYKINOUGENKENHANTEIYOUHIKBN);
            kinou.setKinouTeigiTaisyouKbn(ALREADYKINOUTEIGITAISYOUKBN);

            baseDomManager.insert(kinou);
        }
    }

    @Transactional
    public void createTestL0003_02(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null == kinouMode ) {

                kinouMode = kinou.createKinouMode();
                kinouMode.setKinouModeId(ALREADYKINOUMODEID);
                kinouMode.setKinouModeNm(ALREADYKINOUMODENM);
                kinouMode.setSortNo(Integer.parseInt(ALREADYKINOUMODESORTNO));
                kinouMode.setYuukouKbn(ALREADYYUUKOUKBN);
                kinouMode.setKadouTimeGroupCd(ALREADYKADOUTIMEGROUPCD);
                kinouMode.setBatchHeisouKahiKbn(ALREADYBATCHHEISOUKAHIKBN);

                baseDomManager.update(kinou);
            }
        }
    }

    @Transactional
    public void createTestL0003_03(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null != kinouMode ) {

                AS_KinouModeSiborikomi kinouModeSiborikomi1 = kinouMode.getKinouModoSiborikomi(ALREADYKINOUMODESIBORIKOMIID1);
                if ( null == kinouModeSiborikomi1 ) {

                    kinouModeSiborikomi1 = kinouMode.createKinouModeSiborikomi();
                    kinouModeSiborikomi1.setSiborikomiId(ALREADYKINOUMODESIBORIKOMIID1);
                    kinouModeSiborikomi1.setSiborikomiNm(ALREADYKINOUMODESIBORIKOMINM1);

                    baseDomManager.update(kinou);
                }

                AS_KinouModeSiborikomi kinouModeSiborikomi2 = kinouMode.getKinouModoSiborikomi(ALREADYKINOUMODESIBORIKOMIID2);
                if ( null == kinouModeSiborikomi2 ) {

                    kinouModeSiborikomi2 = kinouMode.createKinouModeSiborikomi();
                    kinouModeSiborikomi2.setSiborikomiId(ALREADYKINOUMODESIBORIKOMIID2);
                    kinouModeSiborikomi2.setSiborikomiNm(ALREADYKINOUMODESIBORIKOMINM2);

                    baseDomManager.update(kinou);
                }
            }
        }
    }

    @Transactional
    public void deleteTestL0003_01(){

        baseDomManager.clear();
        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null != kinouMode ) {

                kinouMode.getKinouModeSiborikomis().removeAll(kinouMode.getKinouModeSiborikomis());
            }

            kinou.getKinouModes().removeAll(kinou.getKinouModes());

            baseDomManager.update(kinou);
            baseDomManager.delete(kinou);
        }
    }

    @Transactional
    public void createTestL0004_01(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null == kinou ) {

            kinou = new AS_Kinou();
            kinou.setKinouId(ALREADYKINOUID);
            kinou.setSubSystemId(ALREADYSUBSYSTEMID);
            kinou.setCategoryId(ALREADYCATEGORYID);
            kinou.setKinouNm(ALREADYKINOUNM);
            kinou.setSortNo(Integer.parseInt(ALREADYSORTNO));
            kinou.setKinouKbn(ALREADYKINOUKBN);
            kinou.setBatchKyouseiSyuuryouFlag(ALREADYBATCHKYOUSEISYUURYOUFLAG);
            kinou.setMenuHyoujiKahi(ALREADYMENUHYOUJIKBN);
            kinou.setBatchLogHyoujiKbn(ALREADYBATCHLOGHYOUJIKBN);
            kinou.setKidouKengenHanteiYouhiKbn(ALREADYKINOUGENKENHANTEIYOUHIKBN);
            kinou.setKinouTeigiTaisyouKbn(ALREADYKINOUTEIGITAISYOUKBN);

            baseDomManager.insert(kinou);
        }
    }

    @Transactional
    public void createTestL0004_02(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null == kinouMode ) {

                kinouMode = kinou.createKinouMode();
                kinouMode.setKinouModeId(ALREADYKINOUMODEID);
                kinouMode.setKinouModeNm(ALREADYKINOUMODENM);
                kinouMode.setSortNo(Integer.parseInt(ALREADYKINOUMODESORTNO));
                kinouMode.setYuukouKbn(ALREADYYUUKOUKBN);
                kinouMode.setKadouTimeGroupCd(ALREADYKADOUTIMEGROUPCD);
                kinouMode.setBatchHeisouKahiKbn(ALREADYBATCHHEISOUKAHIKBN);

                baseDomManager.update(kinou);
            }
        }
    }

    @Transactional
    public void createTestL0004_03(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null != kinouMode ) {

                AS_KinouModeSiborikomi kinouModeSiborikomi1 = kinouMode.getKinouModoSiborikomi(ALREADYKINOUMODESIBORIKOMIID1);
                if ( null == kinouModeSiborikomi1 ) {

                    kinouModeSiborikomi1 = kinouMode.createKinouModeSiborikomi();
                    kinouModeSiborikomi1.setSiborikomiId(ALREADYKINOUMODESIBORIKOMIID1);
                    kinouModeSiborikomi1.setSiborikomiNm(ALREADYKINOUMODESIBORIKOMINM1);

                    baseDomManager.update(kinou);
                }

                AS_KinouModeSiborikomi kinouModeSiborikomi2 = kinouMode.getKinouModoSiborikomi(ALREADYKINOUMODESIBORIKOMIID2);
                if ( null == kinouModeSiborikomi2 ) {

                    kinouModeSiborikomi2 = kinouMode.createKinouModeSiborikomi();
                    kinouModeSiborikomi2.setSiborikomiId(ALREADYKINOUMODESIBORIKOMIID2);
                    kinouModeSiborikomi2.setSiborikomiNm(ALREADYKINOUMODESIBORIKOMINM2);

                    baseDomManager.update(kinou);
                }
            }
        }
    }

    @Transactional
    public void deleteTestL0004_01(){

        baseDomManager.clear();
        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null != kinouMode ) {

                kinouMode.getKinouModeSiborikomis().removeAll(kinouMode.getKinouModeSiborikomis());
            }

            kinou.getKinouModes().removeAll(kinou.getKinouModes());

            baseDomManager.update(kinou);
            baseDomManager.delete(kinou);
        }
    }

    @Transactional
    public void createTestL0005_01(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null == kinou ) {

            kinou = new AS_Kinou();
            kinou.setKinouId(ALREADYKINOUID);
            kinou.setSubSystemId(ALREADYSUBSYSTEMID);
            kinou.setCategoryId(ALREADYCATEGORYID);
            kinou.setKinouNm(ALREADYKINOUNM);
            kinou.setSortNo(Integer.parseInt(ALREADYSORTNO));
            kinou.setKinouKbn(ALREADYKINOUKBN);
            kinou.setBatchKyouseiSyuuryouFlag(ALREADYBATCHKYOUSEISYUURYOUFLAG);
            kinou.setMenuHyoujiKahi(ALREADYMENUHYOUJIKBN);
            kinou.setBatchLogHyoujiKbn(ALREADYBATCHLOGHYOUJIKBN);
            kinou.setKidouKengenHanteiYouhiKbn(ALREADYKINOUGENKENHANTEIYOUHIKBN);
            kinou.setKinouTeigiTaisyouKbn(ALREADYKINOUTEIGITAISYOUKBN);

            baseDomManager.insert(kinou);
        }
    }

    @Transactional
    public void createTestL0005_02(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null == kinouMode ) {

                kinouMode = kinou.createKinouMode();
                kinouMode.setKinouModeId(ALREADYKINOUMODEID);
                kinouMode.setKinouModeNm(ALREADYKINOUMODENM);
                kinouMode.setSortNo(Integer.parseInt(ALREADYKINOUMODESORTNO));
                kinouMode.setYuukouKbn(ALREADYYUUKOUKBN);
                kinouMode.setKadouTimeGroupCd(ALREADYKADOUTIMEGROUPCD);
                kinouMode.setBatchHeisouKahiKbn(ALREADYBATCHHEISOUKAHIKBN);

                baseDomManager.update(kinou);
            }
        }
    }

    @Transactional
    public void createTestL0005_03(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null != kinouMode ) {

                AS_KinouModeSiborikomi kinouModeSiborikomi1 = kinouMode.getKinouModoSiborikomi(ALREADYKINOUMODESIBORIKOMIID1);
                if ( null == kinouModeSiborikomi1 ) {

                    kinouModeSiborikomi1 = kinouMode.createKinouModeSiborikomi();
                    kinouModeSiborikomi1.setSiborikomiId(ALREADYKINOUMODESIBORIKOMIID1);
                    kinouModeSiborikomi1.setSiborikomiNm(ALREADYKINOUMODESIBORIKOMINM1);

                    baseDomManager.update(kinou);
                }

                AS_KinouModeSiborikomi kinouModeSiborikomi2 = kinouMode.getKinouModoSiborikomi(ALREADYKINOUMODESIBORIKOMIID2);
                if ( null == kinouModeSiborikomi2 ) {

                    kinouModeSiborikomi2 = kinouMode.createKinouModeSiborikomi();
                    kinouModeSiborikomi2.setSiborikomiId(ALREADYKINOUMODESIBORIKOMIID2);
                    kinouModeSiborikomi2.setSiborikomiNm(ALREADYKINOUMODESIBORIKOMINM2);

                    baseDomManager.update(kinou);
                }
            }
        }
    }

    @Transactional
    public void deleteTestL0005_01(){

        baseDomManager.clear();
        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null != kinouMode ) {

                kinouMode.getKinouModeSiborikomis().removeAll(kinouMode.getKinouModeSiborikomis());
            }

            kinou.getKinouModes().removeAll(kinou.getKinouModes());

            baseDomManager.update(kinou);
            baseDomManager.delete(kinou);
        }
    }

    @Transactional
    public void createTestL0006_01(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null == kinou ) {

            kinou = new AS_Kinou();
            kinou.setKinouId(ALREADYKINOUID);
            kinou.setSubSystemId(ALREADYSUBSYSTEMID);
            kinou.setCategoryId(ALREADYCATEGORYID);
            kinou.setKinouNm(ALREADYKINOUNM);
            kinou.setSortNo(Integer.parseInt(ALREADYSORTNO));
            kinou.setKinouKbn(ALREADYKINOUKBN);
            kinou.setBatchKyouseiSyuuryouFlag(ALREADYBATCHKYOUSEISYUURYOUFLAG);
            kinou.setMenuHyoujiKahi(ALREADYMENUHYOUJIKBN);
            kinou.setBatchLogHyoujiKbn(ALREADYBATCHLOGHYOUJIKBN);
            kinou.setKidouKengenHanteiYouhiKbn(ALREADYKINOUGENKENHANTEIYOUHIKBN);
            kinou.setKinouTeigiTaisyouKbn(ALREADYKINOUTEIGITAISYOUKBN);

            baseDomManager.insert(kinou);
        }
    }

    @Transactional
    public void createTestL0006_02(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null == kinouMode ) {

                kinouMode = kinou.createKinouMode();
                kinouMode.setKinouModeId(ALREADYKINOUMODEID);
                kinouMode.setKinouModeNm(ALREADYKINOUMODENM);
                kinouMode.setSortNo(Integer.parseInt(ALREADYKINOUMODESORTNO));
                kinouMode.setYuukouKbn(ALREADYYUUKOUKBN);
                kinouMode.setKadouTimeGroupCd(ALREADYKADOUTIMEGROUPCD);
                kinouMode.setBatchHeisouKahiKbn(ALREADYBATCHHEISOUKAHIKBN);

                baseDomManager.update(kinou);
            }
        }
    }

    @Transactional
    public void createTestL0006_03(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null != kinouMode ) {

                AS_KinouModeSiborikomi kinouModeSiborikomi1 = kinouMode.getKinouModoSiborikomi(ALREADYKINOUMODESIBORIKOMIID1);
                if ( null == kinouModeSiborikomi1 ) {

                    kinouModeSiborikomi1 = kinouMode.createKinouModeSiborikomi();
                    kinouModeSiborikomi1.setSiborikomiId(ALREADYKINOUMODESIBORIKOMIID1);
                    kinouModeSiborikomi1.setSiborikomiNm(ALREADYKINOUMODESIBORIKOMINM1);

                    baseDomManager.update(kinou);
                }

                AS_KinouModeSiborikomi kinouModeSiborikomi2 = kinouMode.getKinouModoSiborikomi(ALREADYKINOUMODESIBORIKOMIID2);
                if ( null == kinouModeSiborikomi2 ) {

                    kinouModeSiborikomi2 = kinouMode.createKinouModeSiborikomi();
                    kinouModeSiborikomi2.setSiborikomiId(ALREADYKINOUMODESIBORIKOMIID2);
                    kinouModeSiborikomi2.setSiborikomiNm(ALREADYKINOUMODESIBORIKOMINM2);

                    baseDomManager.update(kinou);
                }
            }
        }
    }

    @Transactional
    public void createTestL0006_04(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null != kinouMode ) {

                AS_KinouModeSiborikomi kinouModeSiborikomi = kinouMode.getKinouModoSiborikomi(ALREADYKINOUMODESIBORIKOMIID1);
                if ( null != kinouModeSiborikomi ) {

                    AT_KinouKengen kinouKengen = kinouMode.getKinouKengen(ALREADYKINOUKENGENROLECD);
                    if ( null == kinouKengen ) {

                        kinouKengen = kinouMode.createKinouKengen();
                        kinouKengen.setRoleCd(ALREADYKINOUKENGENROLECD);
                        kinouKengen.setSiborikomiId(ALREADYKINOUMODESIBORIKOMIID1);

                        baseDomManager.update(kinou);
                    }
                }
            }
        }
    }

    @Transactional
    public void deleteTestL0006_01(){

        baseDomManager.clear();
        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null != kinouMode ) {

                kinouMode.getKinouModeSiborikomis().removeAll(kinouMode.getKinouModeSiborikomis());
                kinouMode.getKinouKengens().removeAll(kinouMode.getKinouKengens());
            }

            kinou.getKinouModes().removeAll(kinou.getKinouModes());

            baseDomManager.update(kinou);
            baseDomManager.delete(kinou);
        }
    }

    @Transactional
    public void createTestL0007_01(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null == kinou ) {

            kinou = new AS_Kinou();
            kinou.setKinouId(ALREADYKINOUID);
            kinou.setSubSystemId(ALREADYSUBSYSTEMID);
            kinou.setCategoryId(ALREADYCATEGORYID);
            kinou.setKinouNm(ALREADYKINOUNM);
            kinou.setSortNo(Integer.parseInt(ALREADYSORTNO));
            kinou.setKinouKbn(ALREADYKINOUKBN);
            kinou.setBatchKyouseiSyuuryouFlag(ALREADYBATCHKYOUSEISYUURYOUFLAG);
            kinou.setMenuHyoujiKahi(ALREADYMENUHYOUJIKBN);
            kinou.setBatchLogHyoujiKbn(ALREADYBATCHLOGHYOUJIKBN);
            kinou.setKidouKengenHanteiYouhiKbn(ALREADYKINOUGENKENHANTEIYOUHIKBN);
            kinou.setKinouTeigiTaisyouKbn(ALREADYKINOUTEIGITAISYOUKBN);

            baseDomManager.insert(kinou);
        }
    }

    @Transactional
    public void createTestL0007_02(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null == kinouMode ) {

                kinouMode = kinou.createKinouMode();
                kinouMode.setKinouModeId(ALREADYKINOUMODEID);
                kinouMode.setKinouModeNm(ALREADYKINOUMODENM);
                kinouMode.setSortNo(Integer.parseInt(ALREADYKINOUMODESORTNO));
                kinouMode.setYuukouKbn(ALREADYYUUKOUKBN);
                kinouMode.setKadouTimeGroupCd(ALREADYKADOUTIMEGROUPCD);
                kinouMode.setBatchHeisouKahiKbn(ALREADYBATCHHEISOUKAHIKBN);

                baseDomManager.update(kinou);
            }
        }
    }

    @Transactional
    public void createTestL0007_03(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null != kinouMode ) {

                AS_KinouModeSiborikomi kinouModeSiborikomi1 = kinouMode.getKinouModoSiborikomi(ALREADYKINOUMODESIBORIKOMIID1);
                if ( null == kinouModeSiborikomi1 ) {

                    kinouModeSiborikomi1 = kinouMode.createKinouModeSiborikomi();
                    kinouModeSiborikomi1.setSiborikomiId(ALREADYKINOUMODESIBORIKOMIID1);
                    kinouModeSiborikomi1.setSiborikomiNm(ALREADYKINOUMODESIBORIKOMINM1);

                    baseDomManager.update(kinou);
                }

                AS_KinouModeSiborikomi kinouModeSiborikomi2 = kinouMode.getKinouModoSiborikomi(ALREADYKINOUMODESIBORIKOMIID2);
                if ( null == kinouModeSiborikomi2 ) {

                    kinouModeSiborikomi2 = kinouMode.createKinouModeSiborikomi();
                    kinouModeSiborikomi2.setSiborikomiId(ALREADYKINOUMODESIBORIKOMIID2);
                    kinouModeSiborikomi2.setSiborikomiNm(ALREADYKINOUMODESIBORIKOMINM2);

                    baseDomManager.update(kinou);
                }
            }
        }
    }

    @Transactional
    public void createTestL0007_04(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null != kinouMode ) {

                AS_KinouModeSiborikomi kinouModeSiborikomi = kinouMode.getKinouModoSiborikomi(ALREADYKINOUMODESIBORIKOMIID1);
                if ( null != kinouModeSiborikomi ) {

                    AT_KinouKengen kinouKengen = kinouMode.getKinouKengen(ALREADYKINOUKENGENROLECD);
                    if ( null == kinouKengen ) {

                        kinouKengen = kinouMode.createKinouKengen();
                        kinouKengen.setRoleCd(ALREADYKINOUKENGENROLECD);
                        kinouKengen.setSiborikomiId(ALREADYKINOUMODESIBORIKOMIID1);

                        baseDomManager.update(kinou);
                    }
                }
            }
        }
    }

    @Transactional
    public void deleteTestL0007_01(){

        baseDomManager.clear();
        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null != kinouMode ) {

                kinouMode.getKinouModeSiborikomis().removeAll(kinouMode.getKinouModeSiborikomis());
                kinouMode.getKinouKengens().removeAll(kinouMode.getKinouKengens());
            }

            kinou.getKinouModes().removeAll(kinou.getKinouModes());

            baseDomManager.update(kinou);
            baseDomManager.delete(kinou);
        }
    }

    @Transactional
    public void createTestL0008_01(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null == kinou ) {

            kinou = new AS_Kinou();
            kinou.setKinouId(ALREADYKINOUID);
            kinou.setSubSystemId(ALREADYSUBSYSTEMID);
            kinou.setCategoryId(ALREADYCATEGORYID);
            kinou.setKinouNm(ALREADYKINOUNM);
            kinou.setSortNo(Integer.parseInt(ALREADYSORTNO));
            kinou.setKinouKbn(ALREADYKINOUKBN);
            kinou.setBatchKyouseiSyuuryouFlag(ALREADYBATCHKYOUSEISYUURYOUFLAG);
            kinou.setMenuHyoujiKahi(ALREADYMENUHYOUJIKBN);
            kinou.setBatchLogHyoujiKbn(ALREADYBATCHLOGHYOUJIKBN);
            kinou.setKidouKengenHanteiYouhiKbn(ALREADYKINOUGENKENHANTEIYOUHIKBN);
            kinou.setKinouTeigiTaisyouKbn(ALREADYKINOUTEIGITAISYOUKBN);

            baseDomManager.insert(kinou);
        }
    }

    @Transactional
    public void createTestL0008_02(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null == kinouMode ) {

                kinouMode = kinou.createKinouMode();
                kinouMode.setKinouModeId(ALREADYKINOUMODEID);
                kinouMode.setKinouModeNm(ALREADYKINOUMODENM);
                kinouMode.setSortNo(Integer.parseInt(ALREADYKINOUMODESORTNO));
                kinouMode.setYuukouKbn(ALREADYYUUKOUKBN);
                kinouMode.setKadouTimeGroupCd(ALREADYKADOUTIMEGROUPCD);
                kinouMode.setBatchHeisouKahiKbn(ALREADYBATCHHEISOUKAHIKBN);

                baseDomManager.update(kinou);
            }
        }
    }

    @Transactional
    public void createTestL0008_03(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null != kinouMode ) {

                AS_KinouModeSiborikomi kinouModeSiborikomi1 = kinouMode.getKinouModoSiborikomi(ALREADYKINOUMODESIBORIKOMIID1);
                if ( null == kinouModeSiborikomi1 ) {

                    kinouModeSiborikomi1 = kinouMode.createKinouModeSiborikomi();
                    kinouModeSiborikomi1.setSiborikomiId(ALREADYKINOUMODESIBORIKOMIID1);
                    kinouModeSiborikomi1.setSiborikomiNm(ALREADYKINOUMODESIBORIKOMINM1);

                    baseDomManager.update(kinou);
                }

                AS_KinouModeSiborikomi kinouModeSiborikomi2 = kinouMode.getKinouModoSiborikomi(ALREADYKINOUMODESIBORIKOMIID2);
                if ( null == kinouModeSiborikomi2 ) {

                    kinouModeSiborikomi2 = kinouMode.createKinouModeSiborikomi();
                    kinouModeSiborikomi2.setSiborikomiId(ALREADYKINOUMODESIBORIKOMIID2);
                    kinouModeSiborikomi2.setSiborikomiNm(ALREADYKINOUMODESIBORIKOMINM2);

                    baseDomManager.update(kinou);
                }
            }
        }
    }

    @Transactional
    public void createTestL0008_04(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null != kinouMode ) {

                AS_KinouModeSiborikomi kinouModeSiborikomi = kinouMode.getKinouModoSiborikomi(ALREADYKINOUMODESIBORIKOMIID1);
                if ( null != kinouModeSiborikomi ) {

                    AT_KinouKengen kinouKengen = kinouMode.getKinouKengen(ALREADYKINOUKENGENROLECD);
                    if ( null == kinouKengen ) {

                        kinouKengen = kinouMode.createKinouKengen();
                        kinouKengen.setRoleCd(ALREADYKINOUKENGENROLECD);
                        kinouKengen.setSiborikomiId(ALREADYKINOUMODESIBORIKOMIID1);

                        baseDomManager.update(kinou);
                    }
                }
            }
        }
    }

    @Transactional
    public void deleteTestL0008_01(){

        baseDomManager.clear();
        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null != kinouMode ) {

                kinouMode.getKinouModeSiborikomis().removeAll(kinouMode.getKinouModeSiborikomis());
                kinouMode.getKinouKengens().removeAll(kinouMode.getKinouKengens());
            }

            kinou.getKinouModes().removeAll(kinou.getKinouModes());

            baseDomManager.update(kinou);
            baseDomManager.delete(kinou);
        }
    }

    @Transactional
    public void createTestL0009_01(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null == kinou ) {

            kinou = new AS_Kinou();
            kinou.setKinouId(ALREADYKINOUID);
            kinou.setSubSystemId(ALREADYSUBSYSTEMID);
            kinou.setCategoryId(ALREADYCATEGORYID);
            kinou.setKinouNm(ALREADYKINOUNM);
            kinou.setSortNo(Integer.parseInt(ALREADYSORTNO));
            kinou.setKinouKbn(ALREADYKINOUKBN);
            kinou.setBatchKyouseiSyuuryouFlag(ALREADYBATCHKYOUSEISYUURYOUFLAG);
            kinou.setMenuHyoujiKahi(ALREADYMENUHYOUJIKBN);
            kinou.setBatchLogHyoujiKbn(ALREADYBATCHLOGHYOUJIKBN);
            kinou.setKidouKengenHanteiYouhiKbn(ALREADYKINOUGENKENHANTEIYOUHIKBN);
            kinou.setKinouTeigiTaisyouKbn(ALREADYKINOUTEIGITAISYOUKBN);

            baseDomManager.insert(kinou);
        }
    }

    @Transactional
    public void createTestL0009_02(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null == kinouMode ) {

                kinouMode = kinou.createKinouMode();
                kinouMode.setKinouModeId(ALREADYKINOUMODEID);
                kinouMode.setKinouModeNm(ALREADYKINOUMODENM);
                kinouMode.setSortNo(Integer.parseInt(ALREADYKINOUMODESORTNO));
                kinouMode.setYuukouKbn(ALREADYYUUKOUKBN);
                kinouMode.setKadouTimeGroupCd(ALREADYKADOUTIMEGROUPCD);
                kinouMode.setBatchHeisouKahiKbn(ALREADYBATCHHEISOUKAHIKBN);

                baseDomManager.update(kinou);
            }
        }
    }

    @Transactional
    public void createTestL0009_03(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null != kinouMode ) {

                AS_KinouModeSiborikomi kinouModeSiborikomi1 = kinouMode.getKinouModoSiborikomi(ALREADYKINOUMODESIBORIKOMIID1);
                if ( null == kinouModeSiborikomi1 ) {

                    kinouModeSiborikomi1 = kinouMode.createKinouModeSiborikomi();
                    kinouModeSiborikomi1.setSiborikomiId(ALREADYKINOUMODESIBORIKOMIID1);
                    kinouModeSiborikomi1.setSiborikomiNm(ALREADYKINOUMODESIBORIKOMINM1);

                    baseDomManager.update(kinou);
                }

                AS_KinouModeSiborikomi kinouModeSiborikomi2 = kinouMode.getKinouModoSiborikomi(ALREADYKINOUMODESIBORIKOMIID2);
                if ( null == kinouModeSiborikomi2 ) {

                    kinouModeSiborikomi2 = kinouMode.createKinouModeSiborikomi();
                    kinouModeSiborikomi2.setSiborikomiId(ALREADYKINOUMODESIBORIKOMIID2);
                    kinouModeSiborikomi2.setSiborikomiNm(ALREADYKINOUMODESIBORIKOMINM2);

                    baseDomManager.update(kinou);
                }
            }
        }
    }

    @Transactional
    public void createTestL0009_04(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null != kinouMode ) {

                AS_KinouModeSiborikomi kinouModeSiborikomi = kinouMode.getKinouModoSiborikomi(ALREADYKINOUMODESIBORIKOMIID1);
                if ( null != kinouModeSiborikomi ) {

                    AT_KinouKengen kinouKengen = kinouMode.getKinouKengen(ALREADYKINOUKENGENROLECD);
                    if ( null == kinouKengen ) {

                        kinouKengen = kinouMode.createKinouKengen();
                        kinouKengen.setRoleCd(ALREADYKINOUKENGENROLECD);
                        kinouKengen.setSiborikomiId(ALREADYKINOUMODESIBORIKOMIID1);

                        baseDomManager.update(kinou);
                    }
                }
            }
        }
    }

    @Transactional
    public void deleteTestL0009_01(){

        baseDomManager.clear();
        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null != kinouMode ) {

                kinouMode.getKinouModeSiborikomis().removeAll(kinouMode.getKinouModeSiborikomis());
                kinouMode.getKinouKengens().removeAll(kinouMode.getKinouKengens());
            }

            kinou.getKinouModes().removeAll(kinou.getKinouModes());

            baseDomManager.update(kinou);
            baseDomManager.delete(kinou);
        }
    }

    @Transactional
    public void createTestL0010_01(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null == kinou ) {

            kinou = new AS_Kinou();
            kinou.setKinouId(ALREADYKINOUID);
            kinou.setSubSystemId(ALREADYSUBSYSTEMID);
            kinou.setCategoryId(ALREADYCATEGORYID);
            kinou.setKinouNm(ALREADYKINOUNM);
            kinou.setSortNo(Integer.parseInt(ALREADYSORTNO));
            kinou.setKinouKbn(ALREADYKINOUKBN);
            kinou.setBatchKyouseiSyuuryouFlag(ALREADYBATCHKYOUSEISYUURYOUFLAG);
            kinou.setMenuHyoujiKahi(ALREADYMENUHYOUJIKBN);
            kinou.setBatchLogHyoujiKbn(ALREADYBATCHLOGHYOUJIKBN);
            kinou.setKidouKengenHanteiYouhiKbn(ALREADYKINOUGENKENHANTEIYOUHIKBN);
            kinou.setKinouTeigiTaisyouKbn(ALREADYKINOUTEIGITAISYOUKBN);

            baseDomManager.insert(kinou);
        }
    }

    @Transactional
    public void createTestL0010_02(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null == kinouMode ) {

                kinouMode = kinou.createKinouMode();
                kinouMode.setKinouModeId(ALREADYKINOUMODEID);
                kinouMode.setKinouModeNm(ALREADYKINOUMODENM);
                kinouMode.setSortNo(Integer.parseInt(ALREADYKINOUMODESORTNO));
                kinouMode.setYuukouKbn(ALREADYYUUKOUKBN);
                kinouMode.setKadouTimeGroupCd(ALREADYKADOUTIMEGROUPCD);
                kinouMode.setBatchHeisouKahiKbn(ALREADYBATCHHEISOUKAHIKBN);

                baseDomManager.update(kinou);
            }
        }
    }

    @Transactional
    public void createTestL0010_03(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null != kinouMode ) {

                AS_KinouModeSiborikomi kinouModeSiborikomi1 = kinouMode.getKinouModoSiborikomi(ALREADYKINOUMODESIBORIKOMIID1);
                if ( null == kinouModeSiborikomi1 ) {

                    kinouModeSiborikomi1 = kinouMode.createKinouModeSiborikomi();
                    kinouModeSiborikomi1.setSiborikomiId(ALREADYKINOUMODESIBORIKOMIID1);
                    kinouModeSiborikomi1.setSiborikomiNm(ALREADYKINOUMODESIBORIKOMINM1);

                    baseDomManager.update(kinou);
                }

                AS_KinouModeSiborikomi kinouModeSiborikomi2 = kinouMode.getKinouModoSiborikomi(ALREADYKINOUMODESIBORIKOMIID2);
                if ( null == kinouModeSiborikomi2 ) {

                    kinouModeSiborikomi2 = kinouMode.createKinouModeSiborikomi();
                    kinouModeSiborikomi2.setSiborikomiId(ALREADYKINOUMODESIBORIKOMIID2);
                    kinouModeSiborikomi2.setSiborikomiNm(ALREADYKINOUMODESIBORIKOMINM2);

                    baseDomManager.update(kinou);
                }
            }
        }
    }

    @Transactional
    public void createTestL0010_04(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null != kinouMode ) {

                AS_KinouModeSiborikomi kinouModeSiborikomi = kinouMode.getKinouModoSiborikomi(ALREADYKINOUMODESIBORIKOMIID1);
                if ( null != kinouModeSiborikomi ) {

                    AT_KinouKengen kinouKengen = kinouMode.getKinouKengen(ALREADYKINOUKENGENROLECD);
                    if ( null == kinouKengen ) {

                        kinouKengen = kinouMode.createKinouKengen();
                        kinouKengen.setRoleCd(ALREADYKINOUKENGENROLECD);
                        kinouKengen.setSiborikomiId(ALREADYKINOUMODESIBORIKOMIID1);

                        baseDomManager.update(kinou);
                    }
                }
            }
        }
    }

    @Transactional
    public void deleteTestL0010_01(){

        baseDomManager.clear();
        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null != kinouMode ) {

                kinouMode.getKinouModeSiborikomis().removeAll(kinouMode.getKinouModeSiborikomis());
                kinouMode.getKinouKengens().removeAll(kinouMode.getKinouKengens());
            }

            kinou.getKinouModes().removeAll(kinou.getKinouModes());

            baseDomManager.update(kinou);
            baseDomManager.delete(kinou);
        }
    }

    @Transactional
    public void createTestL0011_01(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null == kinou ) {

            kinou = new AS_Kinou();
            kinou.setKinouId(ALREADYKINOUID);
            kinou.setSubSystemId(ALREADYSUBSYSTEMID);
            kinou.setCategoryId(ALREADYCATEGORYID);
            kinou.setKinouNm(ALREADYKINOUNM);
            kinou.setSortNo(Integer.parseInt(ALREADYSORTNO));
            kinou.setKinouKbn(ALREADYKINOUKBN);
            kinou.setBatchKyouseiSyuuryouFlag(ALREADYBATCHKYOUSEISYUURYOUFLAG);
            kinou.setMenuHyoujiKahi(ALREADYMENUHYOUJIKBN);
            kinou.setBatchLogHyoujiKbn(ALREADYBATCHLOGHYOUJIKBN);
            kinou.setKidouKengenHanteiYouhiKbn(ALREADYKINOUGENKENHANTEIYOUHIKBN);
            kinou.setKinouTeigiTaisyouKbn(ALREADYKINOUTEIGITAISYOUKBN);

            baseDomManager.insert(kinou);
        }
    }

    @Transactional
    public void createTestL0011_02(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null == kinouMode ) {

                kinouMode = kinou.createKinouMode();
                kinouMode.setKinouModeId(ALREADYKINOUMODEID);
                kinouMode.setKinouModeNm(ALREADYKINOUMODENM);
                kinouMode.setSortNo(Integer.parseInt(ALREADYKINOUMODESORTNO));
                kinouMode.setYuukouKbn(ALREADYYUUKOUKBN);
                kinouMode.setKadouTimeGroupCd(ALREADYKADOUTIMEGROUPCD);
                kinouMode.setBatchHeisouKahiKbn(ALREADYBATCHHEISOUKAHIKBN);

                baseDomManager.update(kinou);
            }
        }
    }

    @Transactional
    public void createTestL0011_03(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null != kinouMode ) {

                AS_KinouModeSiborikomi kinouModeSiborikomi1 = kinouMode.getKinouModoSiborikomi(ALREADYKINOUMODESIBORIKOMIID1);
                if ( null == kinouModeSiborikomi1 ) {

                    kinouModeSiborikomi1 = kinouMode.createKinouModeSiborikomi();
                    kinouModeSiborikomi1.setSiborikomiId(ALREADYKINOUMODESIBORIKOMIID1);
                    kinouModeSiborikomi1.setSiborikomiNm(ALREADYKINOUMODESIBORIKOMINM1);

                    baseDomManager.update(kinou);
                }

                AS_KinouModeSiborikomi kinouModeSiborikomi2 = kinouMode.getKinouModoSiborikomi(ALREADYKINOUMODESIBORIKOMIID2);
                if ( null == kinouModeSiborikomi2 ) {

                    kinouModeSiborikomi2 = kinouMode.createKinouModeSiborikomi();
                    kinouModeSiborikomi2.setSiborikomiId(ALREADYKINOUMODESIBORIKOMIID2);
                    kinouModeSiborikomi2.setSiborikomiNm(ALREADYKINOUMODESIBORIKOMINM2);

                    baseDomManager.update(kinou);
                }
            }
        }
    }

    @Transactional
    public void createTestL0011_04(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null != kinouMode ) {

                AS_KinouModeSiborikomi kinouModeSiborikomi = kinouMode.getKinouModoSiborikomi(ALREADYKINOUMODESIBORIKOMIID1);
                if ( null != kinouModeSiborikomi ) {

                    AT_KinouKengen kinouKengen = kinouMode.getKinouKengen(ALREADYKINOUKENGENROLECD);
                    if ( null == kinouKengen ) {

                        kinouKengen = kinouMode.createKinouKengen();
                        kinouKengen.setRoleCd(ALREADYKINOUKENGENROLECD);
                        kinouKengen.setSiborikomiId(ALREADYKINOUMODESIBORIKOMIID1);

                        baseDomManager.update(kinou);
                    }
                }
            }
        }
    }

    @Transactional
    public void deleteTestL0011_01(){

        baseDomManager.clear();
        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null != kinouMode ) {

                kinouMode.getKinouModeSiborikomis().removeAll(kinouMode.getKinouModeSiborikomis());
                kinouMode.getKinouKengens().removeAll(kinouMode.getKinouKengens());
            }

            kinou.getKinouModes().removeAll(kinou.getKinouModes());

            baseDomManager.update(kinou);
            baseDomManager.delete(kinou);
        }
    }

    @Transactional
    public void createTestL0012_01(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null == kinou ) {

            kinou = new AS_Kinou();
            kinou.setKinouId(ALREADYKINOUID);
            kinou.setSubSystemId(ALREADYSUBSYSTEMID);
            kinou.setCategoryId(ALREADYCATEGORYID);
            kinou.setKinouNm(ALREADYKINOUNM);
            kinou.setSortNo(Integer.parseInt(ALREADYSORTNO));
            kinou.setKinouKbn(ALREADYKINOUKBN);
            kinou.setBatchKyouseiSyuuryouFlag(ALREADYBATCHKYOUSEISYUURYOUFLAG);
            kinou.setMenuHyoujiKahi(ALREADYMENUHYOUJIKBN);
            kinou.setBatchLogHyoujiKbn(ALREADYBATCHLOGHYOUJIKBN);
            kinou.setKidouKengenHanteiYouhiKbn(ALREADYKINOUGENKENHANTEIYOUHIKBN);
            kinou.setKinouTeigiTaisyouKbn(ALREADYKINOUTEIGITAISYOUKBN);

            baseDomManager.insert(kinou);
        }
    }

    @Transactional
    public void createTestL0012_02(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null == kinouMode ) {

                kinouMode = kinou.createKinouMode();
                kinouMode.setKinouModeId(ALREADYKINOUMODEID);
                kinouMode.setKinouModeNm(ALREADYKINOUMODENM);
                kinouMode.setSortNo(Integer.parseInt(ALREADYKINOUMODESORTNO));
                kinouMode.setYuukouKbn(ALREADYYUUKOUKBN);
                kinouMode.setKadouTimeGroupCd(ALREADYKADOUTIMEGROUPCD);
                kinouMode.setBatchHeisouKahiKbn(ALREADYBATCHHEISOUKAHIKBN);

                baseDomManager.update(kinou);
            }
        }
    }

    @Transactional
    public void createTestL0012_03(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null != kinouMode ) {

                AS_KinouModeSiborikomi kinouModeSiborikomi1 = kinouMode.getKinouModoSiborikomi(ALREADYKINOUMODESIBORIKOMIID1);
                if ( null == kinouModeSiborikomi1 ) {

                    kinouModeSiborikomi1 = kinouMode.createKinouModeSiborikomi();
                    kinouModeSiborikomi1.setSiborikomiId(ALREADYKINOUMODESIBORIKOMIID1);
                    kinouModeSiborikomi1.setSiborikomiNm(ALREADYKINOUMODESIBORIKOMINM1);

                    baseDomManager.update(kinou);
                }

                AS_KinouModeSiborikomi kinouModeSiborikomi2 = kinouMode.getKinouModoSiborikomi(ALREADYKINOUMODESIBORIKOMIID2);
                if ( null == kinouModeSiborikomi2 ) {

                    kinouModeSiborikomi2 = kinouMode.createKinouModeSiborikomi();
                    kinouModeSiborikomi2.setSiborikomiId(ALREADYKINOUMODESIBORIKOMIID2);
                    kinouModeSiborikomi2.setSiborikomiNm(ALREADYKINOUMODESIBORIKOMINM2);

                    baseDomManager.update(kinou);
                }
            }
        }
    }

    @Transactional
    public void createTestL0012_04(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null != kinouMode ) {

                AS_KinouModeSiborikomi kinouModeSiborikomi = kinouMode.getKinouModoSiborikomi(ALREADYKINOUMODESIBORIKOMIID1);
                if ( null != kinouModeSiborikomi ) {

                    AT_KinouKengen kinouKengen = kinouMode.getKinouKengen(ALREADYKINOUKENGENROLECD);
                    if ( null == kinouKengen ) {

                        kinouKengen = kinouMode.createKinouKengen();
                        kinouKengen.setRoleCd(ALREADYKINOUKENGENROLECD);
                        kinouKengen.setSiborikomiId(ALREADYKINOUMODESIBORIKOMIID1);

                        baseDomManager.update(kinou);
                    }
                }
            }
        }
    }

    @Transactional
    public void deleteTestL0012_01(){

        baseDomManager.clear();
        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null != kinouMode ) {

                kinouMode.getKinouModeSiborikomis().removeAll(kinouMode.getKinouModeSiborikomis());
                kinouMode.getKinouKengens().removeAll(kinouMode.getKinouKengens());
            }

            kinou.getKinouModes().removeAll(kinou.getKinouModes());

            baseDomManager.update(kinou);
            baseDomManager.delete(kinou);
        }
    }

    @Transactional
    public void createTestL0013_01(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null == kinou ) {

            kinou = new AS_Kinou();
            kinou.setKinouId(ALREADYKINOUID);
            kinou.setSubSystemId(ALREADYSUBSYSTEMID);
            kinou.setCategoryId(ALREADYCATEGORYID);
            kinou.setKinouNm(ALREADYKINOUNM);
            kinou.setSortNo(Integer.parseInt(ALREADYSORTNO));
            kinou.setKinouKbn(ALREADYKINOUKBN);
            kinou.setBatchKyouseiSyuuryouFlag(ALREADYBATCHKYOUSEISYUURYOUFLAG);
            kinou.setMenuHyoujiKahi(ALREADYMENUHYOUJIKBN);
            kinou.setBatchLogHyoujiKbn(ALREADYBATCHLOGHYOUJIKBN);
            kinou.setKidouKengenHanteiYouhiKbn(ALREADYKINOUGENKENHANTEIYOUHIKBN);
            kinou.setKinouTeigiTaisyouKbn(ALREADYKINOUTEIGITAISYOUKBN);

            baseDomManager.insert(kinou);
        }
    }

    @Transactional
    public void createTestL0013_02(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null == kinouMode ) {

                kinouMode = kinou.createKinouMode();
                kinouMode.setKinouModeId(ALREADYKINOUMODEID);
                kinouMode.setKinouModeNm(ALREADYKINOUMODENM);
                kinouMode.setSortNo(Integer.parseInt(ALREADYKINOUMODESORTNO));
                kinouMode.setYuukouKbn(ALREADYYUUKOUKBN);
                kinouMode.setKadouTimeGroupCd(ALREADYKADOUTIMEGROUPCD);
                kinouMode.setBatchHeisouKahiKbn(ALREADYBATCHHEISOUKAHIKBN);

                baseDomManager.update(kinou);
            }
        }
    }

    @Transactional
    public void createTestL0013_03(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null != kinouMode ) {

                AS_KinouModeSiborikomi kinouModeSiborikomi1 = kinouMode.getKinouModoSiborikomi(ALREADYKINOUMODESIBORIKOMIID1);
                if ( null == kinouModeSiborikomi1 ) {

                    kinouModeSiborikomi1 = kinouMode.createKinouModeSiborikomi();
                    kinouModeSiborikomi1.setSiborikomiId(ALREADYKINOUMODESIBORIKOMIID1);
                    kinouModeSiborikomi1.setSiborikomiNm(ALREADYKINOUMODESIBORIKOMINM1);

                    baseDomManager.update(kinou);
                }

                AS_KinouModeSiborikomi kinouModeSiborikomi2 = kinouMode.getKinouModoSiborikomi(ALREADYKINOUMODESIBORIKOMIID2);
                if ( null == kinouModeSiborikomi2 ) {

                    kinouModeSiborikomi2 = kinouMode.createKinouModeSiborikomi();
                    kinouModeSiborikomi2.setSiborikomiId(ALREADYKINOUMODESIBORIKOMIID2);
                    kinouModeSiborikomi2.setSiborikomiNm(ALREADYKINOUMODESIBORIKOMINM2);

                    baseDomManager.update(kinou);
                }
            }
        }
    }

    @Transactional
    public void deleteTestL0013_01(){

        baseDomManager.clear();
        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null != kinouMode ) {

                kinouMode.getKinouModeSiborikomis().removeAll(kinouMode.getKinouModeSiborikomis());
            }

            kinou.getKinouModes().removeAll(kinou.getKinouModes());

            baseDomManager.update(kinou);
            baseDomManager.delete(kinou);
        }
    }

    @Transactional
    public void createTestL0014_01(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null == kinou ) {

            kinou = new AS_Kinou();
            kinou.setKinouId(ALREADYKINOUID);
            kinou.setSubSystemId(ALREADYSUBSYSTEMID);
            kinou.setCategoryId(ALREADYCATEGORYID);
            kinou.setKinouNm(ALREADYKINOUNM);
            kinou.setSortNo(Integer.parseInt(ALREADYSORTNO));
            kinou.setKinouKbn(ALREADYKINOUKBN);
            kinou.setBatchKyouseiSyuuryouFlag(ALREADYBATCHKYOUSEISYUURYOUFLAG);
            kinou.setMenuHyoujiKahi(ALREADYMENUHYOUJIKBN);
            kinou.setBatchLogHyoujiKbn(ALREADYBATCHLOGHYOUJIKBN);
            kinou.setKidouKengenHanteiYouhiKbn(ALREADYKINOUGENKENHANTEIYOUHIKBN);
            kinou.setKinouTeigiTaisyouKbn(ALREADYKINOUTEIGITAISYOUKBN);

            baseDomManager.insert(kinou);
        }
    }

    @Transactional
    public void createTestL0014_02(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null == kinouMode ) {

                kinouMode = kinou.createKinouMode();
                kinouMode.setKinouModeId(ALREADYKINOUMODEID);
                kinouMode.setKinouModeNm(ALREADYKINOUMODENM);
                kinouMode.setSortNo(Integer.parseInt(ALREADYKINOUMODESORTNO));
                kinouMode.setYuukouKbn(ALREADYYUUKOUKBN);
                kinouMode.setKadouTimeGroupCd(ALREADYKADOUTIMEGROUPCD);
                kinouMode.setBatchHeisouKahiKbn(ALREADYBATCHHEISOUKAHIKBN);

                baseDomManager.update(kinou);
            }
        }
    }

    @Transactional
    public void createTestL0014_03(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null != kinouMode ) {

                AS_KinouModeSiborikomi kinouModeSiborikomi1 = kinouMode.getKinouModoSiborikomi(ALREADYKINOUMODESIBORIKOMIID1);
                if ( null == kinouModeSiborikomi1 ) {

                    kinouModeSiborikomi1 = kinouMode.createKinouModeSiborikomi();
                    kinouModeSiborikomi1.setSiborikomiId(ALREADYKINOUMODESIBORIKOMIID1);
                    kinouModeSiborikomi1.setSiborikomiNm(ALREADYKINOUMODESIBORIKOMINM1);

                    baseDomManager.update(kinou);
                }

                AS_KinouModeSiborikomi kinouModeSiborikomi2 = kinouMode.getKinouModoSiborikomi(ALREADYKINOUMODESIBORIKOMIID2);
                if ( null == kinouModeSiborikomi2 ) {

                    kinouModeSiborikomi2 = kinouMode.createKinouModeSiborikomi();
                    kinouModeSiborikomi2.setSiborikomiId(ALREADYKINOUMODESIBORIKOMIID2);
                    kinouModeSiborikomi2.setSiborikomiNm(ALREADYKINOUMODESIBORIKOMINM2);

                    baseDomManager.update(kinou);
                }
            }
        }
    }

    @Transactional
    public void createTestL0014_04(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null != kinouMode ) {

                AS_KinouModeSiborikomi kinouModeSiborikomi = kinouMode.getKinouModoSiborikomi(ALREADYKINOUMODESIBORIKOMIID1);
                if ( null != kinouModeSiborikomi ) {

                    AT_KinouKengen kinouKengen = kinouMode.getKinouKengen(ALREADYKINOUKENGENROLECD);
                    if ( null == kinouKengen ) {

                        kinouKengen = kinouMode.createKinouKengen();
                        kinouKengen.setRoleCd(ALREADYKINOUKENGENROLECD);
                        kinouKengen.setSiborikomiId(ALREADYKINOUMODESIBORIKOMIID1);

                        baseDomManager.update(kinou);
                    }
                }
            }
        }
    }

    @Transactional
    public void deleteTestL0014_01(){

        baseDomManager.clear();
        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null != kinouMode ) {

                kinouMode.getKinouModeSiborikomis().removeAll(kinouMode.getKinouModeSiborikomis());
                kinouMode.getKinouKengens().removeAll(kinouMode.getKinouKengens());
            }

            kinou.getKinouModes().removeAll(kinou.getKinouModes());

            baseDomManager.update(kinou);
            baseDomManager.delete(kinou);
        }
    }

    @Transactional
    public void createTestL0015_01(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null == kinou ) {

            kinou = new AS_Kinou();
            kinou.setKinouId(ALREADYKINOUID);
            kinou.setSubSystemId(ALREADYSUBSYSTEMID);
            kinou.setCategoryId(ALREADYCATEGORYID);
            kinou.setKinouNm(ALREADYKINOUNM);
            kinou.setSortNo(Integer.parseInt(ALREADYSORTNO));
            kinou.setKinouKbn(ALREADYKINOUKBN);
            kinou.setBatchKyouseiSyuuryouFlag(ALREADYBATCHKYOUSEISYUURYOUFLAG);
            kinou.setMenuHyoujiKahi(ALREADYMENUHYOUJIKBN);
            kinou.setBatchLogHyoujiKbn(ALREADYBATCHLOGHYOUJIKBN);
            kinou.setKidouKengenHanteiYouhiKbn(ALREADYKINOUGENKENHANTEIYOUHIKBN);
            kinou.setKinouTeigiTaisyouKbn(ALREADYKINOUTEIGITAISYOUKBN);

            baseDomManager.insert(kinou);
        }
    }

    @Transactional
    public void createTestL0015_02(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null == kinouMode ) {

                kinouMode = kinou.createKinouMode();
                kinouMode.setKinouModeId(ALREADYKINOUMODEID);
                kinouMode.setKinouModeNm(ALREADYKINOUMODENM);
                kinouMode.setSortNo(Integer.parseInt(ALREADYKINOUMODESORTNO));
                kinouMode.setYuukouKbn(ALREADYYUUKOUKBN);
                kinouMode.setKadouTimeGroupCd(ALREADYKADOUTIMEGROUPCD);
                kinouMode.setBatchHeisouKahiKbn(ALREADYBATCHHEISOUKAHIKBN);

                baseDomManager.update(kinou);
            }
        }
    }

    @Transactional
    public void createTestL0015_03(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null != kinouMode ) {

                AS_KinouModeSiborikomi kinouModeSiborikomi1 = kinouMode.getKinouModoSiborikomi(ALREADYKINOUMODESIBORIKOMIID1);
                if ( null == kinouModeSiborikomi1 ) {

                    kinouModeSiborikomi1 = kinouMode.createKinouModeSiborikomi();
                    kinouModeSiborikomi1.setSiborikomiId(ALREADYKINOUMODESIBORIKOMIID1);
                    kinouModeSiborikomi1.setSiborikomiNm(ALREADYKINOUMODESIBORIKOMINM1);

                    baseDomManager.update(kinou);
                }

                AS_KinouModeSiborikomi kinouModeSiborikomi2 = kinouMode.getKinouModoSiborikomi(ALREADYKINOUMODESIBORIKOMIID2);
                if ( null == kinouModeSiborikomi2 ) {

                    kinouModeSiborikomi2 = kinouMode.createKinouModeSiborikomi();
                    kinouModeSiborikomi2.setSiborikomiId(ALREADYKINOUMODESIBORIKOMIID2);
                    kinouModeSiborikomi2.setSiborikomiNm(ALREADYKINOUMODESIBORIKOMINM2);

                    baseDomManager.update(kinou);
                }
            }
        }
    }

    @Transactional
    public void createTestL0015_04(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null != kinouMode ) {

                AS_KinouModeSiborikomi kinouModeSiborikomi = kinouMode.getKinouModoSiborikomi(ALREADYKINOUMODESIBORIKOMIID1);
                if ( null != kinouModeSiborikomi ) {

                    AT_KinouKengen kinouKengen = kinouMode.getKinouKengen(ALREADYKINOUKENGENROLECD);
                    if ( null == kinouKengen ) {

                        kinouKengen = kinouMode.createKinouKengen();
                        kinouKengen.setRoleCd(ALREADYKINOUKENGENROLECD);
                        kinouKengen.setSiborikomiId(ALREADYKINOUMODESIBORIKOMIID1);

                        baseDomManager.update(kinou);
                    }
                }
            }
        }
    }

    @Transactional
    public void deleteTestL0015_01(){

        baseDomManager.clear();
        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null != kinouMode ) {

                kinouMode.getKinouModeSiborikomis().removeAll(kinouMode.getKinouModeSiborikomis());
                kinouMode.getKinouKengens().removeAll(kinouMode.getKinouKengens());
            }

            kinou.getKinouModes().removeAll(kinou.getKinouModes());

            baseDomManager.update(kinou);
            baseDomManager.delete(kinou);
        }
    }

    @Transactional
    public void createTestL0016_01(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null == kinou ) {

            kinou = new AS_Kinou();
            kinou.setKinouId(ALREADYKINOUID);
            kinou.setSubSystemId(ALREADYSUBSYSTEMID);
            kinou.setCategoryId(ALREADYCATEGORYID);
            kinou.setKinouNm(ALREADYKINOUNM);
            kinou.setSortNo(Integer.parseInt(ALREADYSORTNO));
            kinou.setKinouKbn(ALREADYKINOUKBN);
            kinou.setBatchKyouseiSyuuryouFlag(ALREADYBATCHKYOUSEISYUURYOUFLAG);
            kinou.setMenuHyoujiKahi(ALREADYMENUHYOUJIKBN);
            kinou.setBatchLogHyoujiKbn(ALREADYBATCHLOGHYOUJIKBN);
            kinou.setKidouKengenHanteiYouhiKbn(ALREADYKINOUGENKENHANTEIYOUHIKBN);
            kinou.setKinouTeigiTaisyouKbn(ALREADYKINOUTEIGITAISYOUKBN);

            baseDomManager.insert(kinou);
        }
    }

    @Transactional
    public void createTestL0016_02(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null == kinouMode ) {

                kinouMode = kinou.createKinouMode();
                kinouMode.setKinouModeId(ALREADYKINOUMODEID);
                kinouMode.setKinouModeNm(ALREADYKINOUMODENM);
                kinouMode.setSortNo(Integer.parseInt(ALREADYKINOUMODESORTNO));
                kinouMode.setYuukouKbn(ALREADYYUUKOUKBN);
                kinouMode.setKadouTimeGroupCd(ALREADYKADOUTIMEGROUPCD);
                kinouMode.setBatchHeisouKahiKbn(ALREADYBATCHHEISOUKAHIKBN);

                baseDomManager.update(kinou);
            }
        }
    }

    @Transactional
    public void createTestL0016_03(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null != kinouMode ) {

                AS_KinouModeSiborikomi kinouModeSiborikomi1 = kinouMode.getKinouModoSiborikomi(ALREADYKINOUMODESIBORIKOMIID1);
                if ( null == kinouModeSiborikomi1 ) {

                    kinouModeSiborikomi1 = kinouMode.createKinouModeSiborikomi();
                    kinouModeSiborikomi1.setSiborikomiId(ALREADYKINOUMODESIBORIKOMIID1);
                    kinouModeSiborikomi1.setSiborikomiNm(ALREADYKINOUMODESIBORIKOMINM1);

                    baseDomManager.update(kinou);
                }

                AS_KinouModeSiborikomi kinouModeSiborikomi2 = kinouMode.getKinouModoSiborikomi(ALREADYKINOUMODESIBORIKOMIID2);
                if ( null == kinouModeSiborikomi2 ) {

                    kinouModeSiborikomi2 = kinouMode.createKinouModeSiborikomi();
                    kinouModeSiborikomi2.setSiborikomiId(ALREADYKINOUMODESIBORIKOMIID2);
                    kinouModeSiborikomi2.setSiborikomiNm(ALREADYKINOUMODESIBORIKOMINM2);

                    baseDomManager.update(kinou);
                }
            }
        }
    }

    @Transactional
    public void createTestL0016_04(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null != kinouMode ) {

                AS_KinouModeSiborikomi kinouModeSiborikomi = kinouMode.getKinouModoSiborikomi(ALREADYKINOUMODESIBORIKOMIID1);
                if ( null != kinouModeSiborikomi ) {

                    AT_KinouKengen kinouKengen = kinouMode.getKinouKengen(ALREADYKINOUKENGENROLECD);
                    if ( null == kinouKengen ) {

                        kinouKengen = kinouMode.createKinouKengen();
                        kinouKengen.setRoleCd(ALREADYKINOUKENGENROLECD);
                        kinouKengen.setSiborikomiId(ALREADYKINOUMODESIBORIKOMIID1);

                        baseDomManager.update(kinou);
                    }
                }
            }
        }
    }

    @Transactional
    public void deleteTestL0016_01(){

        baseDomManager.clear();
        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null != kinouMode ) {

                kinouMode.getKinouModeSiborikomis().removeAll(kinouMode.getKinouModeSiborikomis());
                kinouMode.getKinouKengens().removeAll(kinouMode.getKinouKengens());
            }

            kinou.getKinouModes().removeAll(kinou.getKinouModes());

            baseDomManager.update(kinou);
            baseDomManager.delete(kinou);
        }
    }

    @Transactional
    public void createTestL0017_01(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null == kinou ) {

            kinou = new AS_Kinou();
            kinou.setKinouId(ALREADYKINOUID);
            kinou.setSubSystemId(ALREADYSUBSYSTEMID);
            kinou.setCategoryId(ALREADYCATEGORYID);
            kinou.setKinouNm(ALREADYKINOUNM);
            kinou.setSortNo(Integer.parseInt(ALREADYSORTNO));
            kinou.setKinouKbn(ALREADYKINOUKBN);
            kinou.setBatchKyouseiSyuuryouFlag(ALREADYBATCHKYOUSEISYUURYOUFLAG);
            kinou.setMenuHyoujiKahi(ALREADYMENUHYOUJIKBN);
            kinou.setBatchLogHyoujiKbn(ALREADYBATCHLOGHYOUJIKBN);
            kinou.setKidouKengenHanteiYouhiKbn(ALREADYKINOUGENKENHANTEIYOUHIKBN);
            kinou.setKinouTeigiTaisyouKbn(ALREADYKINOUTEIGITAISYOUKBN);

            baseDomManager.insert(kinou);
        }
    }

    @Transactional
    public void createTestL0017_02(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null == kinouMode ) {

                kinouMode = kinou.createKinouMode();
                kinouMode.setKinouModeId(ALREADYKINOUMODEID);
                kinouMode.setKinouModeNm(ALREADYKINOUMODENM);
                kinouMode.setSortNo(Integer.parseInt(ALREADYKINOUMODESORTNO));
                kinouMode.setYuukouKbn(ALREADYYUUKOUKBN);
                kinouMode.setKadouTimeGroupCd(ALREADYKADOUTIMEGROUPCD);
                kinouMode.setBatchHeisouKahiKbn(ALREADYBATCHHEISOUKAHIKBN);

                baseDomManager.update(kinou);
            }
        }
    }

    @Transactional
    public void createTestL0017_03(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null != kinouMode ) {

                AS_KinouModeSiborikomi kinouModeSiborikomi1 = kinouMode.getKinouModoSiborikomi(ALREADYKINOUMODESIBORIKOMIID1);
                if ( null == kinouModeSiborikomi1 ) {

                    kinouModeSiborikomi1 = kinouMode.createKinouModeSiborikomi();
                    kinouModeSiborikomi1.setSiborikomiId(ALREADYKINOUMODESIBORIKOMIID1);
                    kinouModeSiborikomi1.setSiborikomiNm(ALREADYKINOUMODESIBORIKOMINM1);

                    baseDomManager.update(kinou);
                }

                AS_KinouModeSiborikomi kinouModeSiborikomi2 = kinouMode.getKinouModoSiborikomi(ALREADYKINOUMODESIBORIKOMIID2);
                if ( null == kinouModeSiborikomi2 ) {

                    kinouModeSiborikomi2 = kinouMode.createKinouModeSiborikomi();
                    kinouModeSiborikomi2.setSiborikomiId(ALREADYKINOUMODESIBORIKOMIID2);
                    kinouModeSiborikomi2.setSiborikomiNm(ALREADYKINOUMODESIBORIKOMINM2);

                    baseDomManager.update(kinou);
                }
            }
        }
    }

    @Transactional
    public void createTestL0017_04(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null != kinouMode ) {

                AS_KinouModeSiborikomi kinouModeSiborikomi = kinouMode.getKinouModoSiborikomi(ALREADYKINOUMODESIBORIKOMIID1);
                if ( null != kinouModeSiborikomi ) {

                    AT_KinouKengen kinouKengen = kinouMode.getKinouKengen(ALREADYKINOUKENGENROLECD);
                    if ( null == kinouKengen ) {

                        kinouKengen = kinouMode.createKinouKengen();
                        kinouKengen.setRoleCd(ALREADYKINOUKENGENROLECD);
                        kinouKengen.setSiborikomiId(ALREADYKINOUMODESIBORIKOMIID1);

                        baseDomManager.update(kinou);
                    }
                }
            }
        }
    }

    @Transactional
    public void deleteTestL0017_01(){

        baseDomManager.clear();
        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null != kinouMode ) {

                kinouMode.getKinouModeSiborikomis().removeAll(kinouMode.getKinouModeSiborikomis());
                kinouMode.getKinouKengens().removeAll(kinouMode.getKinouKengens());
            }

            kinou.getKinouModes().removeAll(kinou.getKinouModes());

            baseDomManager.update(kinou);
            baseDomManager.delete(kinou);
        }
    }

    @Transactional
    public void createTestL0018_01(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null == kinou ) {

            kinou = new AS_Kinou();
            kinou.setKinouId(ALREADYKINOUID);
            kinou.setSubSystemId(ALREADYSUBSYSTEMID);
            kinou.setCategoryId(ALREADYCATEGORYID);
            kinou.setKinouNm(ALREADYKINOUNM);
            kinou.setSortNo(Integer.parseInt(ALREADYSORTNO));
            kinou.setKinouKbn(ALREADYKINOUKBN);
            kinou.setBatchKyouseiSyuuryouFlag(ALREADYBATCHKYOUSEISYUURYOUFLAG);
            kinou.setMenuHyoujiKahi(ALREADYMENUHYOUJIKBN);
            kinou.setBatchLogHyoujiKbn(ALREADYBATCHLOGHYOUJIKBN);
            kinou.setKidouKengenHanteiYouhiKbn(ALREADYKINOUGENKENHANTEIYOUHIKBN);
            kinou.setKinouTeigiTaisyouKbn(ALREADYKINOUTEIGITAISYOUKBN);

            baseDomManager.insert(kinou);
        }
    }

    @Transactional
    public void createTestL0018_02(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null == kinouMode ) {

                kinouMode = kinou.createKinouMode();
                kinouMode.setKinouModeId(ALREADYKINOUMODEID);
                kinouMode.setKinouModeNm(ALREADYKINOUMODENM);
                kinouMode.setSortNo(Integer.parseInt(ALREADYKINOUMODESORTNO));
                kinouMode.setYuukouKbn(ALREADYYUUKOUKBN);
                kinouMode.setKadouTimeGroupCd(ALREADYKADOUTIMEGROUPCD);
                kinouMode.setBatchHeisouKahiKbn(ALREADYBATCHHEISOUKAHIKBN);

                baseDomManager.update(kinou);
            }
        }
    }

    @Transactional
    public void createTestL0018_03(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null != kinouMode ) {

                AS_KinouModeSiborikomi kinouModeSiborikomi1 = kinouMode.getKinouModoSiborikomi(ALREADYKINOUMODESIBORIKOMIID1);
                if ( null == kinouModeSiborikomi1 ) {

                    kinouModeSiborikomi1 = kinouMode.createKinouModeSiborikomi();
                    kinouModeSiborikomi1.setSiborikomiId(ALREADYKINOUMODESIBORIKOMIID1);
                    kinouModeSiborikomi1.setSiborikomiNm(ALREADYKINOUMODESIBORIKOMINM1);

                    baseDomManager.update(kinou);
                }

                AS_KinouModeSiborikomi kinouModeSiborikomi2 = kinouMode.getKinouModoSiborikomi(ALREADYKINOUMODESIBORIKOMIID2);
                if ( null == kinouModeSiborikomi2 ) {

                    kinouModeSiborikomi2 = kinouMode.createKinouModeSiborikomi();
                    kinouModeSiborikomi2.setSiborikomiId(ALREADYKINOUMODESIBORIKOMIID2);
                    kinouModeSiborikomi2.setSiborikomiNm(ALREADYKINOUMODESIBORIKOMINM2);

                    baseDomManager.update(kinou);
                }
            }
        }
    }

    @Transactional
    public void createTestL0018_04(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null != kinouMode ) {

                AS_KinouModeSiborikomi kinouModeSiborikomi = kinouMode.getKinouModoSiborikomi(ALREADYKINOUMODESIBORIKOMIID1);
                if ( null != kinouModeSiborikomi ) {

                    AT_KinouKengen kinouKengen = kinouMode.getKinouKengen(ALREADYKINOUKENGENROLECD);
                    if ( null == kinouKengen ) {

                        kinouKengen = kinouMode.createKinouKengen();
                        kinouKengen.setRoleCd(ALREADYKINOUKENGENROLECD);
                        kinouKengen.setSiborikomiId(ALREADYKINOUMODESIBORIKOMIID1);

                        baseDomManager.update(kinou);
                    }
                }
            }
        }
    }

    @Transactional
    public void deleteTestL0018_01(){

        baseDomManager.clear();
        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null != kinouMode ) {

                kinouMode.getKinouModeSiborikomis().removeAll(kinouMode.getKinouModeSiborikomis());
                kinouMode.getKinouKengens().removeAll(kinouMode.getKinouKengens());
            }

            kinou.getKinouModes().removeAll(kinou.getKinouModes());

            baseDomManager.update(kinou);
            baseDomManager.delete(kinou);
        }
    }

    @Transactional
    public void createTestL0019_01(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null == kinou ) {

            kinou = new AS_Kinou();
            kinou.setKinouId(ALREADYKINOUID);
            kinou.setSubSystemId(ALREADYSUBSYSTEMID);
            kinou.setCategoryId(ALREADYCATEGORYID);
            kinou.setKinouNm(ALREADYKINOUNM);
            kinou.setSortNo(Integer.parseInt(ALREADYSORTNO));
            kinou.setKinouKbn(ALREADYKINOUKBN);
            kinou.setBatchKyouseiSyuuryouFlag(ALREADYBATCHKYOUSEISYUURYOUFLAG);
            kinou.setMenuHyoujiKahi(ALREADYMENUHYOUJIKBN);
            kinou.setBatchLogHyoujiKbn(ALREADYBATCHLOGHYOUJIKBN);
            kinou.setKidouKengenHanteiYouhiKbn(ALREADYKINOUGENKENHANTEIYOUHIKBN);
            kinou.setKinouTeigiTaisyouKbn(ALREADYKINOUTEIGITAISYOUKBN);

            baseDomManager.insert(kinou);
        }
    }

    @Transactional
    public void createTestL0019_02(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null == kinouMode ) {

                kinouMode = kinou.createKinouMode();
                kinouMode.setKinouModeId(ALREADYKINOUMODEID);
                kinouMode.setKinouModeNm(ALREADYKINOUMODENM);
                kinouMode.setSortNo(Integer.parseInt(ALREADYKINOUMODESORTNO));
                kinouMode.setYuukouKbn(ALREADYYUUKOUKBN);
                kinouMode.setKadouTimeGroupCd(ALREADYKADOUTIMEGROUPCD);
                kinouMode.setBatchHeisouKahiKbn(ALREADYBATCHHEISOUKAHIKBN);

                baseDomManager.update(kinou);
            }
        }
    }

    @Transactional
    public void createTestL0019_03(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null != kinouMode ) {

                AS_KinouModeSiborikomi kinouModeSiborikomi1 = kinouMode.getKinouModoSiborikomi(ALREADYKINOUMODESIBORIKOMIID1);
                if ( null == kinouModeSiborikomi1 ) {

                    kinouModeSiborikomi1 = kinouMode.createKinouModeSiborikomi();
                    kinouModeSiborikomi1.setSiborikomiId(ALREADYKINOUMODESIBORIKOMIID1);
                    kinouModeSiborikomi1.setSiborikomiNm(ALREADYKINOUMODESIBORIKOMINM1);

                    baseDomManager.update(kinou);
                }

                AS_KinouModeSiborikomi kinouModeSiborikomi2 = kinouMode.getKinouModoSiborikomi(ALREADYKINOUMODESIBORIKOMIID2);
                if ( null == kinouModeSiborikomi2 ) {

                    kinouModeSiborikomi2 = kinouMode.createKinouModeSiborikomi();
                    kinouModeSiborikomi2.setSiborikomiId(ALREADYKINOUMODESIBORIKOMIID2);
                    kinouModeSiborikomi2.setSiborikomiNm(ALREADYKINOUMODESIBORIKOMINM2);

                    baseDomManager.update(kinou);
                }
            }
        }
    }

    @Transactional
    public void createTestL0019_04(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null != kinouMode ) {

                AS_KinouModeSiborikomi kinouModeSiborikomi = kinouMode.getKinouModoSiborikomi(ALREADYKINOUMODESIBORIKOMIID1);
                if ( null != kinouModeSiborikomi ) {

                    AT_KinouKengen kinouKengen = kinouMode.getKinouKengen(ALREADYKINOUKENGENROLECD);
                    if ( null == kinouKengen ) {

                        kinouKengen = kinouMode.createKinouKengen();
                        kinouKengen.setRoleCd(ALREADYKINOUKENGENROLECD);
                        kinouKengen.setSiborikomiId(ALREADYKINOUMODESIBORIKOMIID1);

                        baseDomManager.update(kinou);
                    }
                }
            }
        }
    }

    @Transactional
    public void deleteTestL0019_01(){

        baseDomManager.clear();
        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null != kinouMode ) {

                kinouMode.getKinouModeSiborikomis().removeAll(kinouMode.getKinouModeSiborikomis());
                kinouMode.getKinouKengens().removeAll(kinouMode.getKinouKengens());
            }

            kinou.getKinouModes().removeAll(kinou.getKinouModes());

            baseDomManager.update(kinou);
            baseDomManager.delete(kinou);
        }
    }

    @Transactional
    public void createTestL0020_01(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null == kinou ) {

            kinou = new AS_Kinou();
            kinou.setKinouId(ALREADYKINOUID);
            kinou.setSubSystemId(ALREADYSUBSYSTEMID);
            kinou.setCategoryId(ALREADYCATEGORYID);
            kinou.setKinouNm(ALREADYKINOUNM);
            kinou.setSortNo(Integer.parseInt(ALREADYSORTNO));
            kinou.setKinouKbn(ALREADYKINOUKBN);
            kinou.setBatchKyouseiSyuuryouFlag(ALREADYBATCHKYOUSEISYUURYOUFLAG);
            kinou.setMenuHyoujiKahi(ALREADYMENUHYOUJIKBN);
            kinou.setBatchLogHyoujiKbn(ALREADYBATCHLOGHYOUJIKBN);
            kinou.setKidouKengenHanteiYouhiKbn(ALREADYKINOUGENKENHANTEIYOUHIKBN);
            kinou.setKinouTeigiTaisyouKbn(ALREADYKINOUTEIGITAISYOUKBN);

            baseDomManager.insert(kinou);
        }
    }

    @Transactional
    public void createTestL0020_02(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null == kinouMode ) {

                kinouMode = kinou.createKinouMode();
                kinouMode.setKinouModeId(ALREADYKINOUMODEID);
                kinouMode.setKinouModeNm(ALREADYKINOUMODENM);
                kinouMode.setSortNo(Integer.parseInt(ALREADYKINOUMODESORTNO));
                kinouMode.setYuukouKbn(ALREADYYUUKOUKBN);
                kinouMode.setKadouTimeGroupCd(ALREADYKADOUTIMEGROUPCD);
                kinouMode.setBatchHeisouKahiKbn(ALREADYBATCHHEISOUKAHIKBN);

                baseDomManager.update(kinou);
            }
        }
    }

    @Transactional
    public void createTestL0020_03(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null != kinouMode ) {

                AS_KinouModeSiborikomi kinouModeSiborikomi1 = kinouMode.getKinouModoSiborikomi(ALREADYKINOUMODESIBORIKOMIID1);
                if ( null == kinouModeSiborikomi1 ) {

                    kinouModeSiborikomi1 = kinouMode.createKinouModeSiborikomi();
                    kinouModeSiborikomi1.setSiborikomiId(ALREADYKINOUMODESIBORIKOMIID1);
                    kinouModeSiborikomi1.setSiborikomiNm(ALREADYKINOUMODESIBORIKOMINM1);

                    baseDomManager.update(kinou);
                }

                AS_KinouModeSiborikomi kinouModeSiborikomi2 = kinouMode.getKinouModoSiborikomi(ALREADYKINOUMODESIBORIKOMIID2);
                if ( null == kinouModeSiborikomi2 ) {

                    kinouModeSiborikomi2 = kinouMode.createKinouModeSiborikomi();
                    kinouModeSiborikomi2.setSiborikomiId(ALREADYKINOUMODESIBORIKOMIID2);
                    kinouModeSiborikomi2.setSiborikomiNm(ALREADYKINOUMODESIBORIKOMINM2);

                    baseDomManager.update(kinou);
                }
            }
        }
    }

    @Transactional
    public void createTestL0020_04(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null != kinouMode ) {

                AS_KinouModeSiborikomi kinouModeSiborikomi = kinouMode.getKinouModoSiborikomi(ALREADYKINOUMODESIBORIKOMIID1);
                if ( null != kinouModeSiborikomi ) {

                    AT_KinouKengen kinouKengen = kinouMode.getKinouKengen(ALREADYKINOUKENGENROLECD);
                    if ( null == kinouKengen ) {

                        kinouKengen = kinouMode.createKinouKengen();
                        kinouKengen.setRoleCd(ALREADYKINOUKENGENROLECD);
                        kinouKengen.setSiborikomiId(ALREADYKINOUMODESIBORIKOMIID1);

                        baseDomManager.update(kinou);
                    }
                }
            }
        }
    }

    @Transactional
    public void deleteTestL0020_01(){

        baseDomManager.clear();
        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null != kinouMode ) {

                kinouMode.getKinouModeSiborikomis().removeAll(kinouMode.getKinouModeSiborikomis());
                kinouMode.getKinouKengens().removeAll(kinouMode.getKinouKengens());
            }

            kinou.getKinouModes().removeAll(kinou.getKinouModes());

            baseDomManager.update(kinou);
            baseDomManager.delete(kinou);
        }
    }

    @Transactional
    public void createTestL0021_01(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null == kinou ) {

            kinou = new AS_Kinou();
            kinou.setKinouId(ALREADYKINOUID);
            kinou.setSubSystemId(ALREADYSUBSYSTEMID);
            kinou.setCategoryId(ALREADYCATEGORYID);
            kinou.setKinouNm(ALREADYKINOUNM);
            kinou.setSortNo(Integer.parseInt(ALREADYSORTNO));
            kinou.setKinouKbn(ALREADYKINOUKBN);
            kinou.setBatchKyouseiSyuuryouFlag(ALREADYBATCHKYOUSEISYUURYOUFLAG);
            kinou.setMenuHyoujiKahi(ALREADYMENUHYOUJIKBN);
            kinou.setBatchLogHyoujiKbn(ALREADYBATCHLOGHYOUJIKBN);
            kinou.setKidouKengenHanteiYouhiKbn(ALREADYKINOUGENKENHANTEIYOUHIKBN);
            kinou.setKinouTeigiTaisyouKbn(ALREADYKINOUTEIGITAISYOUKBN);

            baseDomManager.insert(kinou);
        }
    }

    @Transactional
    public void createTestL0021_02(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null == kinouMode ) {

                kinouMode = kinou.createKinouMode();
                kinouMode.setKinouModeId(ALREADYKINOUMODEID);
                kinouMode.setKinouModeNm(ALREADYKINOUMODENM);
                kinouMode.setSortNo(Integer.parseInt(ALREADYKINOUMODESORTNO));
                kinouMode.setYuukouKbn(ALREADYYUUKOUKBN);
                kinouMode.setKadouTimeGroupCd(ALREADYKADOUTIMEGROUPCD);
                kinouMode.setBatchHeisouKahiKbn(ALREADYBATCHHEISOUKAHIKBN);

                baseDomManager.update(kinou);
            }
        }
    }

    @Transactional
    public void createTestL0021_03(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null != kinouMode ) {

                AS_KinouModeSiborikomi kinouModeSiborikomi1 = kinouMode.getKinouModoSiborikomi(ALREADYKINOUMODESIBORIKOMIID1);
                if ( null == kinouModeSiborikomi1 ) {

                    kinouModeSiborikomi1 = kinouMode.createKinouModeSiborikomi();
                    kinouModeSiborikomi1.setSiborikomiId(ALREADYKINOUMODESIBORIKOMIID1);
                    kinouModeSiborikomi1.setSiborikomiNm(ALREADYKINOUMODESIBORIKOMINM1);

                    baseDomManager.update(kinou);
                }

                AS_KinouModeSiborikomi kinouModeSiborikomi2 = kinouMode.getKinouModoSiborikomi(ALREADYKINOUMODESIBORIKOMIID2);
                if ( null == kinouModeSiborikomi2 ) {

                    kinouModeSiborikomi2 = kinouMode.createKinouModeSiborikomi();
                    kinouModeSiborikomi2.setSiborikomiId(ALREADYKINOUMODESIBORIKOMIID2);
                    kinouModeSiborikomi2.setSiborikomiNm(ALREADYKINOUMODESIBORIKOMINM2);

                    baseDomManager.update(kinou);
                }
            }
        }
    }

    @Transactional
    public void createTestL0021_04(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null != kinouMode ) {

                AS_KinouModeSiborikomi kinouModeSiborikomi = kinouMode.getKinouModoSiborikomi(ALREADYKINOUMODESIBORIKOMIID1);
                if ( null != kinouModeSiborikomi ) {

                    AT_KinouKengen kinouKengen = kinouMode.getKinouKengen(ALREADYKINOUKENGENROLECD);
                    if ( null == kinouKengen ) {

                        kinouKengen = kinouMode.createKinouKengen();
                        kinouKengen.setRoleCd(ALREADYKINOUKENGENROLECD);
                        kinouKengen.setSiborikomiId(ALREADYKINOUMODESIBORIKOMIID1);

                        baseDomManager.update(kinou);
                    }
                }
            }
        }
    }

    @Transactional
    public void deleteTestL0021_01(){

        baseDomManager.clear();
        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null != kinouMode ) {

                kinouMode.getKinouModeSiborikomis().removeAll(kinouMode.getKinouModeSiborikomis());
                kinouMode.getKinouKengens().removeAll(kinouMode.getKinouKengens());
            }

            kinou.getKinouModes().removeAll(kinou.getKinouModes());

            baseDomManager.update(kinou);
            baseDomManager.delete(kinou);
        }
    }

    @Transactional
    public void createTestL0022_01(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null == kinou ) {

            kinou = new AS_Kinou();
            kinou.setKinouId(ALREADYKINOUID);
            kinou.setSubSystemId(ALREADYSUBSYSTEMID);
            kinou.setCategoryId(ALREADYCATEGORYID);
            kinou.setKinouNm(ALREADYKINOUNM);
            kinou.setSortNo(Integer.parseInt(ALREADYSORTNO));
            kinou.setKinouKbn(ALREADYKINOUKBN);
            kinou.setBatchKyouseiSyuuryouFlag(ALREADYBATCHKYOUSEISYUURYOUFLAG);
            kinou.setMenuHyoujiKahi(ALREADYMENUHYOUJIKBN);
            kinou.setBatchLogHyoujiKbn(ALREADYBATCHLOGHYOUJIKBN);
            kinou.setKidouKengenHanteiYouhiKbn(ALREADYKINOUGENKENHANTEIYOUHIKBN);
            kinou.setKinouTeigiTaisyouKbn(ALREADYKINOUTEIGITAISYOUKBN);

            baseDomManager.insert(kinou);
        }
    }

    @Transactional
    public void createTestL0022_02(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null == kinouMode ) {

                kinouMode = kinou.createKinouMode();
                kinouMode.setKinouModeId(ALREADYKINOUMODEID);
                kinouMode.setKinouModeNm(ALREADYKINOUMODENM);
                kinouMode.setSortNo(Integer.parseInt(ALREADYKINOUMODESORTNO));
                kinouMode.setYuukouKbn(ALREADYYUUKOUKBN);
                kinouMode.setKadouTimeGroupCd(ALREADYKADOUTIMEGROUPCD);
                kinouMode.setBatchHeisouKahiKbn(ALREADYBATCHHEISOUKAHIKBN);

                baseDomManager.update(kinou);
            }
        }
    }

    @Transactional
    public void createTestL0022_03(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null != kinouMode ) {

                AS_KinouModeSiborikomi kinouModeSiborikomi1 = kinouMode.getKinouModoSiborikomi(ALREADYKINOUMODESIBORIKOMIID1);
                if ( null == kinouModeSiborikomi1 ) {

                    kinouModeSiborikomi1 = kinouMode.createKinouModeSiborikomi();
                    kinouModeSiborikomi1.setSiborikomiId(ALREADYKINOUMODESIBORIKOMIID1);
                    kinouModeSiborikomi1.setSiborikomiNm(ALREADYKINOUMODESIBORIKOMINM1);

                    baseDomManager.update(kinou);
                }

                AS_KinouModeSiborikomi kinouModeSiborikomi2 = kinouMode.getKinouModoSiborikomi(ALREADYKINOUMODESIBORIKOMIID2);
                if ( null == kinouModeSiborikomi2 ) {

                    kinouModeSiborikomi2 = kinouMode.createKinouModeSiborikomi();
                    kinouModeSiborikomi2.setSiborikomiId(ALREADYKINOUMODESIBORIKOMIID2);
                    kinouModeSiborikomi2.setSiborikomiNm(ALREADYKINOUMODESIBORIKOMINM2);

                    baseDomManager.update(kinou);
                }
            }
        }
    }

    @Transactional
    public void deleteTestL0022_01(){

        baseDomManager.clear();
        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null != kinouMode ) {

                kinouMode.getKinouModeSiborikomis().removeAll(kinouMode.getKinouModeSiborikomis());
            }

            kinou.getKinouModes().removeAll(kinou.getKinouModes());

            baseDomManager.update(kinou);
            baseDomManager.delete(kinou);
        }
    }

    @Transactional
    public void createTestL0023_01(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null == kinou ) {

            kinou = new AS_Kinou();
            kinou.setKinouId(ALREADYKINOUID);
            kinou.setSubSystemId(ALREADYSUBSYSTEMID);
            kinou.setCategoryId(ALREADYCATEGORYID);
            kinou.setKinouNm(ALREADYKINOUNM);
            kinou.setSortNo(Integer.parseInt(ALREADYSORTNO));
            kinou.setKinouKbn(ALREADYKINOUKBN);
            kinou.setBatchKyouseiSyuuryouFlag(ALREADYBATCHKYOUSEISYUURYOUFLAG);
            kinou.setMenuHyoujiKahi(ALREADYMENUHYOUJIKBN);
            kinou.setBatchLogHyoujiKbn(ALREADYBATCHLOGHYOUJIKBN);
            kinou.setKidouKengenHanteiYouhiKbn(ALREADYKINOUGENKENHANTEIYOUHIKBN);
            kinou.setKinouTeigiTaisyouKbn(ALREADYKINOUTEIGITAISYOUKBN);

            baseDomManager.insert(kinou);
        }
    }

    @Transactional
    public void createTestL0023_02(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null == kinouMode ) {

                kinouMode = kinou.createKinouMode();
                kinouMode.setKinouModeId(ALREADYKINOUMODEID);
                kinouMode.setKinouModeNm(ALREADYKINOUMODENM);
                kinouMode.setSortNo(Integer.parseInt(ALREADYKINOUMODESORTNO));
                kinouMode.setYuukouKbn(ALREADYYUUKOUKBN);
                kinouMode.setKadouTimeGroupCd(ALREADYKADOUTIMEGROUPCD);
                kinouMode.setBatchHeisouKahiKbn(ALREADYBATCHHEISOUKAHIKBN);

                baseDomManager.update(kinou);
            }
        }
    }

    @Transactional
    public void createTestL0023_03(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null != kinouMode ) {

                AS_KinouModeSiborikomi kinouModeSiborikomi1 = kinouMode.getKinouModoSiborikomi(ALREADYKINOUMODESIBORIKOMIID1);
                if ( null == kinouModeSiborikomi1 ) {

                    kinouModeSiborikomi1 = kinouMode.createKinouModeSiborikomi();
                    kinouModeSiborikomi1.setSiborikomiId(ALREADYKINOUMODESIBORIKOMIID1);
                    kinouModeSiborikomi1.setSiborikomiNm(ALREADYKINOUMODESIBORIKOMINM1);

                    baseDomManager.update(kinou);
                }

                AS_KinouModeSiborikomi kinouModeSiborikomi2 = kinouMode.getKinouModoSiborikomi(ALREADYKINOUMODESIBORIKOMIID2);
                if ( null == kinouModeSiborikomi2 ) {

                    kinouModeSiborikomi2 = kinouMode.createKinouModeSiborikomi();
                    kinouModeSiborikomi2.setSiborikomiId(ALREADYKINOUMODESIBORIKOMIID2);
                    kinouModeSiborikomi2.setSiborikomiNm(ALREADYKINOUMODESIBORIKOMINM2);

                    baseDomManager.update(kinou);
                }
            }
        }
    }

    @Transactional
    public void createTestL0023_04(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null != kinouMode ) {

                AS_KinouModeSiborikomi kinouModeSiborikomi = kinouMode.getKinouModoSiborikomi(ALREADYKINOUMODESIBORIKOMIID1);
                if ( null != kinouModeSiborikomi ) {

                    AT_KinouKengen kinouKengen = kinouMode.getKinouKengen(ALREADYKINOUKENGENROLECD);
                    if ( null == kinouKengen ) {

                        kinouKengen = kinouMode.createKinouKengen();
                        kinouKengen.setRoleCd(ALREADYKINOUKENGENROLECD);
                        kinouKengen.setSiborikomiId(ALREADYKINOUMODESIBORIKOMIID1);

                        baseDomManager.update(kinou);
                    }
                }
            }
        }
    }

    @Transactional
    public void deleteTestL0023_01(){

        baseDomManager.clear();
        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null != kinouMode ) {

                kinouMode.getKinouModeSiborikomis().removeAll(kinouMode.getKinouModeSiborikomis());
                kinouMode.getKinouKengens().removeAll(kinouMode.getKinouKengens());
            }

            kinou.getKinouModes().removeAll(kinou.getKinouModes());

            baseDomManager.update(kinou);
            baseDomManager.delete(kinou);
        }
    }

    @Transactional
    public void createTestL0024_01(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null == kinou ) {

            kinou = new AS_Kinou();
            kinou.setKinouId(ALREADYKINOUID);
            kinou.setSubSystemId(ALREADYSUBSYSTEMID);
            kinou.setCategoryId(ALREADYCATEGORYID);
            kinou.setKinouNm(ALREADYKINOUNM);
            kinou.setSortNo(Integer.parseInt(ALREADYSORTNO));
            kinou.setKinouKbn(ALREADYKINOUKBN);
            kinou.setBatchKyouseiSyuuryouFlag(ALREADYBATCHKYOUSEISYUURYOUFLAG);
            kinou.setMenuHyoujiKahi(ALREADYMENUHYOUJIKBN);
            kinou.setBatchLogHyoujiKbn(ALREADYBATCHLOGHYOUJIKBN);
            kinou.setKidouKengenHanteiYouhiKbn(ALREADYKINOUGENKENHANTEIYOUHIKBN);
            kinou.setKinouTeigiTaisyouKbn(ALREADYKINOUTEIGITAISYOUKBN);

            baseDomManager.insert(kinou);
        }
    }

    @Transactional
    public void createTestL0024_02(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null == kinouMode ) {

                kinouMode = kinou.createKinouMode();
                kinouMode.setKinouModeId(ALREADYKINOUMODEID);
                kinouMode.setKinouModeNm(ALREADYKINOUMODENM);
                kinouMode.setSortNo(Integer.parseInt(ALREADYKINOUMODESORTNO));
                kinouMode.setYuukouKbn(ALREADYYUUKOUKBN);
                kinouMode.setKadouTimeGroupCd(ALREADYKADOUTIMEGROUPCD);
                kinouMode.setBatchHeisouKahiKbn(ALREADYBATCHHEISOUKAHIKBN);

                baseDomManager.update(kinou);
            }
        }
    }

    @Transactional
    public void createTestL0024_03(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null != kinouMode ) {

                AS_KinouModeSiborikomi kinouModeSiborikomi1 = kinouMode.getKinouModoSiborikomi(ALREADYKINOUMODESIBORIKOMIID1);
                if ( null == kinouModeSiborikomi1 ) {

                    kinouModeSiborikomi1 = kinouMode.createKinouModeSiborikomi();
                    kinouModeSiborikomi1.setSiborikomiId(ALREADYKINOUMODESIBORIKOMIID1);
                    kinouModeSiborikomi1.setSiborikomiNm(ALREADYKINOUMODESIBORIKOMINM1);

                    baseDomManager.update(kinou);
                }

                AS_KinouModeSiborikomi kinouModeSiborikomi2 = kinouMode.getKinouModoSiborikomi(ALREADYKINOUMODESIBORIKOMIID2);
                if ( null == kinouModeSiborikomi2 ) {

                    kinouModeSiborikomi2 = kinouMode.createKinouModeSiborikomi();
                    kinouModeSiborikomi2.setSiborikomiId(ALREADYKINOUMODESIBORIKOMIID2);
                    kinouModeSiborikomi2.setSiborikomiNm(ALREADYKINOUMODESIBORIKOMINM2);

                    baseDomManager.update(kinou);
                }
            }
        }
    }

    @Transactional
    public void createTestL0024_04(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null != kinouMode ) {

                AS_KinouModeSiborikomi kinouModeSiborikomi = kinouMode.getKinouModoSiborikomi(ALREADYKINOUMODESIBORIKOMIID1);
                if ( null != kinouModeSiborikomi ) {

                    AT_KinouKengen kinouKengen = kinouMode.getKinouKengen(ALREADYKINOUKENGENROLECD);
                    if ( null == kinouKengen ) {

                        kinouKengen = kinouMode.createKinouKengen();
                        kinouKengen.setRoleCd(ALREADYKINOUKENGENROLECD);
                        kinouKengen.setSiborikomiId(ALREADYKINOUMODESIBORIKOMIID1);

                        baseDomManager.update(kinou);
                    }
                }
            }
        }
    }

    @Transactional
    public void deleteTestL0024_01(){

        baseDomManager.clear();
        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null != kinouMode ) {

                kinouMode.getKinouModeSiborikomis().removeAll(kinouMode.getKinouModeSiborikomis());
                kinouMode.getKinouKengens().removeAll(kinouMode.getKinouKengens());
            }

            kinou.getKinouModes().removeAll(kinou.getKinouModes());

            baseDomManager.update(kinou);
            baseDomManager.delete(kinou);
        }
    }

    @Transactional
    public void createTestL0025_01(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null == kinou ) {

            kinou = new AS_Kinou();
            kinou.setKinouId(ALREADYKINOUID);
            kinou.setSubSystemId(ALREADYSUBSYSTEMID);
            kinou.setCategoryId(ALREADYCATEGORYID);
            kinou.setKinouNm(ALREADYKINOUNM);
            kinou.setSortNo(Integer.parseInt(ALREADYSORTNO));
            kinou.setKinouKbn(ALREADYKINOUKBN);
            kinou.setBatchKyouseiSyuuryouFlag(ALREADYBATCHKYOUSEISYUURYOUFLAG);
            kinou.setMenuHyoujiKahi(ALREADYMENUHYOUJIKBN);
            kinou.setBatchLogHyoujiKbn(ALREADYBATCHLOGHYOUJIKBN);
            kinou.setKidouKengenHanteiYouhiKbn(ALREADYKINOUGENKENHANTEIYOUHIKBN);
            kinou.setKinouTeigiTaisyouKbn(ALREADYKINOUTEIGITAISYOUKBN);

            baseDomManager.insert(kinou);
        }
    }

    @Transactional
    public void createTestL0025_02(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null == kinouMode ) {

                kinouMode = kinou.createKinouMode();
                kinouMode.setKinouModeId(ALREADYKINOUMODEID);
                kinouMode.setKinouModeNm(ALREADYKINOUMODENM);
                kinouMode.setSortNo(Integer.parseInt(ALREADYKINOUMODESORTNO));
                kinouMode.setYuukouKbn(ALREADYYUUKOUKBN);
                kinouMode.setKadouTimeGroupCd(ALREADYKADOUTIMEGROUPCD);
                kinouMode.setBatchHeisouKahiKbn(ALREADYBATCHHEISOUKAHIKBN);

                baseDomManager.update(kinou);
            }
        }
    }

    @Transactional
    public void createTestL0025_03(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null != kinouMode ) {

                AS_KinouModeSiborikomi kinouModeSiborikomi1 = kinouMode.getKinouModoSiborikomi(ALREADYKINOUMODESIBORIKOMIID1);
                if ( null == kinouModeSiborikomi1 ) {

                    kinouModeSiborikomi1 = kinouMode.createKinouModeSiborikomi();
                    kinouModeSiborikomi1.setSiborikomiId(ALREADYKINOUMODESIBORIKOMIID1);
                    kinouModeSiborikomi1.setSiborikomiNm(ALREADYKINOUMODESIBORIKOMINM1);

                    baseDomManager.update(kinou);
                }

                AS_KinouModeSiborikomi kinouModeSiborikomi2 = kinouMode.getKinouModoSiborikomi(ALREADYKINOUMODESIBORIKOMIID2);
                if ( null == kinouModeSiborikomi2 ) {

                    kinouModeSiborikomi2 = kinouMode.createKinouModeSiborikomi();
                    kinouModeSiborikomi2.setSiborikomiId(ALREADYKINOUMODESIBORIKOMIID2);
                    kinouModeSiborikomi2.setSiborikomiNm(ALREADYKINOUMODESIBORIKOMINM2);

                    baseDomManager.update(kinou);
                }
            }
        }
    }

    @Transactional
    public void createTestL0025_04(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null != kinouMode ) {

                AS_KinouModeSiborikomi kinouModeSiborikomi = kinouMode.getKinouModoSiborikomi(ALREADYKINOUMODESIBORIKOMIID1);
                if ( null != kinouModeSiborikomi ) {

                    AT_KinouKengen kinouKengen = kinouMode.getKinouKengen(ALREADYKINOUKENGENROLECD);
                    if ( null == kinouKengen ) {

                        kinouKengen = kinouMode.createKinouKengen();
                        kinouKengen.setRoleCd(ALREADYKINOUKENGENROLECD);
                        kinouKengen.setSiborikomiId(ALREADYKINOUMODESIBORIKOMIID1);

                        baseDomManager.update(kinou);
                    }
                }
            }
        }
    }

    @Transactional
    public void deleteTestL0025_01(){

        baseDomManager.clear();
        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null != kinouMode ) {

                kinouMode.getKinouModeSiborikomis().removeAll(kinouMode.getKinouModeSiborikomis());
                kinouMode.getKinouKengens().removeAll(kinouMode.getKinouKengens());
            }

            kinou.getKinouModes().removeAll(kinou.getKinouModes());

            baseDomManager.update(kinou);
            baseDomManager.delete(kinou);
        }
    }

    @Transactional
    public void createTestL0026_01(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null == kinou ) {

            kinou = new AS_Kinou();
            kinou.setKinouId(ALREADYKINOUID);
            kinou.setSubSystemId(ALREADYSUBSYSTEMID);
            kinou.setCategoryId(ALREADYCATEGORYID);
            kinou.setKinouNm(ALREADYKINOUNM);
            kinou.setSortNo(Integer.parseInt(ALREADYSORTNO));
            kinou.setKinouKbn(ALREADYKINOUKBN);
            kinou.setBatchKyouseiSyuuryouFlag(ALREADYBATCHKYOUSEISYUURYOUFLAG);
            kinou.setMenuHyoujiKahi(ALREADYMENUHYOUJIKBN);
            kinou.setBatchLogHyoujiKbn(ALREADYBATCHLOGHYOUJIKBN);
            kinou.setKidouKengenHanteiYouhiKbn(ALREADYKINOUGENKENHANTEIYOUHIKBN);
            kinou.setKinouTeigiTaisyouKbn(ALREADYKINOUTEIGITAISYOUKBN);

            baseDomManager.insert(kinou);
        }
    }

    @Transactional
    public void createTestL0026_02(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null == kinouMode ) {

                kinouMode = kinou.createKinouMode();
                kinouMode.setKinouModeId(ALREADYKINOUMODEID);
                kinouMode.setKinouModeNm(ALREADYKINOUMODENM);
                kinouMode.setSortNo(Integer.parseInt(ALREADYKINOUMODESORTNO));
                kinouMode.setYuukouKbn(ALREADYYUUKOUKBN);
                kinouMode.setKadouTimeGroupCd(ALREADYKADOUTIMEGROUPCD);
                kinouMode.setBatchHeisouKahiKbn(ALREADYBATCHHEISOUKAHIKBN);

                baseDomManager.update(kinou);
            }
        }
    }

    @Transactional
    public void createTestL0026_03(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null != kinouMode ) {

                AS_KinouModeSiborikomi kinouModeSiborikomi1 = kinouMode.getKinouModoSiborikomi(ALREADYKINOUMODESIBORIKOMIID1);
                if ( null == kinouModeSiborikomi1 ) {

                    kinouModeSiborikomi1 = kinouMode.createKinouModeSiborikomi();
                    kinouModeSiborikomi1.setSiborikomiId(ALREADYKINOUMODESIBORIKOMIID1);
                    kinouModeSiborikomi1.setSiborikomiNm(ALREADYKINOUMODESIBORIKOMINM1);

                    baseDomManager.update(kinou);
                }

                AS_KinouModeSiborikomi kinouModeSiborikomi2 = kinouMode.getKinouModoSiborikomi(ALREADYKINOUMODESIBORIKOMIID2);
                if ( null == kinouModeSiborikomi2 ) {

                    kinouModeSiborikomi2 = kinouMode.createKinouModeSiborikomi();
                    kinouModeSiborikomi2.setSiborikomiId(ALREADYKINOUMODESIBORIKOMIID2);
                    kinouModeSiborikomi2.setSiborikomiNm(ALREADYKINOUMODESIBORIKOMINM2);

                    baseDomManager.update(kinou);
                }
            }
        }
    }

    @Transactional
    public void createTestL0026_04(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null != kinouMode ) {

                AS_KinouModeSiborikomi kinouModeSiborikomi = kinouMode.getKinouModoSiborikomi(ALREADYKINOUMODESIBORIKOMIID1);
                if ( null != kinouModeSiborikomi ) {

                    AT_KinouKengen kinouKengen = kinouMode.getKinouKengen(ALREADYKINOUKENGENROLECD);
                    if ( null == kinouKengen ) {

                        kinouKengen = kinouMode.createKinouKengen();
                        kinouKengen.setRoleCd(ALREADYKINOUKENGENROLECD);
                        kinouKengen.setSiborikomiId(ALREADYKINOUMODESIBORIKOMIID1);

                        baseDomManager.update(kinou);
                    }
                }
            }
        }
    }

    @Transactional
    public void deleteTestL0026_01(){

        baseDomManager.clear();
        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null != kinouMode ) {

                kinouMode.getKinouModeSiborikomis().removeAll(kinouMode.getKinouModeSiborikomis());
                kinouMode.getKinouKengens().removeAll(kinouMode.getKinouKengens());
            }

            kinou.getKinouModes().removeAll(kinou.getKinouModes());

            baseDomManager.update(kinou);
            baseDomManager.delete(kinou);
        }
    }

    @Transactional
    public void createTestL0027_01(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null == kinou ) {

            kinou = new AS_Kinou();
            kinou.setKinouId(ALREADYKINOUID);
            kinou.setSubSystemId(ALREADYSUBSYSTEMID);
            kinou.setCategoryId(ALREADYCATEGORYID);
            kinou.setKinouNm(ALREADYKINOUNM);
            kinou.setSortNo(Integer.parseInt(ALREADYSORTNO));
            kinou.setKinouKbn(ALREADYKINOUKBN);
            kinou.setBatchKyouseiSyuuryouFlag(ALREADYBATCHKYOUSEISYUURYOUFLAG);
            kinou.setMenuHyoujiKahi(ALREADYMENUHYOUJIKBN);
            kinou.setBatchLogHyoujiKbn(ALREADYBATCHLOGHYOUJIKBN);
            kinou.setKidouKengenHanteiYouhiKbn(ALREADYKINOUGENKENHANTEIYOUHIKBN);
            kinou.setKinouTeigiTaisyouKbn(ALREADYKINOUTEIGITAISYOUKBN);

            baseDomManager.insert(kinou);
        }
    }

    @Transactional
    public void createTestL0027_02(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null == kinouMode ) {

                kinouMode = kinou.createKinouMode();
                kinouMode.setKinouModeId(ALREADYKINOUMODEID);
                kinouMode.setKinouModeNm(ALREADYKINOUMODENM);
                kinouMode.setSortNo(Integer.parseInt(ALREADYKINOUMODESORTNO));
                kinouMode.setYuukouKbn(ALREADYYUUKOUKBN);
                kinouMode.setKadouTimeGroupCd(ALREADYKADOUTIMEGROUPCD);
                kinouMode.setBatchHeisouKahiKbn(ALREADYBATCHHEISOUKAHIKBN);

                baseDomManager.update(kinou);
            }
        }
    }

    @Transactional
    public void createTestL0027_03(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null != kinouMode ) {

                AS_KinouModeSiborikomi kinouModeSiborikomi1 = kinouMode.getKinouModoSiborikomi(ALREADYKINOUMODESIBORIKOMIID1);
                if ( null == kinouModeSiborikomi1 ) {

                    kinouModeSiborikomi1 = kinouMode.createKinouModeSiborikomi();
                    kinouModeSiborikomi1.setSiborikomiId(ALREADYKINOUMODESIBORIKOMIID1);
                    kinouModeSiborikomi1.setSiborikomiNm(ALREADYKINOUMODESIBORIKOMINM1);

                    baseDomManager.update(kinou);
                }

                AS_KinouModeSiborikomi kinouModeSiborikomi2 = kinouMode.getKinouModoSiborikomi(ALREADYKINOUMODESIBORIKOMIID2);
                if ( null == kinouModeSiborikomi2 ) {

                    kinouModeSiborikomi2 = kinouMode.createKinouModeSiborikomi();
                    kinouModeSiborikomi2.setSiborikomiId(ALREADYKINOUMODESIBORIKOMIID2);
                    kinouModeSiborikomi2.setSiborikomiNm(ALREADYKINOUMODESIBORIKOMINM2);

                    baseDomManager.update(kinou);
                }
            }
        }
    }

    @Transactional
    public void createTestL0027_04(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null != kinouMode ) {

                AS_KinouModeSiborikomi kinouModeSiborikomi = kinouMode.getKinouModoSiborikomi(ALREADYKINOUMODESIBORIKOMIID1);
                if ( null != kinouModeSiborikomi ) {

                    AT_KinouKengen kinouKengen = kinouMode.getKinouKengen(ALREADYKINOUKENGENROLECD);
                    if ( null == kinouKengen ) {

                        kinouKengen = kinouMode.createKinouKengen();
                        kinouKengen.setRoleCd(ALREADYKINOUKENGENROLECD);
                        kinouKengen.setSiborikomiId(ALREADYKINOUMODESIBORIKOMIID1);

                        baseDomManager.update(kinou);
                    }
                }
            }
        }
    }

    @Transactional
    public void deleteTestL0027_01(){

        baseDomManager.clear();
        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null != kinouMode ) {

                kinouMode.getKinouModeSiborikomis().removeAll(kinouMode.getKinouModeSiborikomis());
                kinouMode.getKinouKengens().removeAll(kinouMode.getKinouKengens());
            }

            kinou.getKinouModes().removeAll(kinou.getKinouModes());

            baseDomManager.update(kinou);
            baseDomManager.delete(kinou);
        }
    }

    @Transactional
    public void createTestL0028_01(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null == kinou ) {

            kinou = new AS_Kinou();
            kinou.setKinouId(ALREADYKINOUID);
            kinou.setSubSystemId(ALREADYSUBSYSTEMID);
            kinou.setCategoryId(ALREADYCATEGORYID);
            kinou.setKinouNm(ALREADYKINOUNM);
            kinou.setSortNo(Integer.parseInt(ALREADYSORTNO));
            kinou.setKinouKbn(ALREADYKINOUKBN);
            kinou.setBatchKyouseiSyuuryouFlag(ALREADYBATCHKYOUSEISYUURYOUFLAG);
            kinou.setMenuHyoujiKahi(ALREADYMENUHYOUJIKBN);
            kinou.setBatchLogHyoujiKbn(ALREADYBATCHLOGHYOUJIKBN);
            kinou.setKidouKengenHanteiYouhiKbn(ALREADYKINOUGENKENHANTEIYOUHIKBN);
            kinou.setKinouTeigiTaisyouKbn(ALREADYKINOUTEIGITAISYOUKBN);

            baseDomManager.insert(kinou);
        }
    }

    @Transactional
    public void createTestL0028_02(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null == kinouMode ) {

                kinouMode = kinou.createKinouMode();
                kinouMode.setKinouModeId(ALREADYKINOUMODEID);
                kinouMode.setKinouModeNm(ALREADYKINOUMODENM);
                kinouMode.setSortNo(Integer.parseInt(ALREADYKINOUMODESORTNO));
                kinouMode.setYuukouKbn(ALREADYYUUKOUKBN);
                kinouMode.setKadouTimeGroupCd(ALREADYKADOUTIMEGROUPCD);
                kinouMode.setBatchHeisouKahiKbn(ALREADYBATCHHEISOUKAHIKBN);

                baseDomManager.update(kinou);
            }
        }
    }

    @Transactional
    public void createTestL0028_03(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null != kinouMode ) {

                AS_KinouModeSiborikomi kinouModeSiborikomi1 = kinouMode.getKinouModoSiborikomi(ALREADYKINOUMODESIBORIKOMIID1);
                if ( null == kinouModeSiborikomi1 ) {

                    kinouModeSiborikomi1 = kinouMode.createKinouModeSiborikomi();
                    kinouModeSiborikomi1.setSiborikomiId(ALREADYKINOUMODESIBORIKOMIID1);
                    kinouModeSiborikomi1.setSiborikomiNm(ALREADYKINOUMODESIBORIKOMINM1);

                    baseDomManager.update(kinou);
                }

                AS_KinouModeSiborikomi kinouModeSiborikomi2 = kinouMode.getKinouModoSiborikomi(ALREADYKINOUMODESIBORIKOMIID2);
                if ( null == kinouModeSiborikomi2 ) {

                    kinouModeSiborikomi2 = kinouMode.createKinouModeSiborikomi();
                    kinouModeSiborikomi2.setSiborikomiId(ALREADYKINOUMODESIBORIKOMIID2);
                    kinouModeSiborikomi2.setSiborikomiNm(ALREADYKINOUMODESIBORIKOMINM2);

                    baseDomManager.update(kinou);
                }
            }
        }
    }

    @Transactional
    public void createTestL0028_04(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null != kinouMode ) {

                AS_KinouModeSiborikomi kinouModeSiborikomi = kinouMode.getKinouModoSiborikomi(ALREADYKINOUMODESIBORIKOMIID1);
                if ( null != kinouModeSiborikomi ) {

                    AT_KinouKengen kinouKengen = kinouMode.getKinouKengen(ALREADYKINOUKENGENROLECD);
                    if ( null == kinouKengen ) {

                        kinouKengen = kinouMode.createKinouKengen();
                        kinouKengen.setRoleCd(ALREADYKINOUKENGENROLECD);
                        kinouKengen.setSiborikomiId(ALREADYKINOUMODESIBORIKOMIID1);

                        baseDomManager.update(kinou);
                    }
                }
            }
        }
    }

    @Transactional
    public void deleteTestL0028_01(){

        baseDomManager.clear();
        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null != kinouMode ) {

                kinouMode.getKinouModeSiborikomis().removeAll(kinouMode.getKinouModeSiborikomis());
                kinouMode.getKinouKengens().removeAll(kinouMode.getKinouKengens());
            }

            kinou.getKinouModes().removeAll(kinou.getKinouModes());

            baseDomManager.update(kinou);
            baseDomManager.delete(kinou);
        }
    }

    @Transactional
    public void createTestL0029_01(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null == kinou ) {

            kinou = new AS_Kinou();
            kinou.setKinouId(ALREADYKINOUID);
            kinou.setSubSystemId(ALREADYSUBSYSTEMID);
            kinou.setCategoryId(ALREADYCATEGORYID);
            kinou.setKinouNm(ALREADYKINOUNM);
            kinou.setSortNo(Integer.parseInt(ALREADYSORTNO));
            kinou.setKinouKbn(ALREADYKINOUKBN);
            kinou.setBatchKyouseiSyuuryouFlag(ALREADYBATCHKYOUSEISYUURYOUFLAG);
            kinou.setMenuHyoujiKahi(ALREADYMENUHYOUJIKBN);
            kinou.setBatchLogHyoujiKbn(ALREADYBATCHLOGHYOUJIKBN);
            kinou.setKidouKengenHanteiYouhiKbn(ALREADYKINOUGENKENHANTEIYOUHIKBN);
            kinou.setKinouTeigiTaisyouKbn(ALREADYKINOUTEIGITAISYOUKBN);

            baseDomManager.insert(kinou);
        }
    }

    @Transactional
    public void createTestL0029_02(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null == kinouMode ) {

                kinouMode = kinou.createKinouMode();
                kinouMode.setKinouModeId(ALREADYKINOUMODEID);
                kinouMode.setKinouModeNm(ALREADYKINOUMODENM);
                kinouMode.setSortNo(Integer.parseInt(ALREADYKINOUMODESORTNO));
                kinouMode.setYuukouKbn(ALREADYYUUKOUKBN);
                kinouMode.setKadouTimeGroupCd(ALREADYKADOUTIMEGROUPCD);
                kinouMode.setBatchHeisouKahiKbn(ALREADYBATCHHEISOUKAHIKBN);

                baseDomManager.update(kinou);
            }
        }
    }

    @Transactional
    public void createTestL0029_03(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null != kinouMode ) {

                AS_KinouModeSiborikomi kinouModeSiborikomi1 = kinouMode.getKinouModoSiborikomi(ALREADYKINOUMODESIBORIKOMIID1);
                if ( null == kinouModeSiborikomi1 ) {

                    kinouModeSiborikomi1 = kinouMode.createKinouModeSiborikomi();
                    kinouModeSiborikomi1.setSiborikomiId(ALREADYKINOUMODESIBORIKOMIID1);
                    kinouModeSiborikomi1.setSiborikomiNm(ALREADYKINOUMODESIBORIKOMINM1);

                    baseDomManager.update(kinou);
                }

                AS_KinouModeSiborikomi kinouModeSiborikomi2 = kinouMode.getKinouModoSiborikomi(ALREADYKINOUMODESIBORIKOMIID2);
                if ( null == kinouModeSiborikomi2 ) {

                    kinouModeSiborikomi2 = kinouMode.createKinouModeSiborikomi();
                    kinouModeSiborikomi2.setSiborikomiId(ALREADYKINOUMODESIBORIKOMIID2);
                    kinouModeSiborikomi2.setSiborikomiNm(ALREADYKINOUMODESIBORIKOMINM2);

                    baseDomManager.update(kinou);
                }
            }
        }
    }

    @Transactional
    public void createTestL0029_04(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null != kinouMode ) {

                AS_KinouModeSiborikomi kinouModeSiborikomi = kinouMode.getKinouModoSiborikomi(ALREADYKINOUMODESIBORIKOMIID1);
                if ( null != kinouModeSiborikomi ) {

                    AT_KinouKengen kinouKengen = kinouMode.getKinouKengen(ALREADYKINOUKENGENROLECD);
                    if ( null == kinouKengen ) {

                        kinouKengen = kinouMode.createKinouKengen();
                        kinouKengen.setRoleCd(ALREADYKINOUKENGENROLECD);
                        kinouKengen.setSiborikomiId(ALREADYKINOUMODESIBORIKOMIID1);

                        baseDomManager.update(kinou);
                    }
                }
            }
        }
    }

    @Transactional
    public void deleteTestL0029_01(){

        baseDomManager.clear();
        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null != kinouMode ) {

                kinouMode.getKinouModeSiborikomis().removeAll(kinouMode.getKinouModeSiborikomis());
                kinouMode.getKinouKengens().removeAll(kinouMode.getKinouKengens());
            }

            kinou.getKinouModes().removeAll(kinou.getKinouModes());

            baseDomManager.update(kinou);
            baseDomManager.delete(kinou);
        }
    }

    @Transactional
    public void createTestL0030_01(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null == kinou ) {

            kinou = new AS_Kinou();
            kinou.setKinouId(ALREADYKINOUID);
            kinou.setSubSystemId(ALREADYSUBSYSTEMID);
            kinou.setCategoryId(ALREADYCATEGORYID);
            kinou.setKinouNm(ALREADYKINOUNM);
            kinou.setSortNo(Integer.parseInt(ALREADYSORTNO));
            kinou.setKinouKbn(ALREADYKINOUKBN);
            kinou.setBatchKyouseiSyuuryouFlag(ALREADYBATCHKYOUSEISYUURYOUFLAG);
            kinou.setMenuHyoujiKahi(ALREADYMENUHYOUJIKBN);
            kinou.setBatchLogHyoujiKbn(ALREADYBATCHLOGHYOUJIKBN);
            kinou.setKidouKengenHanteiYouhiKbn(ALREADYKINOUGENKENHANTEIYOUHIKBN);
            kinou.setKinouTeigiTaisyouKbn(ALREADYKINOUTEIGITAISYOUKBN);

            baseDomManager.insert(kinou);
        }
    }

    @Transactional
    public void createTestL0030_02(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null == kinouMode ) {

                kinouMode = kinou.createKinouMode();
                kinouMode.setKinouModeId(ALREADYKINOUMODEID);
                kinouMode.setKinouModeNm(ALREADYKINOUMODENM);
                kinouMode.setSortNo(Integer.parseInt(ALREADYKINOUMODESORTNO));
                kinouMode.setYuukouKbn(ALREADYYUUKOUKBN);
                kinouMode.setKadouTimeGroupCd(ALREADYKADOUTIMEGROUPCD);
                kinouMode.setBatchHeisouKahiKbn(ALREADYBATCHHEISOUKAHIKBN);

                baseDomManager.update(kinou);
            }
        }
    }

    @Transactional
    public void createTestL0030_03(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null != kinouMode ) {

                AS_KinouModeSiborikomi kinouModeSiborikomi1 = kinouMode.getKinouModoSiborikomi(ALREADYKINOUMODESIBORIKOMIID1);
                if ( null == kinouModeSiborikomi1 ) {

                    kinouModeSiborikomi1 = kinouMode.createKinouModeSiborikomi();
                    kinouModeSiborikomi1.setSiborikomiId(ALREADYKINOUMODESIBORIKOMIID1);
                    kinouModeSiborikomi1.setSiborikomiNm(ALREADYKINOUMODESIBORIKOMINM1);

                    baseDomManager.update(kinou);
                }

                AS_KinouModeSiborikomi kinouModeSiborikomi2 = kinouMode.getKinouModoSiborikomi(ALREADYKINOUMODESIBORIKOMIID2);
                if ( null == kinouModeSiborikomi2 ) {

                    kinouModeSiborikomi2 = kinouMode.createKinouModeSiborikomi();
                    kinouModeSiborikomi2.setSiborikomiId(ALREADYKINOUMODESIBORIKOMIID2);
                    kinouModeSiborikomi2.setSiborikomiNm(ALREADYKINOUMODESIBORIKOMINM2);

                    baseDomManager.update(kinou);
                }
            }
        }
    }

    @Transactional
    public void createTestL0030_04(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null != kinouMode ) {

                AS_KinouModeSiborikomi kinouModeSiborikomi = kinouMode.getKinouModoSiborikomi(ALREADYKINOUMODESIBORIKOMIID1);
                if ( null != kinouModeSiborikomi ) {

                    AT_KinouKengen kinouKengen = kinouMode.getKinouKengen(ALREADYKINOUKENGENROLECD);
                    if ( null == kinouKengen ) {

                        kinouKengen = kinouMode.createKinouKengen();
                        kinouKengen.setRoleCd(ALREADYKINOUKENGENROLECD);
                        kinouKengen.setSiborikomiId(ALREADYKINOUMODESIBORIKOMIID1);

                        baseDomManager.update(kinou);
                    }
                }
            }
        }
    }

    @Transactional
    public void deleteTestL0030_01(){

        baseDomManager.clear();
        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null != kinouMode ) {

                kinouMode.getKinouModeSiborikomis().removeAll(kinouMode.getKinouModeSiborikomis());
                kinouMode.getKinouKengens().removeAll(kinouMode.getKinouKengens());
            }

            kinou.getKinouModes().removeAll(kinou.getKinouModes());

            baseDomManager.update(kinou);
            baseDomManager.delete(kinou);
        }
    }

    @Transactional
    public void createTestL0031_01(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null == kinou ) {

            kinou = new AS_Kinou();
            kinou.setKinouId(ALREADYKINOUID);
            kinou.setSubSystemId(ALREADYSUBSYSTEMID);
            kinou.setCategoryId(ALREADYCATEGORYID);
            kinou.setKinouNm(ALREADYKINOUNM);
            kinou.setSortNo(Integer.parseInt(ALREADYSORTNO));
            kinou.setKinouKbn(ALREADYKINOUKBN);
            kinou.setBatchKyouseiSyuuryouFlag(ALREADYBATCHKYOUSEISYUURYOUFLAG);
            kinou.setMenuHyoujiKahi(ALREADYMENUHYOUJIKBN);
            kinou.setBatchLogHyoujiKbn(ALREADYBATCHLOGHYOUJIKBN);
            kinou.setKidouKengenHanteiYouhiKbn(ALREADYKINOUGENKENHANTEIYOUHIKBN);
            kinou.setKinouTeigiTaisyouKbn(ALREADYKINOUTEIGITAISYOUKBN);

            baseDomManager.insert(kinou);
        }
    }

    @Transactional
    public void createTestL0031_02(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null == kinouMode ) {

                kinouMode = kinou.createKinouMode();
                kinouMode.setKinouModeId(ALREADYKINOUMODEID);
                kinouMode.setKinouModeNm(ALREADYKINOUMODENM);
                kinouMode.setSortNo(Integer.parseInt(ALREADYKINOUMODESORTNO));
                kinouMode.setYuukouKbn(ALREADYYUUKOUKBN);
                kinouMode.setKadouTimeGroupCd(ALREADYKADOUTIMEGROUPCD);
                kinouMode.setBatchHeisouKahiKbn(ALREADYBATCHHEISOUKAHIKBN);

                baseDomManager.update(kinou);
            }
        }
    }

    @Transactional
    public void createTestL0031_03(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null != kinouMode ) {

                AS_KinouModeSiborikomi kinouModeSiborikomi1 = kinouMode.getKinouModoSiborikomi(ALREADYKINOUMODESIBORIKOMIID1);
                if ( null == kinouModeSiborikomi1 ) {

                    kinouModeSiborikomi1 = kinouMode.createKinouModeSiborikomi();
                    kinouModeSiborikomi1.setSiborikomiId(ALREADYKINOUMODESIBORIKOMIID1);
                    kinouModeSiborikomi1.setSiborikomiNm(ALREADYKINOUMODESIBORIKOMINM1);

                    baseDomManager.update(kinou);
                }

                AS_KinouModeSiborikomi kinouModeSiborikomi2 = kinouMode.getKinouModoSiborikomi(ALREADYKINOUMODESIBORIKOMIID2);
                if ( null == kinouModeSiborikomi2 ) {

                    kinouModeSiborikomi2 = kinouMode.createKinouModeSiborikomi();
                    kinouModeSiborikomi2.setSiborikomiId(ALREADYKINOUMODESIBORIKOMIID2);
                    kinouModeSiborikomi2.setSiborikomiNm(ALREADYKINOUMODESIBORIKOMINM2);

                    baseDomManager.update(kinou);
                }
            }
        }
    }

    @Transactional
    public void deleteTestL0031_01(){

        baseDomManager.clear();
        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null != kinouMode ) {

                kinouMode.getKinouModeSiborikomis().removeAll(kinouMode.getKinouModeSiborikomis());
            }

            kinou.getKinouModes().removeAll(kinou.getKinouModes());

            baseDomManager.update(kinou);
            baseDomManager.delete(kinou);
        }
    }

    @Transactional
    public void createTestL0032_01(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null == kinou ) {

            kinou = new AS_Kinou();
            kinou.setKinouId(ALREADYKINOUID);
            kinou.setSubSystemId(ALREADYSUBSYSTEMID);
            kinou.setCategoryId(ALREADYCATEGORYID);
            kinou.setKinouNm(ALREADYKINOUNM);
            kinou.setSortNo(Integer.parseInt(ALREADYSORTNO));
            kinou.setKinouKbn(ALREADYKINOUKBN);
            kinou.setBatchKyouseiSyuuryouFlag(ALREADYBATCHKYOUSEISYUURYOUFLAG);
            kinou.setMenuHyoujiKahi(ALREADYMENUHYOUJIKBN);
            kinou.setBatchLogHyoujiKbn(ALREADYBATCHLOGHYOUJIKBN);
            kinou.setKidouKengenHanteiYouhiKbn(ALREADYKINOUGENKENHANTEIYOUHIKBN);
            kinou.setKinouTeigiTaisyouKbn(ALREADYKINOUTEIGITAISYOUKBN);

            baseDomManager.insert(kinou);
        }
    }

    @Transactional
    public void createTestL0032_02(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null == kinouMode ) {

                kinouMode = kinou.createKinouMode();
                kinouMode.setKinouModeId(ALREADYKINOUMODEID);
                kinouMode.setKinouModeNm(ALREADYKINOUMODENM);
                kinouMode.setSortNo(Integer.parseInt(ALREADYKINOUMODESORTNO));
                kinouMode.setYuukouKbn(ALREADYYUUKOUKBN);
                kinouMode.setKadouTimeGroupCd(ALREADYKADOUTIMEGROUPCD);
                kinouMode.setBatchHeisouKahiKbn(ALREADYBATCHHEISOUKAHIKBN);

                baseDomManager.update(kinou);
            }
        }
    }

    @Transactional
    public void createTestL0032_03(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null != kinouMode ) {

                AS_KinouModeSiborikomi kinouModeSiborikomi1 = kinouMode.getKinouModoSiborikomi(ALREADYKINOUMODESIBORIKOMIID1);
                if ( null == kinouModeSiborikomi1 ) {

                    kinouModeSiborikomi1 = kinouMode.createKinouModeSiborikomi();
                    kinouModeSiborikomi1.setSiborikomiId(ALREADYKINOUMODESIBORIKOMIID1);
                    kinouModeSiborikomi1.setSiborikomiNm(ALREADYKINOUMODESIBORIKOMINM1);

                    baseDomManager.update(kinou);
                }

                AS_KinouModeSiborikomi kinouModeSiborikomi2 = kinouMode.getKinouModoSiborikomi(ALREADYKINOUMODESIBORIKOMIID2);
                if ( null == kinouModeSiborikomi2 ) {

                    kinouModeSiborikomi2 = kinouMode.createKinouModeSiborikomi();
                    kinouModeSiborikomi2.setSiborikomiId(ALREADYKINOUMODESIBORIKOMIID2);
                    kinouModeSiborikomi2.setSiborikomiNm(ALREADYKINOUMODESIBORIKOMINM2);

                    baseDomManager.update(kinou);
                }
            }
        }
    }

    @Transactional
    public void createTestL0032_04(){

        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null != kinouMode ) {

                AS_KinouModeSiborikomi kinouModeSiborikomi = kinouMode.getKinouModoSiborikomi(ALREADYKINOUMODESIBORIKOMIID1);
                if ( null != kinouModeSiborikomi ) {

                    AT_KinouKengen kinouKengen = kinouMode.getKinouKengen(ALREADYKINOUKENGENROLECD);
                    if ( null == kinouKengen ) {

                        kinouKengen = kinouMode.createKinouKengen();
                        kinouKengen.setRoleCd(ALREADYKINOUKENGENROLECD);
                        kinouKengen.setSiborikomiId(ALREADYKINOUMODESIBORIKOMIID1);

                        baseDomManager.update(kinou);
                    }
                }
            }
        }
    }

    @Transactional
    public void deleteTestL0032_01(){

        baseDomManager.clear();
        AS_Kinou kinou = baseDomManager.getKinou(ALREADYKINOUID);
        if ( null != kinou ) {

            AS_KinouMode kinouMode = kinou.getKinouMode(ALREADYKINOUMODEID);
            if ( null != kinouMode ) {

                kinouMode.getKinouModeSiborikomis().removeAll(kinouMode.getKinouModeSiborikomis());
                kinouMode.getKinouKengens().removeAll(kinouMode.getKinouKengens());
            }

            kinou.getKinouModes().removeAll(kinou.getKinouModes());

            baseDomManager.update(kinou);
            baseDomManager.delete(kinou);
        }
    }
}
