CREATE TABLE ZT_NyknmeisaiTr_Z (
     ztrdatakbn1                                        VARCHAR     (1)                                                                 ,  /* （取込用）データ区分１ */
     ztrsyubetucd                                       VARCHAR     (2)                                                                 ,  /* （取込用）種別コード */
     ztrcdkbn                                           VARCHAR     (1)                                                                 ,  /* （取込用）コード区分 */
     ztrsakuseiymd6keta                                 VARCHAR     (6)                                                       NOT NULL  ,  /* （取込用）作成日６桁 */
     ztrknjyymdfrom6keta                                VARCHAR     (6)                                                                 ,  /* （取込用）勘定日（自）６桁 */
     ztrknjyymdto6keta                                  VARCHAR     (6)                                                                 ,  /* （取込用）勘定日（至）６桁 */
     ztrbankcd                                          VARCHAR     (4)                                                       NOT NULL  ,  /* （取込用）銀行番号 */
     ztrbanknmkn                                        VARCHAR     (32)                                                                ,  /* （取込用）銀行名（カナ） */
     ztrshitencd                                        VARCHAR     (3)                                                       NOT NULL  ,  /* （取込用）支店番号 */
     ztrsitennmkn                                       VARCHAR     (32)                                                                ,  /* （取込用）支店名（カナ） */
     ztryobiv3                                          VARCHAR     (3)                                                                 ,  /* （取込用）予備項目Ｖ３ */
     ztryokinkbn                                        VARCHAR     (1)                                                       NOT NULL  ,  /* （取込用）預金種目区分 */
     ztrkouzano                                         VARCHAR     (10)                                                      NOT NULL  ,  /* （取込用）口座番号 */
     ztrkznmkn                                          VARCHAR     (82)                                                                ,  /* （取込用）口座名（カナ） */
     ztrkasikosikbn                                     VARCHAR     (1)                                                                 ,  /* （取込用）貸越区分 */
     ztrtuutyousysykbn                                  VARCHAR     (1)                                                                 ,  /* （取込用）通帳・証書区分 */
     ztrtrhkmaezndk                                     VARCHAR     (14)                                                                ,  /* （取込用）取引前残高 */
     ztryobiv63                                         VARCHAR     (63)                                                                ,  /* （取込用）予備項目Ｖ６３ */
     ztrrenno8                                          VARCHAR     (8)                                                       NOT NULL  ,  /* （取込用）連番８桁 */
     ztrdatakbn2                                        VARCHAR     (1)                                                                 ,  /* （取込用）データ区分２ */
     ztrsyoukaino                                       VARCHAR     (8)                                                       NOT NULL  ,  /* （取込用）照会番号 */
     ztrknjyymd6keta                                    VARCHAR     (6)                                                                 ,  /* （取込用）勘定日６桁 */
     ztrazkrhrdsymd6keta                                VARCHAR     (6)                                                                 ,  /* （取込用）預入・払出日６桁 */
     ztriribaraikbn                                     VARCHAR     (1)                                                                 ,  /* （取込用）入払区分 */
     ztrtrhkkbn                                         VARCHAR     (2)                                                                 ,  /* （取込用）取引区分 */
     ztrtrhkgk                                          VARCHAR     (12)                                                                ,  /* （取込用）取引金額 */
     ztrtatenkengk                                      VARCHAR     (12)                                                                ,  /* （取込用）うち他店券金額 */
     ztrkknteijiymd6keta                                VARCHAR     (6)                                                                 ,  /* （取込用）交換呈示日６桁 */
     ztrhwtrhnknymd6keta                                VARCHAR     (6)                                                                 ,  /* （取込用）不渡返還日６桁 */
     ztrtgtkgtkbn                                       VARCHAR     (1)                                                                 ,  /* （取込用）手形・小切手区分 */
     ztrtgtkgtno                                        VARCHAR     (7)                                                                 ,  /* （取込用）手形・小切手番号 */
     ztrryoutenno                                       VARCHAR     (3)                                                                 ,  /* （取込用）僚店番号 */
     ztrhrkmirnincd                                     VARCHAR     (10)                                                                ,  /* （取込用）振込依頼人コード */
     ztrhrkmirninnm                                     VARCHAR     (48)                                                                ,  /* （取込用）振込依頼人名 */
     ztrsimukebanknmkn                                  VARCHAR     (32)                                                                ,  /* （取込用）仕向銀行名 */
     ztrsimuketennmkn                                   VARCHAR     (32)                                                                ,  /* （取込用）仕向店名 */
     ztrtekiyounaiyou                                   VARCHAR     (42)                                                                ,  /* （取込用）摘要内容 */
     ztrediinfo                                         VARCHAR     (20)                                                                ,  /* （取込用）ＥＤＩ情報 */
     ztryobiv1                                          VARCHAR     (1)                                                                 ,  /* （取込用）予備項目Ｖ１ */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE ZT_NyknmeisaiTr_Z ADD CONSTRAINT PK_NyknmeisaiTr PRIMARY KEY (
     ztrsakuseiymd6keta                                       , /* （取込用）作成日６桁 */
     ztrbankcd                                                , /* （取込用）銀行番号 */
     ztrshitencd                                              , /* （取込用）支店番号 */
     ztryokinkbn                                              , /* （取込用）預金種目区分 */
     ztrkouzano                                               , /* （取込用）口座番号 */
     ztrsyoukaino                                             , /* （取込用）照会番号 */
     ztrrenno8                                                  /* （取込用）連番８桁 */
) ;
