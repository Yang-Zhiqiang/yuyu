package yuyu.app.workflow.processkanri.tantousyabetusyoritasksyoukai;

import java.util.List;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import jp.co.slcs.swak.web.ui.AbstractUiBean;
import jp.co.slcs.swak.web.ui.DataSource;
import jp.co.slcs.swak.web.ui.UserDefsList;
import yuyu.infr.validation.constraints.InvalidCharacter;

/**
 * 担当者別処理タスク照会 : 画面UiBeanの抽象親クラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えないでください。
 */
public abstract class GenTantousyabetuSyoriTaskSyoukaiUiBean extends AbstractUiBean {

    private static final long serialVersionUID = 1L;

    private DataSource<TaskserInfoDataSourceBean> taskserInfoDataSource = new DataSource<>();
    public DataSource<TaskserInfoDataSourceBean> getTaskserInfoDataSource() {
        return taskserInfoDataSource;
    }

    @Deprecated
    public List<TaskserInfoDataSourceBean> getTaskserInfo() {
        return taskserInfoDataSource.getDatas();
    }

    public void setTaskserInfo(List<TaskserInfoDataSourceBean> pTaskserInfo) {
        taskserInfoDataSource.setDatas(pTaskserInfo, 10);
    }

    private String subSystemId;

    public String getSubSystemId() {
        return subSystemId;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSubSystemId(String pSubSystemId) {
        subSystemId = pSubSystemId;
    }

    @MaxLength(max=30)
    @AlphaDigit
    private String userId;

    public String getUserId() {
        return userId;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setUserId(String pUserId) {
        userId = pUserId;
    }

    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    private String userNm;

    public String getUserNm() {
        return userNm;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setUserNm(String pUserNm) {
        userNm = pUserNm;
    }

    @ValidDate
    private BizDate syoriYmdFrom;

    public BizDate getSyoriYmdFrom() {
        return syoriYmdFrom;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyoriYmdFrom(BizDate pSyoriYmdFrom) {
        syoriYmdFrom = pSyoriYmdFrom;
    }

    @ValidDate
    private BizDate syoriYmdTo;

    public BizDate getSyoriYmdTo() {
        return syoriYmdTo;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyoriYmdTo(BizDate pSyoriYmdTo) {
        syoriYmdTo = pSyoriYmdTo;
    }

    private LoopChain<UserDefsList> subSystemIdOptionBeanList = new LoopChain<>();
    public UserDefsList getSubSystemIdOptionBeanList() {
        return subSystemIdOptionBeanList.get();
    }

    public void setSubSystemIdOptionBeanList(UserDefsList pSubSystemIdOptionBeanList) {
        clearSubSystemIdOptionBeanList();
        subSystemIdOptionBeanList.add(pSubSystemIdOptionBeanList);
    }

    public void clearSubSystemIdOptionBeanList() {
        subSystemIdOptionBeanList.clear();
    }
}
