CREATE TABLE BT_Nyknmeisai_Z (
     hrkmdatakbn1                                       VARCHAR     (1)                                                                 ,  /* （振込用）データ区分１ */
     hrkmsyubetucd                                      VARCHAR     (2)                                                                 ,  /* （振込用）種別コード */
     hrkmcdkbn                                          VARCHAR     (1)                                                                 ,  /* （振込用）コード区分 */
     hrkmsakuseiymd6keta                                VARCHAR     (6)                                                       NOT NULL  ,  /* （振込用）作成日６桁 */
     hrkmknjyymdfrom6keta                               VARCHAR     (6)                                                                 ,  /* （振込用）勘定日（自）６桁 */
     hrkmknjyymdto6keta                                 VARCHAR     (6)                                                                 ,  /* （振込用）勘定日（至）６桁 */
     hrkmbankcd                                         VARCHAR     (4)                                                       NOT NULL  ,  /* （振込用）銀行番号 */
     hrkmbanknmkn                                       VARCHAR     (32)                                                                ,  /* （振込用）銀行名（カナ） */
     hrkmshitencd                                       VARCHAR     (3)                                                       NOT NULL  ,  /* （振込用）支店番号 */
     hrkmsitennmkn                                      VARCHAR     (32)                                                                ,  /* （振込用）支店名（カナ） */
     hrkmyobiv3                                         VARCHAR     (3)                                                                 ,  /* （振込用）予備項目Ｖ３ */
     hrkmyokinkbn                                       VARCHAR     (1)                                                       NOT NULL  ,  /* （振込用）預金種目区分 */
     hrkmkouzano                                        VARCHAR     (10)                                                      NOT NULL  ,  /* （振込用）口座番号 */
     hrkmkznmkn                                         VARCHAR     (82)                                                                ,  /* （振込用）口座名（カナ） */
     hrkmkasikosikbn                                    VARCHAR     (1)                                                                 ,  /* （振込用）貸越区分 */
     hrkmtuutyousysykbn                                 VARCHAR     (1)                                                                 ,  /* （振込用）通帳・証書区分 */
     hrkmtrhkmaezndk                                    VARCHAR     (14)                                                                ,  /* （振込用）取引前残高 */
     hrkmyobiv63                                        VARCHAR     (63)                                                                ,  /* （振込用）予備項目Ｖ６３ */
     hrkmrenno8                                         VARCHAR     (8)                                                       NOT NULL  ,  /* （振込用）連番８桁 */
     hrkmdatakbn2                                       VARCHAR     (1)                                                                 ,  /* （振込用）データ区分２ */
     hrkmsyoukaino                                      VARCHAR     (8)                                                       NOT NULL  ,  /* （振込用）照会番号 */
     hrkmknjyymd6keta                                   VARCHAR     (6)                                                                 ,  /* （振込用）勘定日６桁 */
     hrkmazkrhrdsymd6keta                               VARCHAR     (6)                                                                 ,  /* （振込用）預入・払出日６桁 */
     hrkmiribaraikbn                                    VARCHAR     (1)                                                                 ,  /* （振込用）入払区分 */
     hrkmtrhkkbn                                        VARCHAR     (2)                                                                 ,  /* （振込用）取引区分 */
     hrkmtrhkgk                                         VARCHAR     (12)                                                                ,  /* （振込用）取引金額 */
     hrkmtatenkengk                                     VARCHAR     (12)                                                                ,  /* （振込用）うち他店券金額 */
     hrkmkknteijiymd6keta                               VARCHAR     (6)                                                                 ,  /* （振込用）交換呈示日６桁 */
     hrkmhwtrhnknymd6keta                               VARCHAR     (6)                                                                 ,  /* （振込用）不渡返還日６桁 */
     hrkmtgtkgtkbn                                      VARCHAR     (1)                                                                 ,  /* （振込用）手形・小切手区分 */
     hrkmtgtkgtno                                       VARCHAR     (7)                                                                 ,  /* （振込用）手形・小切手番号 */
     hrkmryoutenno                                      VARCHAR     (3)                                                                 ,  /* （振込用）僚店番号 */
     hrkmhrkmirnincd                                    VARCHAR     (10)                                                                ,  /* （振込用）振込依頼人コード */
     hrkmhrkmirninnm                                    VARCHAR     (48)                                                                ,  /* （振込用）振込依頼人名 */
     hrkmsimukebanknmkn                                 VARCHAR     (32)                                                                ,  /* （振込用）仕向銀行名 */
     hrkmsimuketennmkn                                  VARCHAR     (32)                                                                ,  /* （振込用）仕向店名 */
     hrkmtekiyounaiyou                                  VARCHAR     (42)                                                                ,  /* （振込用）摘要内容 */
     hrkmediinfo                                        VARCHAR     (20)                                                                ,  /* （振込用）ＥＤＩ情報 */
     hrkmyobiv1                                         VARCHAR     (1)                                                                 ,  /* （振込用）予備項目Ｖ１ */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                             ,  /* バージョン */
     hrkmrensakuseiymd6keta                             VARCHAR     (6)                                                                    /* （振込用）連動元作成日６桁 */
)
;

ALTER TABLE BT_Nyknmeisai_Z ADD CONSTRAINT PK_Nyknmeisai PRIMARY KEY (
     hrkmsakuseiymd6keta                                      , /* （振込用）作成日６桁 */
     hrkmbankcd                                               , /* （振込用）銀行番号 */
     hrkmshitencd                                             , /* （振込用）支店番号 */
     hrkmyokinkbn                                             , /* （振込用）預金種目区分 */
     hrkmkouzano                                              , /* （振込用）口座番号 */
     hrkmsyoukaino                                            , /* （振込用）照会番号 */
     hrkmrenno8                                                 /* （振込用）連番８桁 */
) ;
