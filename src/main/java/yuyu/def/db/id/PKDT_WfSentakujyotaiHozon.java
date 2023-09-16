package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import yuyu.def.db.entity.DT_WfSentakujyotaiHozon;
import yuyu.def.db.mapping.GenDT_WfSentakujyotaiHozon;
import yuyu.def.db.meta.GenQDT_WfSentakujyotaiHozon;
import yuyu.def.db.meta.QDT_WfSentakujyotaiHozon;

/**
 * ワークフロー選択状態保存テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link DT_WfSentakujyotaiHozon}</td><td colspan="3">ワークフロー選択状態保存テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getUserId userId}</td><td>ユーザーＩＤ</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSubSystemId subSystemId}</td><td>サブシステムＩＤ</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>jimutetuzukicd</td><td>事務手続コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>skeiJimuKbnHzn</td><td>新契約事務区分＿保存用</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>mosUketukeKbnHzn</td><td>申込受付区分＿保存用</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hokensyuruinohozon</td><td>保険種類番号＿保存用</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>dairitencd1</td><td>代理店コード１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>dairitencd2</td><td>代理店コード２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>drtencd3</td><td>代理店コード３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>drtencd4</td><td>代理店コード４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>drtencd5</td><td>代理店コード５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>koDairitenTaisyouKbn</td><td>子代理店対象区分</td><td>&nbsp;</td><td align="center">B</td><td>Boolean</td></tr>
 *  <tr><td>jimuyoucd</td><td>事務用コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>jmycdMisetteiKbn</td><td>事務用コード未設定区分</td><td>&nbsp;</td><td align="center">B</td><td>Boolean</td></tr>
 *  <tr><td>djmskmKeiyakuKbn</td><td>同時申込契約区分</td><td>&nbsp;</td><td align="center">B</td><td>Boolean</td></tr>
 *  <tr><td>mosYmdFrom</td><td>申込年月日（自）</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>mosYmdTo</td><td>申込年月日（至）</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>jimustartYmdFrom</td><td>事務開始年月日（自）</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>jimustartYmdTo</td><td>事務開始年月日（至）</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>mosno</td><td>申込番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syono</td><td>証券番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>nksysyno</td><td>年金証書番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     DT_WfSentakujyotaiHozon
 * @see     GenDT_WfSentakujyotaiHozon
 * @see     QDT_WfSentakujyotaiHozon
 * @see     GenQDT_WfSentakujyotaiHozon
 */
public class PKDT_WfSentakujyotaiHozon extends AbstractExDBPrimaryKey<DT_WfSentakujyotaiHozon, PKDT_WfSentakujyotaiHozon> {

    private static final long serialVersionUID = 1L;

    public PKDT_WfSentakujyotaiHozon() {
    }

    public PKDT_WfSentakujyotaiHozon(String pUserId, String pSubSystemId) {
        userId = pUserId;
        subSystemId = pSubSystemId;
    }

    @Transient
    @Override
    public Class<DT_WfSentakujyotaiHozon> getEntityClass() {
        return DT_WfSentakujyotaiHozon.class;
    }

    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String pUserId) {
        userId = pUserId;
    }
    private String subSystemId;

    public String getSubSystemId() {
        return subSystemId;
    }

    public void setSubSystemId(String pSubSystemId) {
        subSystemId = pSubSystemId;
    }

}