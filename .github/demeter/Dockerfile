FROM gradle:7.6-jdk17
EXPOSE 3939:3939

COPY --chown=gradle:gradle . /app

WORKDIR /app

RUN gradle :newm-chain:build --no-daemon