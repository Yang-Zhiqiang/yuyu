CREATE TABLE ZT_SmbcGetujiKykMeisaiTy (
     ztydatakijyunymd                                   VARCHAR     (8)                                                       NOT NULL  ,  /* （中継用）データ基準年月日 */
     ztydatakijyunym                                    VARCHAR     (6)                                                       NOT NULL  ,  /* （中継用）データ基準年月 */
     ztysyono                                           VARCHAR     (11)                                                      NOT NULL  ,  /* （中継用）証券番号 */
     ztyaatukaidirtncd                                  VARCHAR     (7)                                                                 ,  /* （中継用）Ａ扱代理店コード */
     ztybatukaidirtncd                                  VARCHAR     (7)                                                                 ,  /* （中継用）Ｂ扱代理店コード */
     ztyaatukaibosyuunincd                              VARCHAR     (6)                                                                 ,  /* （中継用）Ａ扱募集人コード */
     ztybatukaibosyuunincd                              VARCHAR     (6)                                                                 ,  /* （中継用）Ｂ扱募集人コード */
     ztyhknsyukigou                                     VARCHAR     (2)                                                                 ,  /* （中継用）保険種類記号 */
     ztyhknsyuruikigousedaikbn                          VARCHAR     (1)                                                                 ,  /* （中継用）保険種類記号世代区分 */
     ztymdhnaisyoumeicd                                 VARCHAR     (3)                                                                 ,  /* （中継用）窓販用愛称名コード */
     ztytuukacdsmbcgetuji                               VARCHAR     (2)                                                                 ,  /* （中継用）通貨コード（ＳＭＢＣ月次契約Ｆ） */
     ztyhrkhuhukbn                                      VARCHAR     (1)                                                                 ,  /* （中継用）払込方法区分 */
     ztykyknmknsmbcgetuji                               VARCHAR     (70)                                                                ,  /* （中継用）契約者名（カナ）（ＳＭＢＣ月次契約Ｆ） */
     ztykyknmkjsmbcgetuji                               VARCHAR     (35)                                                                ,  /* （中継用）契約者名（漢字）（ＳＭＢＣ月次契約Ｆ） */
     ztyhhknnmkjsmbcgetuji                              VARCHAR     (35)                                                                ,  /* （中継用）被保険者名（漢字）（ＳＭＢＣ月次契約Ｆ） */
     ztyitijibrp                                        NUMBER      (11)                                                                ,  /* （中継用）一時払保険料 */
     ztygoukeip2                                        NUMBER      (11)                                                                ,  /* （中継用）合計保険料２ */
     ztyzenkizennoup                                    NUMBER      (11)                                                                ,  /* （中継用）全期前納保険料 */
     ztytumitatekngk                                    NUMBER      (11)                                                                ,  /* （中継用）積立金額 */
     ztytargettktoutatubi                               VARCHAR     (8)                                                                 ,  /* （中継用）ターゲット到達日 */
     ztymokuhyouti                                      NUMBER      (3)                                                                 ,  /* （中継用）目標値 */
     ztymokuhyoukngk                                    NUMBER      (11)                                                                ,  /* （中継用）目標金額 */
     ztykaiyakuhr                                       NUMBER      (11)                                                                ,  /* （中継用）解約返戻金 */
     ztyhrkpjyuutouym                                   VARCHAR     (6)                                                                 ,  /* （中継用）払込保険料充当年月 */
     ztykihrpruikeigk                                   NUMBER      (11)                                                                ,  /* （中継用）既払保険料累計額 */
     ztytousyokykjikawaserate                           NUMBER      (7,2)                                                               ,  /* （中継用）当初契約時為替レート */
     ztykykymd                                          VARCHAR     (8)                                                                 ,  /* （中継用）契約年月日 */
     ztymankiymd                                        VARCHAR     (8)                                                                 ,  /* （中継用）満期年月日 */
     ztyikkatubaraikbn                                  VARCHAR     (1)                                                                 ,  /* （中継用）一括払区分 */
     ztyikkatubaraikaisuu                               VARCHAR     (2)                                                                 ,  /* （中継用）一括払回数 */
     ztyyobiv56                                         VARCHAR     (56)                                                                ,  /* （中継用）予備項目Ｖ５６ */
     ztygmeigyoubijikawaserate                          NUMBER      (7,2)                                                               ,  /* （中継用）月末営業日時為替レート */
     ztyyobiv16                                         VARCHAR     (16)                                                                ,  /* （中継用）予備項目Ｖ１６ */
     ztysymtymd                                         VARCHAR     (8)                                                                 ,  /* （中継用）消滅年月日 */
     ztygetumatuymdidouw                                NUMBER      (11)                                                                ,  /* （中継用）月末日異動解約返戻金 */
     ztygetumatuymdsibous                               NUMBER      (11)                                                                ,  /* （中継用）月末日死亡保険金 */
     ztyyobiv53                                         VARCHAR     (53)                                                                ,  /* （中継用）予備項目Ｖ５３ */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE ZT_SmbcGetujiKykMeisaiTy ADD CONSTRAINT PK_SmbcGetujiKykMeisaiTy PRIMARY KEY (
     ztydatakijyunymd                                         , /* （中継用）データ基準年月日 */
     ztydatakijyunym                                          , /* （中継用）データ基準年月 */
     ztysyono                                                   /* （中継用）証券番号 */
) ;
