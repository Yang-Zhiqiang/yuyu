package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.AT_BatchDate;
import yuyu.def.db.mapping.GenAT_BatchDate;
import yuyu.def.db.meta.GenQAT_BatchDate;
import yuyu.def.db.meta.QAT_BatchDate;

/**
 * バッチ日付テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link AT_BatchDate}</td><td colspan="3">バッチ日付テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getBatchExecDate batchExecDate}</td><td>バッチ実行日</td><td align="center">○</td><td align="center">V</td><td>BizDate</td></tr>
 * </table>
 * @see     AT_BatchDate
 * @see     GenAT_BatchDate
 * @see     QAT_BatchDate
 * @see     GenQAT_BatchDate
 */
public class PKAT_BatchDate extends AbstractExDBPrimaryKey<AT_BatchDate, PKAT_BatchDate> {

    private static final long serialVersionUID = 1L;

    public PKAT_BatchDate() {
    }

    public PKAT_BatchDate(BizDate pBatchExecDate) {
        batchExecDate = pBatchExecDate;
    }

    @Transient
    @Override
    public Class<AT_BatchDate> getEntityClass() {
        return AT_BatchDate.class;
    }

    private BizDate batchExecDate;

    @org.hibernate.annotations.Type(type="BizDateType")
    public BizDate getBatchExecDate() {
        return batchExecDate;
    }

    public void setBatchExecDate(BizDate pBatchExecDate) {
        batchExecDate = pBatchExecDate;
    }

}