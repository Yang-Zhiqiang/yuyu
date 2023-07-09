CREATE TABLE IT_BAK_KihrkmpSeisanRireki_Z (
     kbnkey                                             VARCHAR     (2)                                                       NOT NULL  ,  /* 区分キー */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     trkssikibetukey                                    VARCHAR     (18)                                                      NOT NULL  ,  /* 取消識別キー */
     renno                                              DECIMAL     (2)                                                       NOT NULL  ,  /* 連番 */
     henkousikibetukey                                  VARCHAR     (18)                                                                ,  /* 変更識別キー */
     kouryokuhasseiymd                                  VARCHAR     (8)                                                                 ,  /* 効力発生日 */
     kihrkpssnaiyoukbn                                  VARCHAR     (1)                                                                 ,  /* 既払込Ｐ精算内容区分 */
     jyuutouym                                          VARCHAR     (6)                                                                 ,  /* 充当年月 */
     seijyutoukaisuum                                   DECIMAL     (5)                                                                 ,  /* 精算充当回数（月） */
     seijyutoukaisuuy                                   DECIMAL     (5)                                                                 ,  /* 精算充当回数（年） */
     misyuumikeikakbn                                   VARCHAR     (1)                                                                 ,  /* 未収未経過区分 */
     rstuukasyu                                         VARCHAR     (3)                                                                 ,  /* 領収通貨種類 */
     seisanpgoukei                                      DECIMAL     (13)                                                                ,  /* 精算保険料合計 */
     seisanpgoukei$                                     VARCHAR     (10)                                                                ,  /* 精算保険料合計(通貨型) */
     yenkansansspgoukei                                 DECIMAL     (13)                                                                ,  /* 円換算精算保険料合計 */
     yenkansansspgoukei$                                VARCHAR     (10)                                                                ,  /* 円換算精算保険料合計(通貨型) */
     yenkansantkykwsrateymd                             VARCHAR     (8)                                                                 ,  /* 円換算適用為替レート基準日 */
     yenkansantkykwsrate                                DECIMAL     (7,4)                                                               ,  /* 円換算適用為替レート */
     henkank                                            DECIMAL     (13)                                                                ,  /* 返還金 */
     henkank$                                           VARCHAR     (10)                                                                ,  /* 返還金(通貨型) */
     yenkansanhenkankin                                 DECIMAL     (13)                                                                ,  /* 円換算返還金 */
     yenkansanhenkankin$                                VARCHAR     (10)                                                                ,  /* 円換算返還金(通貨型) */
     tuityouk                                           DECIMAL     (13)                                                                ,  /* 追徴金 */
     tuityouk$                                          VARCHAR     (10)                                                                ,  /* 追徴金(通貨型) */
     yenkansantuityoukin                                DECIMAL     (13)                                                                ,  /* 円換算追徴金 */
     yenkansantuityoukin$                               VARCHAR     (10)                                                                ,  /* 円換算追徴金(通貨型) */
     zeimukwsratekjnymd                                 VARCHAR     (8)                                                                 ,  /* 税務用為替レート基準日 */
     zeimukwsrate                                       DECIMAL     (7,4)                                                               ,  /* 税務用為替レート */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                             ,  /* バージョン */
     hituyoukeihiitijisytktysgk                         DECIMAL     (13)                                                                ,  /* 必要経費一時所得調整額 */
     hituyoukeihiitijisytktysgk$                        VARCHAR     (10)                                                                   /* 必要経費一時所得調整額(通貨型) */
)
;

ALTER TABLE IT_BAK_KihrkmpSeisanRireki_Z ADD CONSTRAINT PK_BAK_KihrkmpSeisanRireki PRIMARY KEY (
     kbnkey                                                   , /* 区分キー */
     syono                                                    , /* 証券番号 */
     trkssikibetukey                                          , /* 取消識別キー */
     renno                                                      /* 連番 */
) ;
