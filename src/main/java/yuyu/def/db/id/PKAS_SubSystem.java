package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.AS_SubSystem;
import yuyu.def.db.mapping.GenAS_SubSystem;
import yuyu.def.db.meta.GenQAS_SubSystem;
import yuyu.def.db.meta.QAS_SubSystem;

/**
 * サブシステム基幹テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link AS_SubSystem}</td><td colspan="3">サブシステム基幹テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSubSystemId subSystemId}</td><td>サブシステムＩＤ</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>subSystemNm</td><td>サブシステム名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sortNo</td><td>ソート番号</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>linkImage</td><td>リンクイメージ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hyoudaiImage</td><td>表題イメージ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     AS_SubSystem
 * @see     GenAS_SubSystem
 * @see     QAS_SubSystem
 * @see     GenQAS_SubSystem
 */
public class PKAS_SubSystem extends AbstractExDBPrimaryKey<AS_SubSystem, PKAS_SubSystem> {

    private static final long serialVersionUID = 1L;

    public PKAS_SubSystem() {
    }

    public PKAS_SubSystem(String pSubSystemId) {
        subSystemId = pSubSystemId;
    }

    @Transient
    @Override
    public Class<AS_SubSystem> getEntityClass() {
        return AS_SubSystem.class;
    }

    private String subSystemId;

    public String getSubSystemId() {
        return subSystemId;
    }

    public void setSubSystemId(String pSubSystemId) {
        subSystemId = pSubSystemId;
    }

}