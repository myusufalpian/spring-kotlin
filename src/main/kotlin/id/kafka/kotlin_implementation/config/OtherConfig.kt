package id.kafka.kotlin_implementation.config

import org.modelmapper.ModelMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class OtherConfig {
    @Bean
    fun modelMapper(): ModelMapper {
        return ModelMapper()
    }
}