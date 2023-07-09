CREATE TABLE BM_RateV2 (
     palhokensyuruikigou                                CHAR        (2)                                                       NOT NULL  ,  /* ＰＡＬ保険種類記号 */
     palhokensyuruikigousdicode                         CHAR        (1)                                                       NOT NULL  ,  /* ＰＡＬ保険種類記号世代コード */
     palyoteiriritu                                     CHAR        (3)                                                       NOT NULL  ,  /* ＰＡＬ予定利率 */
     palpmencode                                        CHAR        (1)                                                       NOT NULL  ,  /* ＰＡＬＰ免コード */
     palharaikomikaisuu                                 CHAR        (1)                                                       NOT NULL  ,  /* ＰＡＬ払込回数 */
     palhhknsei                                         CHAR        (1)                                                       NOT NULL  ,  /* ＰＡＬ被保険者性別 */
     palkeiyakujihhknnen                                CHAR        (3)                                                       NOT NULL  ,  /* ＰＡＬ契約時被保険者年令 */
     palsaimankihyouji                                  CHAR        (1)                                                       NOT NULL  ,  /* ＰＡＬ才満期契約表示 */
     palhokenkikan                                      CHAR        (2)                                                       NOT NULL  ,  /* ＰＡＬ保険期間 */
     palpharaikomikikan                                 CHAR        (2)                                                       NOT NULL  ,  /* ＰＡＬＰ払込期間 */
     palannaihuyouriyuukbn                              CHAR        (2)                                                       NOT NULL  ,  /* ＰＡＬ案内不要理由区分 */
     ratetuukasyukbn                                    CHAR        (1)                                                       NOT NULL  ,  /* レート用通貨種類区分 */
     ratedai1hknkkn                                     CHAR        (2)                                                       NOT NULL  ,  /* レート用第１保険期間 */
     vrate00                                            NUMBER      (9,6)                                                               ,  /* Ｖレート００ */
     vrate01                                            NUMBER      (9,6)                                                               ,  /* Ｖレート０１ */
     vrate02                                            NUMBER      (9,6)                                                               ,  /* Ｖレート０２ */
     vrate03                                            NUMBER      (9,6)                                                               ,  /* Ｖレート０３ */
     vrate04                                            NUMBER      (9,6)                                                               ,  /* Ｖレート０４ */
     vrate05                                            NUMBER      (9,6)                                                               ,  /* Ｖレート０５ */
     vrate06                                            NUMBER      (9,6)                                                               ,  /* Ｖレート０６ */
     vrate07                                            NUMBER      (9,6)                                                               ,  /* Ｖレート０７ */
     vrate08                                            NUMBER      (9,6)                                                               ,  /* Ｖレート０８ */
     vrate09                                            NUMBER      (9,6)                                                               ,  /* Ｖレート０９ */
     vrate10                                            NUMBER      (9,6)                                                               ,  /* Ｖレート１０ */
     vrate11                                            NUMBER      (9,6)                                                               ,  /* Ｖレート１１ */
     vrate12                                            NUMBER      (9,6)                                                               ,  /* Ｖレート１２ */
     vrate13                                            NUMBER      (9,6)                                                               ,  /* Ｖレート１３ */
     vrate14                                            NUMBER      (9,6)                                                               ,  /* Ｖレート１４ */
     vrate15                                            NUMBER      (9,6)                                                               ,  /* Ｖレート１５ */
     vrate16                                            NUMBER      (9,6)                                                               ,  /* Ｖレート１６ */
     vrate17                                            NUMBER      (9,6)                                                               ,  /* Ｖレート１７ */
     vrate18                                            NUMBER      (9,6)                                                               ,  /* Ｖレート１８ */
     vrate19                                            NUMBER      (9,6)                                                               ,  /* Ｖレート１９ */
     vrate20                                            NUMBER      (9,6)                                                               ,  /* Ｖレート２０ */
     vrate21                                            NUMBER      (9,6)                                                               ,  /* Ｖレート２１ */
     vrate22                                            NUMBER      (9,6)                                                               ,  /* Ｖレート２２ */
     vrate23                                            NUMBER      (9,6)                                                               ,  /* Ｖレート２３ */
     vrate24                                            NUMBER      (9,6)                                                               ,  /* Ｖレート２４ */
     vrate25                                            NUMBER      (9,6)                                                               ,  /* Ｖレート２５ */
     vrate26                                            NUMBER      (9,6)                                                               ,  /* Ｖレート２６ */
     vrate27                                            NUMBER      (9,6)                                                               ,  /* Ｖレート２７ */
     vrate28                                            NUMBER      (9,6)                                                               ,  /* Ｖレート２８ */
     vrate29                                            NUMBER      (9,6)                                                               ,  /* Ｖレート２９ */
     vrate30                                            NUMBER      (9,6)                                                               ,  /* Ｖレート３０ */
     vrate31                                            NUMBER      (9,6)                                                               ,  /* Ｖレート３１ */
     vrate32                                            NUMBER      (9,6)                                                               ,  /* Ｖレート３２ */
     vrate33                                            NUMBER      (9,6)                                                               ,  /* Ｖレート３３ */
     vrate34                                            NUMBER      (9,6)                                                               ,  /* Ｖレート３４ */
     vrate35                                            NUMBER      (9,6)                                                               ,  /* Ｖレート３５ */
     vrate36                                            NUMBER      (9,6)                                                               ,  /* Ｖレート３６ */
     vrate37                                            NUMBER      (9,6)                                                               ,  /* Ｖレート３７ */
     vrate38                                            NUMBER      (9,6)                                                               ,  /* Ｖレート３８ */
     vrate39                                            NUMBER      (9,6)                                                               ,  /* Ｖレート３９ */
     vrate40                                            NUMBER      (9,6)                                                               ,  /* Ｖレート４０ */
     vrate41                                            NUMBER      (9,6)                                                               ,  /* Ｖレート４１ */
     vrate42                                            NUMBER      (9,6)                                                               ,  /* Ｖレート４２ */
     vrate43                                            NUMBER      (9,6)                                                               ,  /* Ｖレート４３ */
     vrate44                                            NUMBER      (9,6)                                                               ,  /* Ｖレート４４ */
     vrate45                                            NUMBER      (9,6)                                                               ,  /* Ｖレート４５ */
     vrate46                                            NUMBER      (9,6)                                                               ,  /* Ｖレート４６ */
     vrate47                                            NUMBER      (9,6)                                                               ,  /* Ｖレート４７ */
     vrate48                                            NUMBER      (9,6)                                                               ,  /* Ｖレート４８ */
     vrate49                                            NUMBER      (9,6)                                                               ,  /* Ｖレート４９ */
     vrate50                                            NUMBER      (9,6)                                                               ,  /* Ｖレート５０ */
     vrate51                                            NUMBER      (9,6)                                                               ,  /* Ｖレート５１ */
     vrate52                                            NUMBER      (9,6)                                                               ,  /* Ｖレート５２ */
     vrate53                                            NUMBER      (9,6)                                                               ,  /* Ｖレート５３ */
     vrate54                                            NUMBER      (9,6)                                                               ,  /* Ｖレート５４ */
     vrate55                                            NUMBER      (9,6)                                                               ,  /* Ｖレート５５ */
     vrate56                                            NUMBER      (9,6)                                                               ,  /* Ｖレート５６ */
     vrate57                                            NUMBER      (9,6)                                                               ,  /* Ｖレート５７ */
     vrate58                                            NUMBER      (9,6)                                                               ,  /* Ｖレート５８ */
     vrate59                                            NUMBER      (9,6)                                                               ,  /* Ｖレート５９ */
     vrate60                                            NUMBER      (9,6)                                                               ,  /* Ｖレート６０ */
     vrate61                                            NUMBER      (9,6)                                                               ,  /* Ｖレート６１ */
     vrate62                                            NUMBER      (9,6)                                                               ,  /* Ｖレート６２ */
     vrate63                                            NUMBER      (9,6)                                                               ,  /* Ｖレート６３ */
     vrate64                                            NUMBER      (9,6)                                                               ,  /* Ｖレート６４ */
     vrate65                                            NUMBER      (9,6)                                                               ,  /* Ｖレート６５ */
     vrate66                                            NUMBER      (9,6)                                                               ,  /* Ｖレート６６ */
     vrate67                                            NUMBER      (9,6)                                                               ,  /* Ｖレート６７ */
     vrate68                                            NUMBER      (9,6)                                                               ,  /* Ｖレート６８ */
     vrate69                                            NUMBER      (9,6)                                                               ,  /* Ｖレート６９ */
     vrate70                                            NUMBER      (9,6)                                                               ,  /* Ｖレート７０ */
     vrate71                                            NUMBER      (9,6)                                                               ,  /* Ｖレート７１ */
     vrate72                                            NUMBER      (9,6)                                                               ,  /* Ｖレート７２ */
     vrate73                                            NUMBER      (9,6)                                                               ,  /* Ｖレート７３ */
     vrate74                                            NUMBER      (9,6)                                                               ,  /* Ｖレート７４ */
     vrate75                                            NUMBER      (9,6)                                                               ,  /* Ｖレート７５ */
     vrate76                                            NUMBER      (9,6)                                                               ,  /* Ｖレート７６ */
     vrate77                                            NUMBER      (9,6)                                                               ,  /* Ｖレート７７ */
     vrate78                                            NUMBER      (9,6)                                                               ,  /* Ｖレート７８ */
     vrate79                                            NUMBER      (9,6)                                                               ,  /* Ｖレート７９ */
     vrate80                                            NUMBER      (9,6)                                                               ,  /* Ｖレート８０ */
     vrate81                                            NUMBER      (9,6)                                                               ,  /* Ｖレート８１ */
     vrate82                                            NUMBER      (9,6)                                                               ,  /* Ｖレート８２ */
     vrate83                                            NUMBER      (9,6)                                                               ,  /* Ｖレート８３ */
     vrate84                                            NUMBER      (9,6)                                                               ,  /* Ｖレート８４ */
     vrate85                                            NUMBER      (9,6)                                                               ,  /* Ｖレート８５ */
     vrate86                                            NUMBER      (9,6)                                                               ,  /* Ｖレート８６ */
     vrate87                                            NUMBER      (9,6)                                                               ,  /* Ｖレート８７ */
     vrate88                                            NUMBER      (9,6)                                                               ,  /* Ｖレート８８ */
     vrate89                                            NUMBER      (9,6)                                                               ,  /* Ｖレート８９ */
     vrate90                                            NUMBER      (9,6)                                                               ,  /* Ｖレート９０ */
     vrate91                                            NUMBER      (9,6)                                                               ,  /* Ｖレート９１ */
     vrate92                                            NUMBER      (9,6)                                                               ,  /* Ｖレート９２ */
     vrate93                                            NUMBER      (9,6)                                                               ,  /* Ｖレート９３ */
     vrate94                                            NUMBER      (9,6)                                                               ,  /* Ｖレート９４ */
     vrate95                                            NUMBER      (9,6)                                                               ,  /* Ｖレート９５ */
     vrate96                                            NUMBER      (9,6)                                                               ,  /* Ｖレート９６ */
     vrate97                                            NUMBER      (9,6)                                                               ,  /* Ｖレート９７ */
     vrate98                                            NUMBER      (9,6)                                                               ,  /* Ｖレート９８ */
     vrate99                                            NUMBER      (9,6)                                                               ,  /* Ｖレート９９ */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE BM_RateV2 ADD CONSTRAINT PK_RateV2 PRIMARY KEY (
     palhokensyuruikigou                                      , /* ＰＡＬ保険種類記号 */
     palhokensyuruikigousdicode                               , /* ＰＡＬ保険種類記号世代コード */
     palyoteiriritu                                           , /* ＰＡＬ予定利率 */
     palpmencode                                              , /* ＰＡＬＰ免コード */
     palharaikomikaisuu                                       , /* ＰＡＬ払込回数 */
     palhhknsei                                               , /* ＰＡＬ被保険者性別 */
     palkeiyakujihhknnen                                      , /* ＰＡＬ契約時被保険者年令 */
     palsaimankihyouji                                        , /* ＰＡＬ才満期契約表示 */
     palhokenkikan                                            , /* ＰＡＬ保険期間 */
     palpharaikomikikan                                       , /* ＰＡＬＰ払込期間 */
     palannaihuyouriyuukbn                                    , /* ＰＡＬ案内不要理由区分 */
     ratetuukasyukbn                                          , /* レート用通貨種類区分 */
     ratedai1hknkkn                                             /* レート用第１保険期間 */
) ;
