CREATE TABLE ZT_RatewRn (
     zrnhknsyukigou                                     CHAR        (2)                                                       NOT NULL  ,  /* （連携用）保険種類記号 */
     zrnhknsyuruikigousedaikbn                          CHAR        (1)                                                       NOT NULL  ,  /* （連携用）保険種類記号世代区分 */
     zrnyoteiriritu                                     CHAR        (3)                                                       NOT NULL  ,  /* （連携用）予定利率 */
     zrnpmenkbn                                         CHAR        (1)                                                       NOT NULL  ,  /* （連携用）Ｐ免区分 */
     zrnhrkkaisuukbn                                    CHAR        (1)                                                       NOT NULL  ,  /* （連携用）払込回数区分 */
     zrnhhknsei                                         CHAR        (1)                                                       NOT NULL  ,  /* （連携用）被保険者性別 */
     zrnkeiyakujihhknnen                                CHAR        (3)                                                       NOT NULL  ,  /* （連携用）契約時被保険者年令 */
     zrnsaimnkkykhyj                                    CHAR        (1)                                                       NOT NULL  ,  /* （連携用）才満期契約表示 */
     zrnhknkkn                                          CHAR        (2)                                                       NOT NULL  ,  /* （連携用）保険期間 */
     zrnphrkkikn                                        CHAR        (2)                                                       NOT NULL  ,  /* （連携用）Ｐ払込期間 */
     zrnannaifuyouriyuukbn                              CHAR        (2)                                                       NOT NULL  ,  /* （連携用）案内不要理由区分 */
     zrntuukasyukbn                                     CHAR        (1)                                                       NOT NULL  ,  /* （連携用）通貨種類区分 */
     zrndai1hknkkn                                      CHAR        (2)                                                       NOT NULL  ,  /* （連携用）第１保険期間 */
     zrnwrate00                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート００ */
     zrnwrate01                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート０１ */
     zrnwrate02                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート０２ */
     zrnwrate03                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート０３ */
     zrnwrate04                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート０４ */
     zrnwrate05                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート０５ */
     zrnwrate06                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート０６ */
     zrnwrate07                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート０７ */
     zrnwrate08                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート０８ */
     zrnwrate09                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート０９ */
     zrnwrate10                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート１０ */
     zrnwrate11                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート１１ */
     zrnwrate12                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート１２ */
     zrnwrate13                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート１３ */
     zrnwrate14                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート１４ */
     zrnwrate15                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート１５ */
     zrnwrate16                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート１６ */
     zrnwrate17                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート１７ */
     zrnwrate18                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート１８ */
     zrnwrate19                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート１９ */
     zrnwrate20                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート２０ */
     zrnwrate21                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート２１ */
     zrnwrate22                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート２２ */
     zrnwrate23                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート２３ */
     zrnwrate24                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート２４ */
     zrnwrate25                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート２５ */
     zrnwrate26                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート２６ */
     zrnwrate27                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート２７ */
     zrnwrate28                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート２８ */
     zrnwrate29                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート２９ */
     zrnwrate30                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート３０ */
     zrnwrate31                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート３１ */
     zrnwrate32                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート３２ */
     zrnwrate33                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート３３ */
     zrnwrate34                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート３４ */
     zrnwrate35                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート３５ */
     zrnwrate36                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート３６ */
     zrnwrate37                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート３７ */
     zrnwrate38                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート３８ */
     zrnwrate39                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート３９ */
     zrnwrate40                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート４０ */
     zrnwrate41                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート４１ */
     zrnwrate42                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート４２ */
     zrnwrate43                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート４３ */
     zrnwrate44                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート４４ */
     zrnwrate45                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート４５ */
     zrnwrate46                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート４６ */
     zrnwrate47                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート４７ */
     zrnwrate48                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート４８ */
     zrnwrate49                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート４９ */
     zrnwrate50                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート５０ */
     zrnwrate51                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート５１ */
     zrnwrate52                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート５２ */
     zrnwrate53                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート５３ */
     zrnwrate54                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート５４ */
     zrnwrate55                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート５５ */
     zrnwrate56                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート５６ */
     zrnwrate57                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート５７ */
     zrnwrate58                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート５８ */
     zrnwrate59                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート５９ */
     zrnwrate60                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート６０ */
     zrnwrate61                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート６１ */
     zrnwrate62                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート６２ */
     zrnwrate63                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート６３ */
     zrnwrate64                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート６４ */
     zrnwrate65                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート６５ */
     zrnwrate66                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート６６ */
     zrnwrate67                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート６７ */
     zrnwrate68                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート６８ */
     zrnwrate69                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート６９ */
     zrnwrate70                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート７０ */
     zrnwrate71                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート７１ */
     zrnwrate72                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート７２ */
     zrnwrate73                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート７３ */
     zrnwrate74                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート７４ */
     zrnwrate75                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート７５ */
     zrnwrate76                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート７６ */
     zrnwrate77                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート７７ */
     zrnwrate78                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート７８ */
     zrnwrate79                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート７９ */
     zrnwrate80                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート８０ */
     zrnwrate81                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート８１ */
     zrnwrate82                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート８２ */
     zrnwrate83                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート８３ */
     zrnwrate84                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート８４ */
     zrnwrate85                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート８５ */
     zrnwrate86                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート８６ */
     zrnwrate87                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート８７ */
     zrnwrate88                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート８８ */
     zrnwrate89                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート８９ */
     zrnwrate90                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート９０ */
     zrnwrate91                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート９１ */
     zrnwrate92                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート９２ */
     zrnwrate93                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート９３ */
     zrnwrate94                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート９４ */
     zrnwrate95                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート９５ */
     zrnwrate96                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート９６ */
     zrnwrate97                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート９７ */
     zrnwrate98                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート９８ */
     zrnwrate99                                         NUMBER      (9,6)                                                     NOT NULL     /* （連携用）Ｗレート９９ */
)
;

ALTER TABLE ZT_RatewRn ADD CONSTRAINT PK_RatewRn PRIMARY KEY (
     zrnhknsyukigou                                           , /* （連携用）保険種類記号 */
     zrnhknsyuruikigousedaikbn                                , /* （連携用）保険種類記号世代区分 */
     zrnyoteiriritu                                           , /* （連携用）予定利率 */
     zrnpmenkbn                                               , /* （連携用）Ｐ免区分 */
     zrnhrkkaisuukbn                                          , /* （連携用）払込回数区分 */
     zrnhhknsei                                               , /* （連携用）被保険者性別 */
     zrnkeiyakujihhknnen                                      , /* （連携用）契約時被保険者年令 */
     zrnsaimnkkykhyj                                          , /* （連携用）才満期契約表示 */
     zrnhknkkn                                                , /* （連携用）保険期間 */
     zrnphrkkikn                                              , /* （連携用）Ｐ払込期間 */
     zrnannaifuyouriyuukbn                                    , /* （連携用）案内不要理由区分 */
     zrntuukasyukbn                                           , /* （連携用）通貨種類区分 */
     zrndai1hknkkn                                              /* （連携用）第１保険期間 */
) ;
