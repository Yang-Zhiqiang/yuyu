package yuyu.batch.hozen.khansyuu.khgentumiskmikomirituulfsks.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.meta.QIT_KykKihon;
import yuyu.def.db.meta.QIT_KykSyouhn;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;

/**
 * 案内収納  限積用失効見込率算出用ＵＬＦ作成
 * @author  児玉　拓也
 * @version 2019/07/01 児玉　拓也 : 新規作成<br />
 */
public class KhGentumiSkMikomirituULFSksDao {

    /** 機能拡張エンティティマネージャ */
    @Inject
    private ExDBEntityManager exDBEntityManager;

    /**
     * 限積用失効見込率算出用ＵＬＦBeanリスト（大量）取得<br />
     * 限積用失効見込率算出用ＵＬＦBeanリスト（大量）を取得します。<br />
     * @return                          限積用失効見込率算出用ＵＬＦBeanリスト（大量）
     */
    public ExDBResults<GentumiSkMikomirituULFBean> getGentumiSkMikomirituULFBeans() {

        // WK．契約基本テーブルエンティティメタデータ
        QIT_KykKihon qIT_KykKihon = new QIT_KykKihon("qIT_KykKihon");
        // WK．契約商品テーブルエンティティメタデータ
        QIT_KykSyouhn qIT_KykSyouhn = new QIT_KykSyouhn("qIT_KykSyouhn");

        // クエリ作成
        String strSql = $SELECT + $NEW(GentumiSkMikomirituULFBean.class,           // $NEW（限積用失効見込率算出用ＵＬＦBeanクラス.class
            qIT_KykKihon.syono,                                                    // WK．契約基本テーブルエンティティメタデータ．証券番号
            qIT_KykSyouhn.syoumetujiyuu,                                           // WK．契約商品テーブルエンティティメタデータ．消滅事由
            qIT_KykSyouhn.syoumetuymd) +                                           // WK．契約商品テーブルエンティティメタデータ．消滅日
            $FROM(qIT_KykKihon, qIT_KykSyouhn) +                                   // WK．契約基本テーブルエンティティメタデータ, WK．契約商品テーブルエンティティメタデータ
            $WHERE + qIT_KykSyouhn.syutkkbn.eq(C_SyutkKbn.SYU) +                   // WK．契約商品テーブルエンティティメタデータ．主契約特約区分 ＝ ＜主契約特約区分＞主契約
            $AND + qIT_KykSyouhn.kykjyoutai.ne(C_Kykjyoutai.ITIJIBARAI) +          // WK．契約商品テーブルエンティティメタデータ．契約状態 ≠ ＜契約状態＞一時払い
            $AND + qIT_KykSyouhn.syoumetujiyuu.ne(C_Syoumetujiyuu.BLNK) +          // WK．契約商品テーブルエンティティメタデータ．消滅事由 ≠ ＜消滅事由＞ブランク
            $AND + qIT_KykKihon.syono.eq(qIT_KykSyouhn.syono);                     // WK．契約基本テーブルエンティティメタデータ．証券番号 ＝ WK．契約商品テーブルエンティティメタデータ．証券番号

        // 結果返却
        return exDBEntityManager.createJPQL(strSql, GentumiSkMikomirituULFBean.class).bind(qIT_KykKihon, qIT_KykSyouhn).getResults();
    }
}
