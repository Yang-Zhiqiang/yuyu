package yuyu.batch.hozen.khansyuu.khpminyuusyoumetuskkansyousel.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.db.meta.QBM_SyouhnZokusei;
import yuyu.def.db.meta.QIT_HhknSya;
import yuyu.def.db.meta.QIT_KykKihon;
import yuyu.def.db.meta.QIT_KykSya;
import yuyu.def.db.meta.QIT_KykSyouhn;
import yuyu.def.db.meta.QIT_PMinyuuSyoumetuInfo;

/**
 * 契約保全 案内収納 Ｐ未入消滅請求勧奨抽出DAOクラス
 * @author  富江
 * @version 2019/06/04 富江 : 新規作成<br />
 */
public class KhPMinyuuSyoumetuSkKansyouSelDao {

    /** 機能拡張エンティティマネージャ */
    @Inject
    private ExDBEntityManager exDBEntityManager;

    /**
     * Ｐ未入消滅請求勧奨情報取得（処理年月指定）<br />
     * 拡張ジョブコード、処理年月日を指定して、Ｐ未入消滅請求勧奨情報Beanリスト（大量）を取得します。<br />
     * @param pKakutyoujobcd     拡張ジョブコード<br />
     * @param pSyoriYm           処理年月<br />
     * @return Ｐ未入消滅請求勧奨情報Beanリスト（大量）<br />
     */
    public ExDBResults<PMinyuuSyoumetuSkKansyouInfosBean> getPMinyuuSyoumetuSkKansyouInfos(String pKakutyoujobcd,
        BizDateYM pSyoriYm) {

        // WK．契約基本テーブルエンティティメタデータ
        QIT_KykKihon qIT_KykKihon = new QIT_KykKihon("qIT_KykKihon");

        // WK．契約商品テーブルエンティティメタデータ
        QIT_KykSyouhn qIT_KykSyouhn = new QIT_KykSyouhn("qIT_KykSyouhn");

        // WK．商品属性マスタエンティティメタデータ
        QBM_SyouhnZokusei qBM_SyouhnZokusei = new QBM_SyouhnZokusei("qBM_SyouhnZokusei");

        // WK．契約者テーブルエンティティメタデータ
        QIT_KykSya qIT_KykSya = new QIT_KykSya("qIT_KykSya");

        // WK．被保険者テーブルエンティティメタデータ
        QIT_HhknSya qIT_HhknSya = new QIT_HhknSya("qIT_HhknSya");

        // WK．Ｐ未入消滅情報テーブルエンティティメタデータ
        QIT_PMinyuuSyoumetuInfo qIT_PMinyuuSyoumetuInfo = new QIT_PMinyuuSyoumetuInfo("qIT_PMinyuuSyoumetuInfo");

        String strSql = $SELECT + $NEW(PMinyuuSyoumetuSkKansyouInfosBean.class,
            qIT_KykKihon,                                                                   // WK．契約基本テーブルエンティティメタデータ
            qIT_KykSyouhn,                                                                  // WK．契約商品テーブルエンティティメタデータ
            qBM_SyouhnZokusei,                                                              // WK．商品属性マスタエンティティメタデータ
            qIT_KykSya,                                                                     // WK．契約者テーブルエンティティメタデータ
            qIT_HhknSya,                                                                    // WK．被保険者テーブルエンティティメタデータ
            qIT_PMinyuuSyoumetuInfo) +                                                      // WK．Ｐ未入消滅情報テーブルエンティティメタデータ
            $FROM (qIT_KykKihon,                                                            // WK．契約基本テーブルエンティティメタデータ．エイリアス付き名称
                qIT_KykSyouhn,                                                              // WK．契約商品テーブルエンティティメタデータ．エイリアス付き名称
                qBM_SyouhnZokusei,                                                          // WK．商品属性マスタエンティティメタデータ．エイリアス付き名称
                qIT_KykSya,                                                                 // WK．契約者テーブルエンティティメタデータ．エイリアス付き名称
                qIT_HhknSya,                                                                // WK．被保険者テーブルエンティティメタデータ．エイリアス付き名称
                qIT_PMinyuuSyoumetuInfo)  +                                                 // WK．Ｐ未入消滅情報テーブルエンティティメタデータ．エイリアス付き名称
                $WHERE + qIT_KykKihon.syono.eq(qIT_KykSyouhn.syono) +                       // WK．契約基本テーブルエンティティメタデータ．証券番号 = WK．契約商品テーブルエンティティメタデータ．証券番号
                $AND + qIT_KykKihon.syono.eq(qIT_KykSya.syono) +                            // WK．契約基本テーブルエンティティメタデータ．証券番号 = WK．契約者テーブルエンティティメタデータ．証券番号
                $AND + qIT_KykKihon.syono.eq(qIT_HhknSya.syono) +                           // WK．契約基本テーブルエンティティメタデータ．証券番号 = WK．被保険者テーブルエンティティメタデータ．証券番号
                $AND + qIT_KykKihon.syono.eq(qIT_PMinyuuSyoumetuInfo.syono) +               // WK．契約基本テーブルエンティティメタデータ．証券番号 = WK．Ｐ未入消滅情報テーブルエンティティメタデータ．証券番号
                $AND + qIT_KykSyouhn.syouhncd.eq(qBM_SyouhnZokusei.syouhncd) +              // WK．契約商品テーブルエンティティメタデータ．商品コード =  WK．商品属性マスタエンティティメタデータ．商品コード
                $AND + qIT_KykSyouhn.syouhnsdno.eq(qBM_SyouhnZokusei.syouhnsdno) +          // WK．契約商品テーブルエンティティメタデータ．商品世代番号 =  WK．商品属性マスタエンティティメタデータ．商品世代番号
                $AND + qIT_PMinyuuSyoumetuInfo.syoriym.le(pSyoriYm) +                       // WK．Ｐ未入消滅情報テーブルエンティティメタデータ．処理年月 ≦ I．処理年月
                $AND + qIT_KykSyouhn.yuukousyoumetukbn.eq(C_YuukousyoumetuKbn.SYOUMETU) +   // WK．契約商品テーブルエンティティメタデータ．有効消滅区分 = <有効消滅区分>消滅
                $AND + qIT_KykSyouhn.syoumetujiyuu.eq(C_Syoumetujiyuu.PMNYSYMET_MSSN) +     // WK．契約商品テーブルエンティティメタデータ．消滅事由 = <消滅事由>Ｐ未入消滅（未精算）
                $ORDER_BY  (qIT_PMinyuuSyoumetuInfo.syoumetuymd.asc(),                      // （WK．Ｐ未入消滅情報テーブルエンティティメタデータ．消滅日(昇順)
                    qIT_KykKihon.syono.asc());                                              // WK．契約基本テーブルエンティティメタデータ．証券番号(昇順)）

        // クエリ実行
        ExDBResults<PMinyuuSyoumetuSkKansyouInfosBean> exDBResults = exDBEntityManager.createJPQL(strSql,
            PMinyuuSyoumetuSkKansyouInfosBean.class).bind(qIT_KykKihon, qIT_KykSyouhn, qBM_SyouhnZokusei,
                qIT_KykSya, qIT_HhknSya, qIT_PMinyuuSyoumetuInfo).getResults();

        // 【Ｐ未入消滅請求勧奨情報Beanリスト（大量）＃setFilter】を実行する
        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        // 結果返却
        return exDBResults;
    }
}