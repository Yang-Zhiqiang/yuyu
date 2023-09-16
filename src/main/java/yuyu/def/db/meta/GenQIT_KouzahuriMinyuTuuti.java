package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_AsTyouhyoukigouKbn;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_Skszumiflg;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.entity.IT_KouzahuriMinyuTuuti;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import yuyu.def.db.type.UserType_C_AsTyouhyoukigouKbn;
import yuyu.def.db.type.UserType_C_HassouKbn;
import yuyu.def.db.type.UserType_C_Hrkkeiro;
import yuyu.def.db.type.UserType_C_Skszumiflg;
import yuyu.def.db.type.UserType_C_SyoruiCdKbn;

/**
 * 口座振替未入通知テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_KouzahuriMinyuTuuti extends AbstractExDBTable<IT_KouzahuriMinyuTuuti> {

    public GenQIT_KouzahuriMinyuTuuti() {
        this("IT_KouzahuriMinyuTuuti");
    }

    public GenQIT_KouzahuriMinyuTuuti(String pAlias) {
        super("IT_KouzahuriMinyuTuuti", IT_KouzahuriMinyuTuuti.class, pAlias);
    }

    public String IT_KouzahuriMinyuTuuti() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_KouzahuriMinyuTuuti, String> kbnkey = new ExDBFieldString<>("kbnkey", this);

    public final ExDBFieldString<IT_KouzahuriMinyuTuuti, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_KouzahuriMinyuTuuti, BizDate> tyouhyouymd = new ExDBFieldString<>("tyouhyouymd", this, BizDateType.class);

    public final ExDBFieldString<IT_KouzahuriMinyuTuuti, C_SyoruiCdKbn> syoruiCd = new ExDBFieldString<>("syoruiCd", this, UserType_C_SyoruiCdKbn.class);

    public final ExDBFieldString<IT_KouzahuriMinyuTuuti, C_HassouKbn> hassoukbn = new ExDBFieldString<>("hassoukbn", this, UserType_C_HassouKbn.class);

    public final ExDBFieldString<IT_KouzahuriMinyuTuuti, String> shskyno = new ExDBFieldString<>("shskyno", this);

    public final ExDBFieldString<IT_KouzahuriMinyuTuuti, String> shsadr1kj = new ExDBFieldString<>("shsadr1kj", this);

    public final ExDBFieldString<IT_KouzahuriMinyuTuuti, String> shsadr2kj = new ExDBFieldString<>("shsadr2kj", this);

    public final ExDBFieldString<IT_KouzahuriMinyuTuuti, String> shsadr3kj = new ExDBFieldString<>("shsadr3kj", this);

    public final ExDBFieldString<IT_KouzahuriMinyuTuuti, String> shsnmkj = new ExDBFieldString<>("shsnmkj", this);

    public final ExDBFieldString<IT_KouzahuriMinyuTuuti, String> toiawasesosikinmkj = new ExDBFieldString<>("toiawasesosikinmkj", this);

    public final ExDBFieldString<IT_KouzahuriMinyuTuuti, String> toiawaseyno = new ExDBFieldString<>("toiawaseyno", this);

    public final ExDBFieldString<IT_KouzahuriMinyuTuuti, String> toiawaseadr1kj = new ExDBFieldString<>("toiawaseadr1kj", this);

    public final ExDBFieldString<IT_KouzahuriMinyuTuuti, String> toiawaseadr2kj = new ExDBFieldString<>("toiawaseadr2kj", this);

    public final ExDBFieldString<IT_KouzahuriMinyuTuuti, String> toiawaseadr3kj = new ExDBFieldString<>("toiawaseadr3kj", this);

    public final ExDBFieldString<IT_KouzahuriMinyuTuuti, String> toiawasetelno = new ExDBFieldString<>("toiawasetelno", this);

    public final ExDBFieldString<IT_KouzahuriMinyuTuuti, String> toiawaseteluktkkanou1 = new ExDBFieldString<>("toiawaseteluktkkanou1", this);

    public final ExDBFieldString<IT_KouzahuriMinyuTuuti, String> toiawaseteluktkkanou2 = new ExDBFieldString<>("toiawaseteluktkkanou2", this);

    public final ExDBFieldString<IT_KouzahuriMinyuTuuti, String> toiawasesosikinmkj2 = new ExDBFieldString<>("toiawasesosikinmkj2", this);

    public final ExDBFieldString<IT_KouzahuriMinyuTuuti, String> toiawasetelno2 = new ExDBFieldString<>("toiawasetelno2", this);

    public final ExDBFieldString<IT_KouzahuriMinyuTuuti, String> tuutinm30keta = new ExDBFieldString<>("tuutinm30keta", this);

    public final ExDBFieldString<IT_KouzahuriMinyuTuuti, String> minyuttmsg1 = new ExDBFieldString<>("minyuttmsg1", this);

    public final ExDBFieldString<IT_KouzahuriMinyuTuuti, String> minyuttmsg2 = new ExDBFieldString<>("minyuttmsg2", this);

    public final ExDBFieldString<IT_KouzahuriMinyuTuuti, String> minyuttmsg3 = new ExDBFieldString<>("minyuttmsg3", this);

    public final ExDBFieldString<IT_KouzahuriMinyuTuuti, String> minyuttmsg4 = new ExDBFieldString<>("minyuttmsg4", this);

    public final ExDBFieldString<IT_KouzahuriMinyuTuuti, String> minyuttmsg5 = new ExDBFieldString<>("minyuttmsg5", this);

    public final ExDBFieldString<IT_KouzahuriMinyuTuuti, String> minyuttmsg6 = new ExDBFieldString<>("minyuttmsg6", this);

    public final ExDBFieldString<IT_KouzahuriMinyuTuuti, String> minyuttmsg7 = new ExDBFieldString<>("minyuttmsg7", this);

    public final ExDBFieldString<IT_KouzahuriMinyuTuuti, String> minyuttmsg8 = new ExDBFieldString<>("minyuttmsg8", this);

    public final ExDBFieldString<IT_KouzahuriMinyuTuuti, String> minyuttmsg9 = new ExDBFieldString<>("minyuttmsg9", this);

    public final ExDBFieldString<IT_KouzahuriMinyuTuuti, String> minyuttmsg10 = new ExDBFieldString<>("minyuttmsg10", this);

    public final ExDBFieldString<IT_KouzahuriMinyuTuuti, String> minyuttmsg11 = new ExDBFieldString<>("minyuttmsg11", this);

    public final ExDBFieldString<IT_KouzahuriMinyuTuuti, String> minyuttmsg12 = new ExDBFieldString<>("minyuttmsg12", this);

    public final ExDBFieldString<IT_KouzahuriMinyuTuuti, String> pannainm = new ExDBFieldString<>("pannainm", this);

    public final ExDBFieldString<IT_KouzahuriMinyuTuuti, String> hrkhou12keta = new ExDBFieldString<>("hrkhou12keta", this);

    public final ExDBFieldString<IT_KouzahuriMinyuTuuti, String> hhknnmkj = new ExDBFieldString<>("hhknnmkj", this);

    public final ExDBFieldString<IT_KouzahuriMinyuTuuti, String> nexthurikaenaiyou1 = new ExDBFieldString<>("nexthurikaenaiyou1", this);

    public final ExDBFieldString<IT_KouzahuriMinyuTuuti, String> nexthurikaenaiyou2 = new ExDBFieldString<>("nexthurikaenaiyou2", this);

    public final ExDBFieldString<IT_KouzahuriMinyuTuuti, String> nexthurikaenaiyou3 = new ExDBFieldString<>("nexthurikaenaiyou3", this);

    public final ExDBFieldString<IT_KouzahuriMinyuTuuti, String> saikokutukiyykkn1 = new ExDBFieldString<>("saikokutukiyykkn1", this);

    public final ExDBFieldString<IT_KouzahuriMinyuTuuti, String> saikokutukiyykkn2 = new ExDBFieldString<>("saikokutukiyykkn2", this);

    public final ExDBFieldString<IT_KouzahuriMinyuTuuti, String> hrkmirmsg1 = new ExDBFieldString<>("hrkmirmsg1", this);

    public final ExDBFieldString<IT_KouzahuriMinyuTuuti, String> hrkmirmsg2 = new ExDBFieldString<>("hrkmirmsg2", this);

    public final ExDBFieldString<IT_KouzahuriMinyuTuuti, String> hrkmirmsg3 = new ExDBFieldString<>("hrkmirmsg3", this);

    public final ExDBFieldString<IT_KouzahuriMinyuTuuti, String> zenhurikaenaiyou1 = new ExDBFieldString<>("zenhurikaenaiyou1", this);

    public final ExDBFieldString<IT_KouzahuriMinyuTuuti, String> zenhurikaenaiyou2 = new ExDBFieldString<>("zenhurikaenaiyou2", this);

    public final ExDBFieldString<IT_KouzahuriMinyuTuuti, String> zenhurikaenaiyou3 = new ExDBFieldString<>("zenhurikaenaiyou3", this);

    public final ExDBFieldString<IT_KouzahuriMinyuTuuti, String> zenhurikaenaiyou4 = new ExDBFieldString<>("zenhurikaenaiyou4", this);

    public final ExDBFieldString<IT_KouzahuriMinyuTuuti, String> hurikaekz37keta1 = new ExDBFieldString<>("hurikaekz37keta1", this);

    public final ExDBFieldString<IT_KouzahuriMinyuTuuti, String> hurikaekz37keta2 = new ExDBFieldString<>("hurikaekz37keta2", this);

    public final ExDBFieldString<IT_KouzahuriMinyuTuuti, String> hurikaekz37keta3 = new ExDBFieldString<>("hurikaekz37keta3", this);

    public final ExDBFieldString<IT_KouzahuriMinyuTuuti, String> hurikaekz37keta4 = new ExDBFieldString<>("hurikaekz37keta4", this);

    public final ExDBFieldString<IT_KouzahuriMinyuTuuti, String> hurikaekz37keta5 = new ExDBFieldString<>("hurikaekz37keta5", this);

    public final ExDBFieldString<IT_KouzahuriMinyuTuuti, String> hurikaekz37keta6 = new ExDBFieldString<>("hurikaekz37keta6", this);

    public final ExDBFieldString<IT_KouzahuriMinyuTuuti, String> minyuttaddmsg1 = new ExDBFieldString<>("minyuttaddmsg1", this);

    public final ExDBFieldString<IT_KouzahuriMinyuTuuti, String> minyuttaddmsg2 = new ExDBFieldString<>("minyuttaddmsg2", this);

    public final ExDBFieldString<IT_KouzahuriMinyuTuuti, String> minyuttaddmsg3 = new ExDBFieldString<>("minyuttaddmsg3", this);

    public final ExDBFieldString<IT_KouzahuriMinyuTuuti, String> minyuttaddmsg4 = new ExDBFieldString<>("minyuttaddmsg4", this);

    public final ExDBFieldString<IT_KouzahuriMinyuTuuti, String> minyuttaddmsg5 = new ExDBFieldString<>("minyuttaddmsg5", this);

    public final ExDBFieldString<IT_KouzahuriMinyuTuuti, String> minyuttaddmsg6 = new ExDBFieldString<>("minyuttaddmsg6", this);

    public final ExDBFieldString<IT_KouzahuriMinyuTuuti, String> minyuttaddmsg7 = new ExDBFieldString<>("minyuttaddmsg7", this);

    public final ExDBFieldString<IT_KouzahuriMinyuTuuti, String> minyuttaddmsg8 = new ExDBFieldString<>("minyuttaddmsg8", this);

    public final ExDBFieldString<IT_KouzahuriMinyuTuuti, String> minyuttaddmsg9 = new ExDBFieldString<>("minyuttaddmsg9", this);

    public final ExDBFieldString<IT_KouzahuriMinyuTuuti, String> minyuttaddmsg10 = new ExDBFieldString<>("minyuttaddmsg10", this);

    public final ExDBFieldString<IT_KouzahuriMinyuTuuti, String> minyuttaddmsg11 = new ExDBFieldString<>("minyuttaddmsg11", this);

    public final ExDBFieldString<IT_KouzahuriMinyuTuuti, String> minyuttaddmsg12 = new ExDBFieldString<>("minyuttaddmsg12", this);

    public final ExDBFieldString<IT_KouzahuriMinyuTuuti, String> minyuttaddmsg13 = new ExDBFieldString<>("minyuttaddmsg13", this);

    public final ExDBFieldString<IT_KouzahuriMinyuTuuti, String> minyuttaddmsg14 = new ExDBFieldString<>("minyuttaddmsg14", this);

    public final ExDBFieldString<IT_KouzahuriMinyuTuuti, String> minyuttaddmsg15 = new ExDBFieldString<>("minyuttaddmsg15", this);

    public final ExDBFieldString<IT_KouzahuriMinyuTuuti, String> minyuttaddmsg16 = new ExDBFieldString<>("minyuttaddmsg16", this);

    public final ExDBFieldString<IT_KouzahuriMinyuTuuti, String> minyuttaddmsg17 = new ExDBFieldString<>("minyuttaddmsg17", this);

    public final ExDBFieldString<IT_KouzahuriMinyuTuuti, String> minyuttaddmsg18 = new ExDBFieldString<>("minyuttaddmsg18", this);

    public final ExDBFieldString<IT_KouzahuriMinyuTuuti, String> minyuttaddmsg19 = new ExDBFieldString<>("minyuttaddmsg19", this);

    public final ExDBFieldString<IT_KouzahuriMinyuTuuti, String> minyuttaddmsg20 = new ExDBFieldString<>("minyuttaddmsg20", this);

    public final ExDBFieldString<IT_KouzahuriMinyuTuuti, String> minyuttaddmsg21 = new ExDBFieldString<>("minyuttaddmsg21", this);

    public final ExDBFieldString<IT_KouzahuriMinyuTuuti, String> tuutisyuruicd = new ExDBFieldString<>("tuutisyuruicd", this);

    public final ExDBFieldString<IT_KouzahuriMinyuTuuti, C_Skszumiflg> saikokutuutizumiflg = new ExDBFieldString<>("saikokutuutizumiflg", this, UserType_C_Skszumiflg.class);

    public final ExDBFieldString<IT_KouzahuriMinyuTuuti, C_AsTyouhyoukigouKbn> tyouhyoukigoukbn = new ExDBFieldString<>("tyouhyoukigoukbn", this, UserType_C_AsTyouhyoukigouKbn.class);

    public final ExDBFieldString<IT_KouzahuriMinyuTuuti, C_Hrkkeiro> hrkkeiro = new ExDBFieldString<>("hrkkeiro", this, UserType_C_Hrkkeiro.class);

    public final ExDBFieldString<IT_KouzahuriMinyuTuuti, BizDateYM> jkipjytym = new ExDBFieldString<>("jkipjytym", this, BizDateYMType.class);

    public final ExDBFieldString<IT_KouzahuriMinyuTuuti, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_KouzahuriMinyuTuuti, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_KouzahuriMinyuTuuti, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
