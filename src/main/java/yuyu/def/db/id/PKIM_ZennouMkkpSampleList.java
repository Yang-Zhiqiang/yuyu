package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_ZennouKbn;
import yuyu.def.classification.C_ZennouToukeiListKbn;
import yuyu.def.db.entity.IM_ZennouMkkpSampleList;
import yuyu.def.db.mapping.GenIM_ZennouMkkpSampleList;
import yuyu.def.db.meta.GenQIM_ZennouMkkpSampleList;
import yuyu.def.db.meta.QIM_ZennouMkkpSampleList;

/**
 * 前納未経過Ｐ検証サンプルリストパターンマスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IM_ZennouMkkpSampleList}</td><td colspan="3">前納未経過Ｐ検証サンプルリストパターンマスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZennoutoukeilistkbn zennoutoukeilistkbn}</td><td>前納統計リスト区分</td><td align="center">○</td><td align="center">V</td><td>{@link C_ZennouToukeiListKbn}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZennoukbn zennoukbn}</td><td>前納区分</td><td align="center">○</td><td align="center">V</td><td>{@link C_ZennouKbn}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getKbnkeirisegcd kbnkeirisegcd}</td><td>区分経理用セグメントコード</td><td align="center">○</td><td align="center">V</td><td>{@link C_Segcd}</td></tr>
 *  <tr><td>znnmkkpkssamplekslsttitle</td><td>前納未経過Ｐ検証サンプルリストタイトル</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IM_ZennouMkkpSampleList
 * @see     GenIM_ZennouMkkpSampleList
 * @see     QIM_ZennouMkkpSampleList
 * @see     GenQIM_ZennouMkkpSampleList
 */
public class PKIM_ZennouMkkpSampleList extends AbstractExDBPrimaryKey<IM_ZennouMkkpSampleList, PKIM_ZennouMkkpSampleList> {

    private static final long serialVersionUID = 1L;

    public PKIM_ZennouMkkpSampleList() {
    }

    public PKIM_ZennouMkkpSampleList(
        C_ZennouToukeiListKbn pZennoutoukeilistkbn,
        C_ZennouKbn pZennoukbn,
        C_Segcd pKbnkeirisegcd
    ) {
        zennoutoukeilistkbn = pZennoutoukeilistkbn;
        zennoukbn = pZennoukbn;
        kbnkeirisegcd = pKbnkeirisegcd;
    }

    @Transient
    @Override
    public Class<IM_ZennouMkkpSampleList> getEntityClass() {
        return IM_ZennouMkkpSampleList.class;
    }

    private C_ZennouToukeiListKbn zennoutoukeilistkbn;

    @org.hibernate.annotations.Type(type="UserType_C_ZennouToukeiListKbn")
    public C_ZennouToukeiListKbn getZennoutoukeilistkbn() {
        return zennoutoukeilistkbn;
    }

    public void setZennoutoukeilistkbn(C_ZennouToukeiListKbn pZennoutoukeilistkbn) {
        zennoutoukeilistkbn = pZennoutoukeilistkbn;
    }
    private C_ZennouKbn zennoukbn;

    @org.hibernate.annotations.Type(type="UserType_C_ZennouKbn")
    public C_ZennouKbn getZennoukbn() {
        return zennoukbn;
    }

    public void setZennoukbn(C_ZennouKbn pZennoukbn) {
        zennoukbn = pZennoukbn;
    }
    private C_Segcd kbnkeirisegcd;

    @org.hibernate.annotations.Type(type="UserType_C_Segcd")
    public C_Segcd getKbnkeirisegcd() {
        return kbnkeirisegcd;
    }

    public void setKbnkeirisegcd(C_Segcd pKbnkeirisegcd) {
        kbnkeirisegcd = pKbnkeirisegcd;
    }

}