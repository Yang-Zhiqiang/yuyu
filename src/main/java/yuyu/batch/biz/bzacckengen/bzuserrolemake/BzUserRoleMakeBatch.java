package yuyu.batch.biz.bzacckengen.bzuserrolemake;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.EntityUpdater;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.db.ExDBUpdatableResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.def.MessageId;
import yuyu.def.biz.configuration.YuyuBizConfig;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_IdCdKbn;
import yuyu.def.classification.C_KyokaKbn;
import yuyu.def.classification.C_PasswordYuukouKikanKbn;
import yuyu.def.classification.C_SpecialUserKbn;
import yuyu.def.classification.C_TanmatuSiyouKbn;
import yuyu.def.classification.C_YoukyuuKbn;
import yuyu.def.db.entity.AM_User;
import yuyu.def.db.entity.AT_UserRole;
import yuyu.def.db.entity.BW_IdCardWk;
import yuyu.def.db.entity.BW_UserRoleWk;
import yuyu.def.db.entity.BW_UserWk;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 業務共通 アクセス権限 ユーザー権限自動反映処理クラス
 */
public class BzUserRoleMakeBatch implements Batch {

    @Inject
    private BatchParam batchParam;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private BzUserRoleMakeDao bzUserRoleMakeDao;

    @Inject
    private BatchLogger batchLogger;

    private int userRoleWkInsertCount = 0;
    private int userWkInsertCount = 0;
    private int userWkUpdateCount = 0;
    private int userWkDeleteCount = 0;
    private int userRoleWkDeleteCount = 0;

    @Override
    public BatchParam getParam() {
        return batchParam;
    }

    @Execute
    public void execute() {

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016,
            "≪バッチ処理年月日≫", batchParam.getSyoriYmd().toString()));

        long count = bizDomManager.getIdCardWkCount();

        if (count == 0) {

            batchLogger.error(MessageUtil.getMessage(MessageId.EBA0024, "ＩＤカードマスタワークテーブルのデータ"));

            return;
        }

        try {
            bzUserRoleMakeDao.lockUserWk();
        } catch (Exception e) {
        }

        try {
            bzUserRoleMakeDao.lockUserRoleWk();
        } catch (Exception e) {
        }

        registUserRoleMakeData();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002,
            String.valueOf(userWkInsertCount), "ユーザーマスタワークテーブル　追加件数"));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002,
            String.valueOf(userWkUpdateCount), "ユーザーマスタワークテーブル　更新件数"));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002,
            String.valueOf(userWkDeleteCount), "ユーザーマスタワークテーブル　削除件数"));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002,
            String.valueOf(userRoleWkInsertCount), "ユーザーロールワークテーブル　追加件数"));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002,
            String.valueOf(userRoleWkDeleteCount), "ユーザーロールワークテーブル　削除件数"));
    }

    @Transactional
    void registUserRoleMakeData() {

        try (ExDBUpdatableResults<AM_User> userLst = bizDomManager.getUsersByTables()) {

            for (AM_User user : userLst) {

                List<AT_UserRole> userRoleLst = user.getUserRoles();

                List<BW_UserRoleWk> userRoleWkLst = bizDomManager.getUserRoleWksByUserId(user.getUserId());

                for (AT_UserRole userRole : userRoleLst) {

                    String roRukoDo = userRole.getRoleCd();
                    boolean tourokuFlg = true;

                    for (BW_UserRoleWk userRoleWk : userRoleWkLst) {

                        String waKuroRukoDo = userRoleWk.getRoleCd();

                        if (roRukoDo.equals(waKuroRukoDo)) {

                            tourokuFlg = false;
                        }
                    }

                    if (tourokuFlg == true) {

                        BW_UserRoleWk userRoleWktk = new BW_UserRoleWk();

                        userRoleWktk.setUserId(userRole.getUserId());
                        userRoleWktk.setRoleCd(userRole.getRoleCd());

                        BizPropertyInitializer.initialize(userRoleWktk);

                        bizDomManager.insert(userRoleWktk);

                        userRoleWkInsertCount++;
                    }
                }

                for (BW_UserRoleWk userRoleWk : userRoleWkLst) {

                    String waKuroRukoDo = userRoleWk.getRoleCd();
                    boolean sakujyoFlg = true;

                    for (AT_UserRole userRole : userRoleLst) {

                        String roRukoDo = userRole.getRoleCd();

                        if (waKuroRukoDo.equals(roRukoDo)) {

                            sakujyoFlg = false;
                        }
                    }

                    if (sakujyoFlg == true) {

                        bizDomManager.delete(userRoleWk);

                        userRoleWkDeleteCount++;
                    }
                }
            }
        }

        bizDomManager.flush();

        try (ExDBResults<BW_IdCardWk> idCardWkLst = bizDomManager.getIdCardWksByNotExistsUserWk();
            EntityInserter<BW_UserWk> userWkLst = new EntityInserter<>();
            EntityInserter<BW_UserRoleWk> userRoleWkLst = new EntityInserter<>()) {

            for (BW_IdCardWk idCardWk : idCardWkLst) {

                BW_UserWk userWk = new BW_UserWk();

                userWk.setUserId(idCardWk.getIdkbn() + idCardWk.getIdcd());
                userWk.setUserNm(idCardWk.getKanjiidnyuuryokusyanm());
                userWk.setSpecialUserKbn(C_SpecialUserKbn.IPPAN);
                userWk.setPasswordYuukouKikanKbn(C_PasswordYuukouKikanKbn.NONE);
                userWk.setPasswordHenkouKyokaKbn(C_KyokaKbn.NONE);
                userWk.setPasswordHenkouYoukyuuKbn(C_YoukyuuKbn.NONE);
                userWk.setLoginKyokaKbn(C_KyokaKbn.KYOKA);

                BizPropertyInitializer.initialize(userWk);

                userWkLst.add(userWk);

                userWkInsertCount++;

                if ((idCardWk.getSyozokusosikicd().substring(0, 3).compareTo("300") < 0 ||
                    YuyuBizConfig.getInstance().getSisyaAtukaiSosikiCdList().contains(
                        idCardWk.getSyozokusosikicd().substring(0, 3))) &&
                        "0".equals(idCardWk.getSyozokusosikicd().substring(3,4)) &&
                        !YuyuBizConfig.getInstance().getSisyaReigaiSosikiCdList().contains(
                            idCardWk.getSyozokusosikicd().substring(0, 3)) &&
                            ((C_IdCdKbn.IDKBN_1.getValue().equals(idCardWk.getIdkbn()) &&
                                (C_TanmatuSiyouKbn.SOUGOU_IPPAN.getValue().equals(idCardWk.getTanmatusiyoukbn()) ||
                                    C_TanmatuSiyouKbn.SONOTA.getValue().equals(idCardWk.getTanmatusiyoukbn())) ||
                                    (C_IdCdKbn.IDKBN_3.getValue().equals(idCardWk.getIdkbn()) &&
                                        C_TanmatuSiyouKbn.SOUGOU_IPPAN.getValue().equals(idCardWk.getTanmatusiyoukbn()))))){
                    for (String sisyayouRoleCd : YuyuBizConfig.getInstance().getSisyayouRoleCdList()) {

                        BW_UserRoleWk userRoleWk = new BW_UserRoleWk();

                        userRoleWk.setUserId(idCardWk.getIdkbn() + idCardWk.getIdcd());
                        userRoleWk.setRoleCd(sisyayouRoleCd);

                        BizPropertyInitializer.initialize(userRoleWk);

                        userRoleWkLst.add(userRoleWk);

                        userRoleWkInsertCount++;
                    }
                }
            }
        }

        try(ExDBResults<BW_IdCardWk> idCardWkList = bizDomManager.getIdCardWksSyoukaiUserByNotExistsUserWk();

            EntityInserter<BW_UserRoleWk> userRoleWkLst = new EntityInserter<>()) {

            for (BW_IdCardWk idCardWk : idCardWkList) {

                List<String> hnsyaSyoukaiSosikiyouRoleCdList = YuyuBizConfig.getInstance().getHnsyaSyoukaiSosikiyouRoleCdList();

                for (String hnsyaSyoukaiSosikiyouRoleCd : hnsyaSyoukaiSosikiyouRoleCdList) {

                    BW_UserRoleWk userRoleWk = new BW_UserRoleWk();

                    userRoleWk.setUserId(idCardWk.getIdkbn() + idCardWk.getIdcd());
                    userRoleWk.setRoleCd(hnsyaSyoukaiSosikiyouRoleCd);

                    BizPropertyInitializer.initialize(userRoleWk);

                    userRoleWkLst.add(userRoleWk);

                    userRoleWkInsertCount++;
                }
            }
        }

        try (ExDBResults<BW_IdCardWk> idCardWkLst = bizDomManager.getIdCardWksByNotExistsUserWkUserNm();
            EntityUpdater<BW_UserWk> userWkLst = new EntityUpdater<>()) {

            for (BW_IdCardWk idCardWk : idCardWkLst) {

                BW_UserWk userWk = bizDomManager.getUserWk(idCardWk.getIdkbn() + idCardWk.getIdcd());

                userWk.setUserNm(idCardWk.getKanjiidnyuuryokusyanm());

                userWkLst.add(userWk);

                userWkUpdateCount++;
            }
        }

        List<String> sisyaReigaiSosikiCdLst = YuyuBizConfig.getInstance().getSisyaReigaiSosikiCdList();
        String[] SisyaReigaiSosikiCds = sisyaReigaiSosikiCdLst.toArray(new String[sisyaReigaiSosikiCdLst.size()]);
        List<String> sisyayouRoleCdLst = YuyuBizConfig.getInstance().getSisyayouRoleCdList();
        String[] sisyayouRoleCds = sisyayouRoleCdLst.toArray(new String[sisyayouRoleCdLst.size()]);

        try (ExDBUpdatableResults<BW_UserWk> userWkLst = bizDomManager.getUserWksNotExistsSisyaUserRoleWk(
            SisyaReigaiSosikiCds, sisyayouRoleCds);
            EntityInserter<BW_UserRoleWk> userRoleWkLst = new EntityInserter<>()) {

            for (BW_UserWk userWk : userWkLst) {

                List<BW_UserRoleWk> userRoleWkList = bizDomManager.getUserRoleWksByUserId(userWk.getUserId());

                boolean sisyayouRoleCdFlg = false;

                for (BW_UserRoleWk userRoleWk : userRoleWkList) {

                    if (!YuyuBizConfig.getInstance().getSisyayouRoleCdList().contains(userRoleWk.getRoleCd())) {

                        bizDomManager.delete(userRoleWk);

                        userRoleWkDeleteCount++;
                    }
                    else {

                        sisyayouRoleCdFlg = true;
                    }
                }

                if (sisyayouRoleCdFlg == false) {

                    for (String sisyayouRoleCd : YuyuBizConfig.getInstance().getSisyayouRoleCdList()) {

                        BW_UserRoleWk userRoleWk = new BW_UserRoleWk();

                        userRoleWk.setUserId(userWk.getUserId());
                        userRoleWk.setRoleCd(sisyayouRoleCd);

                        BizPropertyInitializer.initialize(userRoleWk);

                        userRoleWkLst.add(userRoleWk);

                        userRoleWkInsertCount++;
                    }
                }
            }
        }

        List<String> hnsyaSyoukaiSosikiyouRoleCdList = YuyuBizConfig.getInstance().getHnsyaSyoukaiSosikiyouRoleCdList();

        String[] honsyayouRoleCds =
            hnsyaSyoukaiSosikiyouRoleCdList.toArray(new String[hnsyaSyoukaiSosikiyouRoleCdList.size()]);

        try (ExDBUpdatableResults<BW_UserWk> userWkLst = bizDomManager.getUserWksNotExistsSyoukaiUserRoleWk(honsyayouRoleCds);

            EntityInserter<BW_UserRoleWk> userRoleWkLst = new EntityInserter<>()){

            for (BW_UserWk userWk : userWkLst) {

                List<BW_UserRoleWk> userRoleWkList = bizDomManager.getUserRoleWksByUserId(userWk.getUserId());

                boolean honsyayouRoleCdFlg = false;

                for (BW_UserRoleWk userRoleWk : userRoleWkList) {

                    if (!hnsyaSyoukaiSosikiyouRoleCdList.contains(userRoleWk.getRoleCd())) {

                        bizDomManager.delete(userRoleWk);

                        userRoleWkDeleteCount++;
                    }
                    else {

                        honsyayouRoleCdFlg = true;
                    }
                }

                if (honsyayouRoleCdFlg == false) {

                    for (String hnsyaSyoukaiSosikiyouRoleCd : hnsyaSyoukaiSosikiyouRoleCdList) {

                        BW_UserRoleWk userRoleWk = new BW_UserRoleWk();

                        userRoleWk.setUserId(userWk.getUserId());
                        userRoleWk.setRoleCd(hnsyaSyoukaiSosikiyouRoleCd);

                        BizPropertyInitializer.initialize(userRoleWk);

                        userRoleWkLst.add(userRoleWk);

                        userRoleWkInsertCount++;
                    }
                }
            }
        }

        try (ExDBUpdatableResults<BW_UserWk> userWkLst = bizDomManager.getUserWksBySyozokusosikicdKeta3()) {

            for (BW_UserWk userWk : userWkLst) {

                List<BW_UserRoleWk> userRoleWkLst = bizDomManager.getUserRoleWksByUserId(userWk.getUserId());

                for (BW_UserRoleWk userRoleWk : userRoleWkLst) {

                    if (YuyuBizConfig.getInstance().getSisyayouRoleCdList().contains(userRoleWk.getRoleCd()) ||
                        YuyuBizConfig.getInstance().getHnsyaSyoukaiSosikiyouRoleCdList().contains(userRoleWk.getRoleCd()) ) {

                        bizDomManager.delete(userRoleWk);

                        userRoleWkDeleteCount++;
                    }
                }
            }
        }

        try (ExDBUpdatableResults<BW_UserWk> userWkLst = bizDomManager.getUserWksNotExistsUserIdKanrenWk()) {

            for (BW_UserWk userWk : userWkLst) {

                List<BW_UserRoleWk> userRoleWkLst = bizDomManager.getUserRoleWksByUserId(userWk.getUserId());

                if (userRoleWkLst.size() > 0) {
                    bizDomManager.delete(userRoleWkLst);

                    userRoleWkDeleteCount = userRoleWkDeleteCount + userRoleWkLst.size();
                }

                bizDomManager.delete(userWk);

                userWkDeleteCount++;
            }
        }

        List<String> sisyaAtukaiSosikiCdLst = YuyuBizConfig.getInstance().getSisyaAtukaiSosikiCdList();
        String[] SisyaAtukaiSosikiCds = sisyaAtukaiSosikiCdLst.toArray(new String[sisyaAtukaiSosikiCdLst.size()]);
        try (ExDBUpdatableResults<BW_UserWk> userWkLst =
            bizDomManager.getUserWksNotExistsUserKengenHaneiSskInfo(SisyaAtukaiSosikiCds, SisyaReigaiSosikiCds)) {

            for (BW_UserWk userWk : userWkLst) {

                List<BW_UserRoleWk> userRoleWkLst = bizDomManager.getUserRoleWksByUserId(userWk.getUserId());

                for (BW_UserRoleWk userRoleWk : userRoleWkLst) {

                    bizDomManager.delete(userRoleWk);

                    userRoleWkDeleteCount++;
                }
            }
        }
    }
}
