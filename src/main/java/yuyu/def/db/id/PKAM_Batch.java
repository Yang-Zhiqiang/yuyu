package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.AM_Batch;
import yuyu.def.db.mapping.GenAM_Batch;
import yuyu.def.db.meta.GenQAM_Batch;
import yuyu.def.db.meta.QAM_Batch;

/**
 * バッチマスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link AM_Batch}</td><td colspan="3">バッチマスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getKinouId kinouId}</td><td>機能ＩＤ</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>batchClass</td><td>バッチクラス</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>paramBeanClass</td><td>パラメータビーンクラス</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tajuukidouKahiKbn</td><td>多重起動可否区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KahiKbn C_KahiKbn}</td></tr>
 *  <tr><td>batchMode</td><td>バッチ起動モード</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_BatchModeKbn C_BatchModeKbn}</td></tr>
 *  <tr><td>tyuudanKahi</td><td>中断可否</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KahiKbn C_KahiKbn}</td></tr>
 *  <tr><td>onlineHeisouKahiKbn</td><td>オンライン並走可否区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KahiKbn C_KahiKbn}</td></tr>
 *  <tr><td>batchHeisouKbn</td><td>バッチ並走区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_BatchHeisouKbn C_BatchHeisouKbn}</td></tr>
 * </table>
 * @see     AM_Batch
 * @see     GenAM_Batch
 * @see     QAM_Batch
 * @see     GenQAM_Batch
 */
public class PKAM_Batch extends AbstractExDBPrimaryKey<AM_Batch, PKAM_Batch> {

    private static final long serialVersionUID = 1L;

    public PKAM_Batch() {
    }

    public PKAM_Batch(String pKinouId) {
        kinouId = pKinouId;
    }

    @Transient
    @Override
    public Class<AM_Batch> getEntityClass() {
        return AM_Batch.class;
    }

    private String kinouId;

    public String getKinouId() {
        return kinouId;
    }

    public void setKinouId(String pKinouId) {
        kinouId = pKinouId;
    }

}