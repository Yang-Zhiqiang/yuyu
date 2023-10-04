package yuyu.batch.hozen.khinterf.khminyuutuutifilesks.dba;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_AsTyouhyoukigouKbn;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_SyoruiCdKbn;

/**
 * 契約保全 インターフェイス 未入通知Ｆ作成Beanクラス
 */
@AllArgsConstructor
public class KhMinyuuTuutiBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private String kbnkey;

    @Getter @Setter
    private String syono;

    @Getter @Setter
    private BizDate tyouhyouymd;

    @Getter @Setter
    private C_SyoruiCdKbn syoruiCd;

    @Getter @Setter
    private C_HassouKbn hassoukbn;

    @Getter @Setter
    private String shskyno;

    @Getter @Setter
    private String shsadr1kj;

    @Getter @Setter
    private String shsadr2kj;

    @Getter @Setter
    private String shsadr3kj;

    @Getter @Setter
    private String shsnmkj;

    @Getter @Setter
    private String toiawasesosikinmkj;

    @Getter @Setter
    private String toiawaseyno;

    @Getter @Setter
    private String toiawaseadr1kj;

    @Getter @Setter
    private String toiawaseadr2kj;

    @Getter @Setter
    private String toiawaseadr3kj;

    @Getter @Setter
    private String toiawasetelno;

    @Getter @Setter
    private String toiawaseteluktkkanou1;

    @Getter @Setter
    private String toiawaseteluktkkanou2;

    @Getter @Setter
    private String toiawasesosikinmkj2;

    @Getter @Setter
    private String toiawasetelno2;

    @Getter @Setter
    private String tuutinm30keta;

    @Getter @Setter
    private String minyuttmsg1;

    @Getter @Setter
    private String minyuttmsg2;

    @Getter @Setter
    private String minyuttmsg3;

    @Getter @Setter
    private String minyuttmsg4;

    @Getter @Setter
    private String minyuttmsg5;

    @Getter @Setter
    private String minyuttmsg6;

    @Getter @Setter
    private String minyuttmsg7;

    @Getter @Setter
    private String minyuttmsg8;

    @Getter @Setter
    private String minyuttmsg9;

    @Getter @Setter
    private String minyuttmsg10;

    @Getter @Setter
    private String minyuttmsg11;

    @Getter @Setter
    private String minyuttmsg12;

    @Getter @Setter
    private String pannainm;

    @Getter @Setter
    private String hrkhou12keta;

    @Getter @Setter
    private String hhknnmkj;

    @Getter @Setter
    private String nexthurikaenaiyou1;

    @Getter @Setter
    private String nexthurikaenaiyou2;

    @Getter @Setter
    private String nexthurikaenaiyou3;

    @Getter @Setter
    private String saikokutukiyykkn1;

    @Getter @Setter
    private String saikokutukiyykkn2;

    @Getter @Setter
    private String hrkmirmsg1;

    @Getter @Setter
    private String hrkmirmsg2;

    @Getter @Setter
    private String hrkmirmsg3;

    @Getter @Setter
    private String zenhurikaenaiyou1;

    @Getter @Setter
    private String zenhurikaenaiyou2;

    @Getter @Setter
    private String zenhurikaenaiyou3;

    @Getter @Setter
    private String zenhurikaenaiyou4;

    @Getter @Setter
    private String hurikaekz37keta1;

    @Getter @Setter
    private String hurikaekz37keta2;

    @Getter @Setter
    private String hurikaekz37keta3;

    @Getter @Setter
    private String hurikaekz37keta4;

    @Getter @Setter
    private String hurikaekz37keta5;

    @Getter @Setter
    private String hurikaekz37keta6;

    @Getter @Setter
    private String minyuttaddmsg1;

    @Getter @Setter
    private String minyuttaddmsg2;

    @Getter @Setter
    private String minyuttaddmsg3;

    @Getter @Setter
    private String minyuttaddmsg4;

    @Getter @Setter
    private String minyuttaddmsg5;

    @Getter @Setter
    private String minyuttaddmsg6;

    @Getter @Setter
    private String minyuttaddmsg7;

    @Getter @Setter
    private String minyuttaddmsg8;

    @Getter @Setter
    private String minyuttaddmsg9;

    @Getter @Setter
    private String minyuttaddmsg10;

    @Getter @Setter
    private String minyuttaddmsg11;

    @Getter @Setter
    private String minyuttaddmsg12;

    @Getter @Setter
    private String minyuttaddmsg13;

    @Getter @Setter
    private String minyuttaddmsg14;

    @Getter @Setter
    private String minyuttaddmsg15;

    @Getter @Setter
    private String minyuttaddmsg16;

    @Getter @Setter
    private String minyuttaddmsg17;

    @Getter @Setter
    private String minyuttaddmsg18;

    @Getter @Setter
    private String minyuttaddmsg19;

    @Getter @Setter
    private String minyuttaddmsg20;

    @Getter @Setter
    private String minyuttaddmsg21;

    @Getter @Setter
    private String tuutisyuruicd;

    @Getter @Setter
    private C_AsTyouhyoukigouKbn tyouhyoukigoukbn;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
