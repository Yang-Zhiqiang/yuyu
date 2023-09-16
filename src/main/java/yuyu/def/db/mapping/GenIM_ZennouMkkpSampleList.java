package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_ZennouKbn;
import yuyu.def.classification.C_ZennouToukeiListKbn;
import yuyu.def.db.entity.IM_ZennouMkkpSampleList;
import yuyu.def.db.id.PKIM_ZennouMkkpSampleList;
import yuyu.def.db.meta.GenQIM_ZennouMkkpSampleList;
import yuyu.def.db.meta.QIM_ZennouMkkpSampleList;
import yuyu.def.db.type.UserType_C_Segcd;
import yuyu.def.db.type.UserType_C_ZennouKbn;
import yuyu.def.db.type.UserType_C_ZennouToukeiListKbn;

/**
 * 前納未経過Ｐ検証サンプルリストパターンマスタ テーブルのマッピング情報クラスで、 {@link IM_ZennouMkkpSampleList} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IM_ZennouMkkpSampleList}</td><td colspan="3">前納未経過Ｐ検証サンプルリストパターンマスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZennoutoukeilistkbn zennoutoukeilistkbn}</td><td>前納統計リスト区分</td><td align="center">{@link PKIM_ZennouMkkpSampleList ○}</td><td align="center">V</td><td>{@link C_ZennouToukeiListKbn}</td></tr>
 *  <tr><td>{@link #getZennoukbn zennoukbn}</td><td>前納区分</td><td align="center">{@link PKIM_ZennouMkkpSampleList ○}</td><td align="center">V</td><td>{@link C_ZennouKbn}</td></tr>
 *  <tr><td>{@link #getKbnkeirisegcd kbnkeirisegcd}</td><td>区分経理用セグメントコード</td><td align="center">{@link PKIM_ZennouMkkpSampleList ○}</td><td align="center">V</td><td>{@link C_Segcd}</td></tr>
 *  <tr><td>{@link #getZnnmkkpkssamplekslsttitle znnmkkpkssamplekslsttitle}</td><td>前納未経過Ｐ検証サンプルリストタイトル</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IM_ZennouMkkpSampleList
 * @see     PKIM_ZennouMkkpSampleList
 * @see     QIM_ZennouMkkpSampleList
 * @see     GenQIM_ZennouMkkpSampleList
 */
@MappedSuperclass
@Table(name=GenIM_ZennouMkkpSampleList.TABLE_NAME)
@IdClass(value=PKIM_ZennouMkkpSampleList.class)
@TypeDefs({
    @TypeDef(name="UserType_C_Segcd", typeClass=UserType_C_Segcd.class),
    @TypeDef(name="UserType_C_ZennouKbn", typeClass=UserType_C_ZennouKbn.class),
    @TypeDef(name="UserType_C_ZennouToukeiListKbn", typeClass=UserType_C_ZennouToukeiListKbn.class)
})
public abstract class GenIM_ZennouMkkpSampleList extends AbstractExDBEntity<IM_ZennouMkkpSampleList, PKIM_ZennouMkkpSampleList> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IM_ZennouMkkpSampleList";
    public static final String ZENNOUTOUKEILISTKBN      = "zennoutoukeilistkbn";
    public static final String ZENNOUKBN                = "zennoukbn";
    public static final String KBNKEIRISEGCD            = "kbnkeirisegcd";
    public static final String ZNNMKKPKSSAMPLEKSLSTTITLE = "znnmkkpkssamplekslsttitle";

    private final PKIM_ZennouMkkpSampleList primaryKey;

    public GenIM_ZennouMkkpSampleList() {
        primaryKey = new PKIM_ZennouMkkpSampleList();
    }

    public GenIM_ZennouMkkpSampleList(
        C_ZennouToukeiListKbn pZennoutoukeilistkbn,
        C_ZennouKbn pZennoukbn,
        C_Segcd pKbnkeirisegcd
    ) {
        primaryKey = new PKIM_ZennouMkkpSampleList(
            pZennoutoukeilistkbn,
            pZennoukbn,
            pKbnkeirisegcd
        );
    }

    @Transient
    @Override
    public PKIM_ZennouMkkpSampleList getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIM_ZennouMkkpSampleList> getMetaClass() {
        return QIM_ZennouMkkpSampleList.class;
    }

    @Id
    @Type(type="UserType_C_ZennouToukeiListKbn")
    @Column(name=GenIM_ZennouMkkpSampleList.ZENNOUTOUKEILISTKBN)
    public C_ZennouToukeiListKbn getZennoutoukeilistkbn() {
        return getPrimaryKey().getZennoutoukeilistkbn();
    }

    public void setZennoutoukeilistkbn(C_ZennouToukeiListKbn pZennoutoukeilistkbn) {
        getPrimaryKey().setZennoutoukeilistkbn(pZennoutoukeilistkbn);
    }

    @Id
    @Type(type="UserType_C_ZennouKbn")
    @Column(name=GenIM_ZennouMkkpSampleList.ZENNOUKBN)
    public C_ZennouKbn getZennoukbn() {
        return getPrimaryKey().getZennoukbn();
    }

    public void setZennoukbn(C_ZennouKbn pZennoukbn) {
        getPrimaryKey().setZennoukbn(pZennoukbn);
    }

    @Id
    @Type(type="UserType_C_Segcd")
    @Column(name=GenIM_ZennouMkkpSampleList.KBNKEIRISEGCD)
    public C_Segcd getKbnkeirisegcd() {
        return getPrimaryKey().getKbnkeirisegcd();
    }

    public void setKbnkeirisegcd(C_Segcd pKbnkeirisegcd) {
        getPrimaryKey().setKbnkeirisegcd(pKbnkeirisegcd);
    }

    private String znnmkkpkssamplekslsttitle;

    @Column(name=GenIM_ZennouMkkpSampleList.ZNNMKKPKSSAMPLEKSLSTTITLE)
    public String getZnnmkkpkssamplekslsttitle() {
        return znnmkkpkssamplekslsttitle;
    }

    public void setZnnmkkpkssamplekslsttitle(String pZnnmkkpkssamplekslsttitle) {
        znnmkkpkssamplekslsttitle = pZnnmkkpkssamplekslsttitle;
    }
}