package yuyu.common.hozen.haitou;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.slf4j.Logger;

import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.def.db.mapping.AbstractExDBEntity;

/**
 * 契約保全 契約保全共通 配当共通基礎
 */
public class BaseDCommon implements HaitouErrorProcess, HaitouDetachProcess {

    private final String kinouId = this.getClass().getSimpleName();

    private final HaitouErrorInfo errorInfoNoError = new HaitouErrorInfo(kinouId, "NoError", "NoError");

    private final Map<String, HaitouErrorInfo> allErrorInfo = new HashMap<>();

    private HaitouErrorInfo errorInfo = errorInfoNoError;

    private HaitouErrorProcess errorLink = null;

    private Set<AbstractExDBEntity<?, ?>> entitySet = new HashSet<AbstractExDBEntity<?, ?>>();

    private Set<HaitouDetachProcess> haitouDetachProcessSet = new HashSet<HaitouDetachProcess>();

    private boolean collectEntityFlg = true;

    @Inject
    private static Logger logger;

    @Override
    public void regErrorInfo(String pErrorCode, String pErrorInfo1, String pErrorInfo2) {

        if (allErrorInfo.containsKey(pErrorCode)) {
            throw new CommonBizAppException();
        }

        allErrorInfo.put(pErrorCode, new HaitouErrorInfo(kinouId, pErrorInfo1, pErrorInfo2));
    }

    @Override
    public Set<Map.Entry<String, HaitouErrorInfo>> getAllErrorCode() {

        logger.debug("▽ 配当共通基礎 エラーコード一覧取得処理(" + kinouId + ") 開始");

        Set<Map.Entry<String, HaitouErrorInfo>> allCode = allErrorInfo.entrySet();

        logger.debug("△ 配当共通基礎 エラーコード一覧取得処理(" + kinouId + ") 終了");

        return allCode;
    }

    @Override
    public void clear() {

        logger.debug("▽ 配当共通基礎 クリア処理(" + kinouId + ") 開始");

        errorInfo = errorInfoNoError;

        if (errorLink != null) {
            errorLink.clear();

            errorLink = null;
        }

        logger.debug("△ 配当共通基礎 クリア処理(" + kinouId + ") 終了");
    }

    @Override
    public void setErrorInfo(String pErrorCode) {

        logger.debug("▽ 配当共通基礎 エラー情報設定処理(" + kinouId + ") 開始");

        if (allErrorInfo.containsKey(pErrorCode)) {
            errorInfo = allErrorInfo.get(pErrorCode);

        }
        else {
            errorInfo = new HaitouErrorInfo(kinouId, "エラーコード整合性不正", pErrorCode);
        }

        if (logger.isDebugEnabled()) {
            logger.debug("｜   Error Code ＝  " + pErrorCode);
            logger.debug("｜   kinouId    ＝  " + errorInfo.getKinouId());
            logger.debug("｜   errorInfo1 ＝  " + errorInfo.getErrorInfo1());
            logger.debug("｜   errorInfo2 ＝  " + errorInfo.getErrorInfo2());
        }

        errorLink = null;

        logger.debug("△ 配当共通基礎 エラー情報設定処理(" + kinouId + ") 終了");
    }

    @Override
    public void setErrorLink(HaitouErrorProcess pErrorProcess) {

        logger.debug("▽ 配当共通基礎 エラーリンク設定処理(" + kinouId + ") 開始");

        errorInfo = errorInfoNoError;

        errorLink = pErrorProcess;

        logger.debug("△ 配当共通基礎 エラーリンク設定処理(" + kinouId + ") 終了");
    }

    @Override
    public List<HaitouErrorInfo> getErrorInfo() {

        logger.debug("▽ 配当共通基礎 エラー情報取得処理(" + kinouId + ") 開始");

        List<HaitouErrorInfo> errorList;

        logger.debug("｜   kinouId    ＝  " + kinouId);

        if (errorLink == null) {
            errorList = new ArrayList<HaitouErrorInfo>();
            errorList.add(errorInfo);

            if (logger.isDebugEnabled()) {
                logger.debug("｜   errorInfo1 ＝  " + errorInfo.getErrorInfo1());
                logger.debug("｜   errorInfo2 ＝  " + errorInfo.getErrorInfo2());
            }
        }
        else {
            errorList = errorLink.getErrorInfo();
            errorList.add(errorInfoNoError);
        }

        logger.debug("△ 配当共通基礎 エラー情報取得処理(" + kinouId + ") 終了");

        return errorList;
    }

    @Override
    public <T> T getInjectInstance(Class<T> pType) {
        logger.debug("▽ 配当共通基礎 インスタンス取得処理（デタッチ対応版）(" + kinouId + ") 開始");
        T t =  SWAKInjector.getInstance(pType);
        if (t instanceof HaitouDetachProcess) {
            haitouDetachProcessSet.add((HaitouDetachProcess) t);
        }
        logger.debug("△ 配当共通基礎 インスタンス取得処理（デタッチ対応版）(" + kinouId + ") 終了");
        return t;
    }

    @Override
    public boolean getCollectEntityFlg() {
        logger.debug("▽ 配当共通基礎 エンティティ収集責任取得処理(" + kinouId + ") 開始");
        if (collectEntityFlg) {
            collectEntityFlg = false;

            logger.debug("△ 配当共通基礎 エンティティ収集責任取得処理(" + kinouId + ") 終了");
            return true;
        }
        logger.debug("△ 配当共通基礎 エンティティ収集責任取得処理(" + kinouId + ") 終了");
        return false;
    }

    @Override
    public void setEntity(AbstractExDBEntity<?, ?> pEntity) {
        if (logger.isDebugEnabled()) {
            logger.debug("▽ 配当共通基礎 エンティティ格納処理(" + kinouId + ") 開始");
            logger.debug("｜   格納対象エンティティ(" + kinouId + ") ＝  " + pEntity.toString());
        }
        entitySet.add(pEntity);

        logger.debug("△ 配当共通基礎 エンティティ格納処理(" + kinouId + ") 終了");
    }

    @Override
    public void setEntity(List<? extends AbstractExDBEntity<?, ?>> pEntityList) {
        if (logger.isDebugEnabled()) {
            logger.debug("▽ 配当共通基礎 エンティティリスト格納処理(" + kinouId + ") 開始");
            logger.debug("｜   格納対象エンティティ(" + kinouId + ") ＝  " + pEntityList.toString());
        }
        entitySet.addAll(pEntityList);

        logger.debug("△ 配当共通基礎 エンティティリスト格納処理(" + kinouId + ") 終了");
    }

    @Override
    public void collectEntity(boolean pFlg) {
        if (pFlg) {
            logger.debug("▽ 配当共通基礎 エンティティ収集処理(" + kinouId + ") 開始");
            for(HaitouDetachProcess haitouDetachProcess :haitouDetachProcessSet) {
                entitySet.addAll(haitouDetachProcess.giveEntity());
            }
            haitouDetachProcessSet = new HashSet<HaitouDetachProcess>();
            collectEntityFlg = true;

            logger.debug("△ 配当共通基礎 エンティティ収集処理(" + kinouId + ") 終了");
        }
    }

    @Override
    public Set<AbstractExDBEntity<?, ?>> giveEntity() {
        if (logger.isDebugEnabled()) {
            logger.debug("▽ 配当共通基礎 エンティティ譲渡処理(" + kinouId + ") 開始");
            logger.debug("｜   デタッチ対象件数 ＝  " + entitySet.size());
        }
        Set<AbstractExDBEntity<?, ?>> tmpEntitySet = entitySet;
        entitySet = new HashSet<AbstractExDBEntity<?, ?>>();

        logger.debug("△ 配当共通基礎 エンティティ譲渡処理(" + kinouId + ") 終了");
        return tmpEntitySet;
    }

    @Override
    public void detach() {
        if (logger.isDebugEnabled()) {
            logger.debug("▽ 配当共通基礎 デタッチ処理(" + kinouId + ") 開始");
            logger.debug("｜   デタッチ対象件数 ＝  " + entitySet.size());
            logger.debug("｜   デタッチ対象エンティティ(" + kinouId + ") ＝  " + entitySet.toString());
        }
        for (AbstractExDBEntity<?, ?> entity : entitySet) {
            entity.noCheckDetach();
        }
        entitySet = new HashSet<AbstractExDBEntity<?, ?>>();

        logger.debug("△ 配当共通基礎 デタッチ処理(" + kinouId + ") 終了");
    }

}
