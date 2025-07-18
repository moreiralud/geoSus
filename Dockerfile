FROM ubuntu:latest
LABEL authors="ludmilamoreira"

ENTRYPOINT ["top", "-b"]